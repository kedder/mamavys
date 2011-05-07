package lt.sklandymas.mamavys.web.person;

import lt.sklandymas.mamavys.domain.Person;
import lt.sklandymas.mamavys.repository.PersonRepository;
import lt.sklandymas.mamavys.web.BasePage;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class PersonEditPage extends BasePage {
	@SpringBean
	private PersonRepository personRepository;

	public PersonEditPage(PageParameters parameters) {
		super(parameters);
		init(new Model<Person>(new Person()));
	}
	
	public void init(IModel<Person> model) {
		final Form<Person> form = new Form<Person>("personForm", new CompoundPropertyModel<Person>(model));
		add(form);
		
		form.add(new RequiredTextField<String>("firstName"));
		form.add(new RequiredTextField<String>("lastName"));
		
		form.add(new Button("save") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				onSavePressed(form.getModelObject());
				setResponsePage(PeoplePage.class);
			}
		});
	}

	protected void onSavePressed(Person person) {
		personRepository.save(person);
	}
	
}
