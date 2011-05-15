package lt.sklandymas.mamavys.web.daily;

import lt.sklandymas.mamavys.domain.FlightDayEntry;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class LogEntryForm extends Panel {
	public LogEntryForm(String id, IModel<FlightDayEntry> model) {
		super(id);
		setOutputMarkupId(true);
		
		Form<Void> form = new Form<Void>("entryForm");
		add(form);
		
		
	}
	
	abstract void onConfirm(AjaxRequestTarget target, FlightDayEntry entry);
}