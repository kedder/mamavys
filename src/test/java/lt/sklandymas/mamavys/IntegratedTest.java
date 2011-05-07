package lt.sklandymas.mamavys;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:META-INF/*-beans.xml")
//@Transactional
public abstract class IntegratedTest {
    private static final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
    
//    @Autowired
//    private PlatformTransactionManager txManager;

	@BeforeClass
	public static void setUpClass() {
//		helper.setUp();
	}

	@Before
	public void setUp() {
		helper.setUp();
//		TransactionDefinition def = new DefaultTransactionDefinition();
//		txManager.getTransaction(def);
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("main");
		// em = emf.createEntityManager();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

}
