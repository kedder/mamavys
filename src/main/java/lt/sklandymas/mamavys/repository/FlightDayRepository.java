package lt.sklandymas.mamavys.repository;

import java.util.Date;

import lt.sklandymas.mamavys.domain.FlightDay;
import lt.sklandymas.mamavys.domain.FlightDayEntry;

public interface FlightDayRepository extends GenericRepository<FlightDay> {
	/**
	 * Return flight day for given date, or null, if no such flight day found.
	 * 
	 * @param date
	 * @return
	 */
	FlightDay getFlightDay(Date date);
	
	void loadFlightDayEntryReferences(FlightDayEntry entry);
	
}
