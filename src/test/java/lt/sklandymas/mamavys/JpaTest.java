package lt.sklandymas.mamavys;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import junit.framework.Assert;

import lt.sklandymas.mamavys.domain.Person;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class JpaTest {

    private final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
    
	private EntityManager em;

    @Before
    public void setUp() { 
    	helper.setUp();
        
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("main");
    	em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
    	helper.tearDown();
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void testPersonPersistance() {
    	em.getTransaction().begin();
    	Person p = new Person();
    	em.persist(p);
    	em.getTransaction().commit();
    	
    	Query q = em.createQuery("Select p from Person p");
    	List<Person> res = q.getResultList();
    	
    	Assert.assertEquals(1, res.size());
    }
    
}
