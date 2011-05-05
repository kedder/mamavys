package lt.sklandymas.mamavys.repository;

import lt.sklandymas.mamavys.domain.Person;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonRepositoryImpl extends GenericRepositoryImpl<Person> implements PersonRepository {

	@Override
	public Class<Person> getEntityClass() {
		return Person.class;
	}

}
