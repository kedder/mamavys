package lt.sklandymas.mamavys.web.aircraft;

import java.util.ArrayList;
import java.util.List;

import lt.sklandymas.mamavys.domain.Aircraft;
import lt.sklandymas.mamavys.repository.AircraftRepository;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class AircraftField extends DropDownChoice<Aircraft> {
	@SpringBean
	private AircraftRepository aircraftRepository;
	
	public AircraftField(String id) {
		super(id);
		init();
	}

	public AircraftField(String id, IModel<Aircraft> model) {
		super(id);
		setModel(model);
		init();
	}

	private void init() {
		setChoices(new PropertyModel<List<Aircraft>>(this, "listAircrafts"));
		setChoiceRenderer(new ChoiceRenderer<Aircraft>("displayValue", "regNumber"));
	}
	
	public List<Aircraft> listAircrafts() {
		return new ArrayList<Aircraft>(aircraftRepository.findAll());
	}

}
