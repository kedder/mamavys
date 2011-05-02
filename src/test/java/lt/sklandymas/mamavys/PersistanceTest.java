package lt.sklandymas.mamavys;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class PersistanceTest {

    private final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    @Before
    public void setUp() {
    	helper.setUp();
    }
    
    @After
    public void tearDown() {
    	helper.tearDown();
    }
    
    // run this test twice to prove we're not leaking any state across tests
    private void doTest() {
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Assert.assertEquals(0, ds.prepare(new Query("yam")).countEntities(FetchOptions.Builder.withLimit(10)));
        ds.put(new Entity("yam"));
        ds.put(new Entity("yam"));
        Assert.assertEquals(2, ds.prepare(new Query("yam")).countEntities(FetchOptions.Builder.withLimit(10)));
    }

    @Test
    public void testInsert1() {
        doTest();
    }

    @Test
    public void testInsert2() {
        doTest();
    }

}
