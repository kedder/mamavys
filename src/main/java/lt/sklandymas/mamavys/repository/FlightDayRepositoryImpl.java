package lt.sklandymas.mamavys.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import lt.sklandymas.mamavys.domain.FlightDay;
import lt.sklandymas.mamavys.domain.FlightDayEntry;
import lt.sklandymas.mamavys.domain.Person;

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

	@Override
	public void loadFlightDayEntryReferences(FlightDayEntry entry) {
		EntityManager em = getEntityManager();
		
		if (entry.getPilotKey() != null) {
			entry.setPilot(em.find(Person.class, entry.getPilotKey()));
		}
		if (entry.getStudentKey() != null) {
			entry.setStudent(em.find(Person.class, entry.getStudentKey()));
		}
		if (entry.getRelatedEntryKey() != null) {
			entry.setRelatedEntry(em.find(FlightDayEntry.class, entry.getRelatedEntryKey()));
		}
	}
}
