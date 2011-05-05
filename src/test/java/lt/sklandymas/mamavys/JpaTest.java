package lt.sklandymas.mamavys;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import junit.framework.Assert;
import lt.sklandymas.mamavys.domain.Person;

import org.junit.Test;

public class JpaTest extends IntegratedTest {

	@PersistenceContext
	private EntityManager em;

 
	@Test
    public void testPersonPersistance() {
    	Person p = new Person();
    	em.persist(p);
    	p = em.merge(p);
    	
    	Person found = em.find(Person.class, p.getKey());
    	Assert.assertNotNull(found);    	
    }
    
}
