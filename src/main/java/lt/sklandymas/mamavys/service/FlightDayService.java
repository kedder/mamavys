package lt.sklandymas.mamavys.service;

import java.util.Date;

import lt.sklandymas.mamavys.domain.Aircraft;
import lt.sklandymas.mamavys.domain.FlightDay;

public interface FlightDayService {
	/**
	 * Return flight day for given date, or create new one.
	 * 
	 * @param date
	 * @return
	 */
	FlightDay getOrCreateFlightDay(Date date);
	
	/**
	 * Create new log for given aircraft for the day.
	 * 
	 * @param day
	 * @param aircraft
	 * @return
	 */
	FlightDay createLogForAircraft(FlightDay day, Aircraft aircraft);
}
