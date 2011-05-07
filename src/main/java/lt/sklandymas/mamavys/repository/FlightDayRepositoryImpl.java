package lt.sklandymas.mamavys.repository;

import org.springframework.stereotype.Repository;

import lt.sklandymas.mamavys.domain.FlightDay;

@Repository
public class FlightDayRepositoryImpl extends GenericRepositoryImpl<FlightDay> implements FlightDayRepository {

	@Override
	public Class<FlightDay> getEntityClass() {
		return FlightDay.class;
	}
}
