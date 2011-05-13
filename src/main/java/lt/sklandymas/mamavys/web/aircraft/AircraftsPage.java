package lt.sklandymas.mamavys.web.aircraft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lt.sklandymas.mamavys.domain.Aircraft;
import lt.sklandymas.mamavys.repository.AircraftRepository;
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

public class AircraftsPage extends BasePage {
	@SpringBean
	private AircraftRepository aircraftRepository;

	public AircraftsPage(PageParameters parameters) {
		super(parameters);
		
		add(new Link<Void>("newAircraft") {
			@Override
			public void onClick() {
				setResponsePage(AircraftEditPage.class);
			}
		});
		
		add(createPeopleTable("aircrafts"));
	}

	private DefaultDataTable<Aircraft> createPeopleTable(String id) {
		List<IColumn<Aircraft>> columns = new ArrayList<IColumn<Aircraft>>();
		columns.add(new PropertyColumn<Aircraft>(new Model<String>("Model"), "model"));
		columns.add(new PropertyColumn<Aircraft>(new Model<String>("Registration number"), "regNumber"));
		
		ISortableDataProvider<Aircraft> dataProvider = new SortableDataProvider<Aircraft>() {
			@Override
			public Iterator<Aircraft> iterator(int first, int count) {
				return aircraftRepository.findAll().subList(first, first + count).iterator();
			}

			@Override
			public int size() {
				return aircraftRepository.findAll().size();
			}

			@Override
			public IModel<Aircraft> model(Aircraft object) {
				return new Model<Aircraft>(object);
			}
		};
		return new DefaultDataTable<Aircraft>(id, columns, dataProvider, 40);
	}
}
