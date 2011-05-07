package lt.sklandymas.mamavys.web.person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lt.sklandymas.mamavys.domain.Person;
import lt.sklandymas.mamavys.repository.PersonRepository;
import lt.sklandymas.mamavys.web.BasePage;

import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class PeoplePage extends BasePage {
	@SpringBean
	private PersonRepository personRepository;

	public PeoplePage(PageParameters parameters) {
		super(parameters);
		
		add(new Link<Void>("newPerson") {
			@Override
			public void onClick() {
				setResponsePage(PersonEditPage.class);
			}
		});
		
		add(createPeopleTable("people"));
	}

	private DefaultDataTable<Person> createPeopleTable(String id) {
		List<IColumn<Person>> columns = new ArrayList<IColumn<Person>>();
		columns.add(new PropertyColumn<Person>(new Model<String>("First Name"), "firstName"));
		columns.add(new PropertyColumn<Person>(new Model<String>("Last Name"), "lastName"));
		
		ISortableDataProvider<Person> dataProvider = new SortableDataProvider<Person>() {
			@Override
			public Iterator<? extends Person> iterator(int first, int count) {
				return personRepository.findAll().subList(first, first + count).iterator();
			}

			@Override
			public int size() {
				return personRepository.findAll().size();
			}

			@Override
			public IModel<Person> model(Person object) {
				return new Model<Person>(object);
			}
		};
		return new DefaultDataTable<Person>(id, columns, dataProvider, 40);
	}
}
