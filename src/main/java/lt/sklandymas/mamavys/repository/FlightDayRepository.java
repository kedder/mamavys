package lt.sklandymas.mamavys.repository;

import java.util.Date;

import lt.sklandymas.mamavys.domain.FlightDay;

public interface FlightDayRepository extends GenericRepository<FlightDay> {
	/**
	 * Return flight day for given date, or null, if no such flight day found.
	 * 
	 * @param date
	 * @return
	 */
	FlightDay getFlightDay(Date date);
}
