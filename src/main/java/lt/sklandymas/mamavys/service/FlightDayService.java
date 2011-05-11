package lt.sklandymas.mamavys.service;

import java.util.Date;

import lt.sklandymas.mamavys.domain.FlightDay;

public interface FlightDayService {
	/**
	 * Return flight day for given date, or create new one.
	 * 
	 * @param date
	 * @return
	 */
	FlightDay getOrCreateFlightDay(Date date);
}
