package lt.sklandymas.mamavys.repository;

import lt.sklandymas.mamavys.IntegratedTest;
import lt.sklandymas.mamavys.domain.Person;
import lt.sklandymas.mamavys.repository.PersonRepository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonRepositoryTest extends IntegratedTest {

	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void testSave() {
		Person p = new Person();
		Person saved = personRepository.save(p);
		
		Assert.assertNotNull(saved);
		Assert.assertNotNull(saved.getKey());
	}
}
