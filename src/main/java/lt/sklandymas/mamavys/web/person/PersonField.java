package lt.sklandymas.mamavys.web.person;

import java.util.ArrayList;
import java.util.List;

import lt.sklandymas.mamavys.domain.Person;
import lt.sklandymas.mamavys.repository.PersonRepository;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class PersonField extends DropDownChoice<Person> {
	@SpringBean
	private PersonRepository personRepository;
	
	public PersonField(String id) {
		super(id);
		init();
	}

	public PersonField(String id, IModel<Person> model) {
		super(id);
		setModel(model);
		init();
	}

	private void init() {
		setChoices(new PropertyModel<List<Person>>(this, "listPeople"));
		setChoiceRenderer(new ChoiceRenderer<Person>("displayValue", "regNumber"));
	}
	
	public List<Person> listPeople() {
		return new ArrayList<Person>(personRepository.findAll());
	}
}
