package lt.sklandymas.mamavys.repository;

import java.util.Date;

import lt.sklandymas.mamavys.IntegratedTest;
import lt.sklandymas.mamavys.domain.AircraftFlightDay;
import lt.sklandymas.mamavys.domain.FlightDay;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FlightDayRepositoryTest extends IntegratedTest {

	@Autowired
	private FlightDayRepository flightDayRepository;
	
	@Test
	public void testSave() {
		AircraftFlightDay afd = new AircraftFlightDay();
		
		FlightDay day = new FlightDay();
		day.setDate(new Date());
		day.getAircrafts().add(afd);
		
		FlightDay saved = flightDayRepository.save(day );
		
		Assert.assertNotNull(saved);
		Assert.assertNotNull(saved.getKey());
		
		AircraftFlightDay afdSaved = saved.getAircrafts().iterator().next();
		Assert.assertNotNull(afdSaved.getKey());
		Assert.assertEquals(day, afdSaved.getDay());
	}
	
}
