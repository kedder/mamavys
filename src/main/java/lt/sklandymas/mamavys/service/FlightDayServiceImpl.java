package lt.sklandymas.mamavys.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.sklandymas.mamavys.domain.FlightDay;
import lt.sklandymas.mamavys.repository.FlightDayRepository;

@Service
public class FlightDayServiceImpl implements FlightDayService {

	@Autowired
	private FlightDayRepository flightDayRepository;
	
	@Override
	public FlightDay getOrCreateFlightDay(Date date) {
		FlightDay day = flightDayRepository.getFlightDay(date);
		if (day == null) {
			day = new FlightDay();
			day.setDate(date);
			day = flightDayRepository.save(day);
		}
		return day;
	}

}
