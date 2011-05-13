package lt.sklandymas.mamavys.web.daily;

import lt.sklandymas.mamavys.domain.FlightDay;
import lt.sklandymas.mamavys.web.BasePage;

public class DayPage extends BasePage {

	private final FlightDay day;

	public DayPage(FlightDay day) {
		this.day = day;
	}

	
	/*
	public DayPage(PageParameters parameters) {
		super(parameters);
	}
	*/

}
