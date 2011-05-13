package lt.sklandymas.mamavys.web.daily;

import java.util.Date;
import java.util.List;

import lt.sklandymas.mamavys.domain.FlightDay;
import lt.sklandymas.mamavys.repository.FlightDayRepository;
import lt.sklandymas.mamavys.service.FlightDayService;
import lt.sklandymas.mamavys.web.BasePage;

import org.apache.wicket.PageParameters;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.extensions.yui.calendar.DateField;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class CalendarPage extends BasePage {
	@SpringBean
	private FlightDayRepository flightDayRepository;
	
	@SpringBean
	private FlightDayService flightDayService;
	
	private Date newDayDate = null;
	
	public CalendarPage(PageParameters parameters) {
		super(parameters);
		
		Form<Void> newDayForm = createNewDayForm("newDayForm");
		add(newDayForm);
		
		DataView<FlightDay> daysview = createDaysDataView("days");
		add(daysview);
	}

	private Form<Void> createNewDayForm(String id) {
		Form<Void> form = new Form<Void>(id);
		
		DateField dateField = new DateField("date", new PropertyModel<Date>(this, "newDayDate"));
		form.add(dateField);
		
		Button createButton = new Button("create") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				createFlightDay(newDayDate);
				setResponsePage(CalendarPage.class);
			}
		};
		form.add(createButton);
		
		return form;
	}

	protected void createFlightDay(Date newDayDate) {
		flightDayService.getOrCreateFlightDay(newDayDate);
	}

	private DataView<FlightDay> createDaysDataView(String id) {
		List<FlightDay> days = flightDayRepository.findAll();
		
		IDataProvider<FlightDay> provider = new ListDataProvider<FlightDay>(days);
		
		DataView<FlightDay> daysview = new DataView<FlightDay>(id, provider) {
			@Override
			protected void populateItem(Item<FlightDay> item) {
				Link<FlightDay> link = new Link<FlightDay>("dayLink", item.getModel()) {
					@Override
					public void onClick() {
						setResponsePage(new DayPage(getModelObject()));
					}
				};
				link.add(DateLabel.forShortStyle("date", new PropertyModel<Date>(item.getModel(), "date")));
				
				item.add(link);
			}
		};
		return daysview;
	}
}
