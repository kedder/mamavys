package lt.sklandymas.mamavys.repository;

import org.springframework.stereotype.Repository;

import lt.sklandymas.mamavys.domain.Aircraft;

@Repository
public class AircraftRepositoryImpl extends GenericRepositoryImpl<Aircraft> implements
		AircraftRepository {

	@Override
	public Class<Aircraft> getEntityClass() {
		return Aircraft.class;
	}

}
