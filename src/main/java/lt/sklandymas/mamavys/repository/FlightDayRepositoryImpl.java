package lt.sklandymas.mamavys.repository;

import java.util.Date;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import lt.sklandymas.mamavys.domain.FlightDay;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FlightDayRepositoryImpl extends GenericRepositoryImpl<FlightDay> implements FlightDayRepository {

	@Override
	public Class<FlightDay> getEntityClass() {
		return FlightDay.class;
	}

	@Override
	public FlightDay getFlightDay(Date date) {
		Query q = getEntityManager().createNamedQuery("byDate");
		q.setParameter("date", date);

		try {
			return (FlightDay) q.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
	}
}
