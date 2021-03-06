package lt.sklandymas.mamavys.web.daily;

import java.util.ArrayList;
import java.util.List;

import lt.sklandymas.mamavys.domain.Aircraft;
import lt.sklandymas.mamavys.domain.AircraftFlightDay;
import lt.sklandymas.mamavys.domain.FlightDay;
import lt.sklandymas.mamavys.domain.FlightDayEntry;
import lt.sklandymas.mamavys.repository.AircraftRepository;
import lt.sklandymas.mamavys.repository.FlightDayRepository;
import lt.sklandymas.mamavys.service.FlightDayService;
import lt.sklandymas.mamavys.web.BasePage;
import lt.sklandymas.mamavys.web.aircraft.AircraftField;

import org.apache.wicket.Component;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class DayPage extends BasePage {
	
	@SpringBean
	private AircraftRepository aircraftRepository;
	
	@SpringBean
	private FlightDayRepository flightDayRepository;
	
	@SpringBean
	private FlightDayService flightDayService;

	private FlightDay day;
	
	private Aircraft newAircraft;

	public DayPage(PageParameters parameters) {
		super(parameters);
		this.day = flightDayRepository.getByKey(parameters.getString("key"));

		add(createNewAircraftForm("newAircraftForm"));
		
		add(createAircraftListDataView("aircraftList"));
	}

	private Component createAircraftListDataView(String id) {
		List<AircraftFlightDay> aircrafts = new ArrayList<AircraftFlightDay>(day.getAircrafts());
		IDataProvider<AircraftFlightDay> provider = new ListDataProvider<AircraftFlightDay>(aircrafts);
		
		DataView<AircraftFlightDay> aircraftList = new DataView<AircraftFlightDay>(id, provider) {
			@Override
			protected void populateItem(Item<AircraftFlightDay> item) {
				createAircaftDayView(item);
			}

		};
		return aircraftList;
	}

	private Form<Void> createNewAircraftForm(String id) {
		Form<Void> form = new Form<Void>(id);
		
		form.add(new AircraftField ("aircraft", new PropertyModel<Aircraft>(this, "newAircraft")));
	
		Button register = new Button("register") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				registerNewAircraft(newAircraft);
				setResponsePage(DayPage.class, getPageParameters());
			}
		};
		form.add(register);
		
		return form;
	}

	private void registerNewAircraft(Aircraft aircraft) {
		day = flightDayService.createLogForAircraft(day, newAircraft);
	}

	private void createAircaftDayView(final Item<AircraftFlightDay> container) {
		final AircraftFlightDay aircraftDay = container.getModelObject();
		Aircraft aircraft = aircraftRepository.getByKey(aircraftDay.getAircraftKey());
		
		container.add(new Label("aircraft", aircraft.getDisplayValue()));
		container.add(new EmptyPanel("logEntryForm").setOutputMarkupId(true));
		
		AjaxLink<AircraftFlightDay> newEntry = new AjaxLink<AircraftFlightDay>("newEntry", container.getModel()) {
			@Override
			public void onClick(AjaxRequestTarget target) {
				FlightDayEntry entry = new FlightDayEntry();
				LogEntryForm entryForm = new LogEntryForm("logEntryForm", new Model<FlightDayEntry>(entry)) {
					@Override
					void onConfirm(AjaxRequestTarget target, FlightDayEntry entry) {
						aircraftDay.getEntries().add(entry);
						flightDayRepository.save(day);
						setVisible(false);
						target.addComponent(this);
					}
				};
				container.replace(entryForm);
				target.addComponent(entryForm);
			}
		};
		container.add(newEntry);
	}

}
