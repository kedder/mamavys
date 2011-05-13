package lt.sklandymas.mamavys.web.aircraft;

import lt.sklandymas.mamavys.domain.Aircraft;
import lt.sklandymas.mamavys.repository.AircraftRepository;
import lt.sklandymas.mamavys.web.BasePage;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class AircraftEditPage extends BasePage {
	@SpringBean
	private AircraftRepository AircraftRepository;

	public AircraftEditPage(PageParameters parameters) {
		super(parameters);
		init(new Model<Aircraft>(new Aircraft()));
	}
	
	public void init(IModel<Aircraft> model) {
		final Form<Aircraft> form = new Form<Aircraft>("aircraftForm", new CompoundPropertyModel<Aircraft>(model));
		add(form);
		
		form.add(new RequiredTextField<String>("model"));
		form.add(new RequiredTextField<String>("regNumber"));
		
		form.add(new Button("save") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				onSavePressed(form.getModelObject());
				setResponsePage(AircraftsPage.class);
			}
		});
	}

	protected void onSavePressed(Aircraft aircraft) {
		AircraftRepository.save(aircraft);
	}
	
}
