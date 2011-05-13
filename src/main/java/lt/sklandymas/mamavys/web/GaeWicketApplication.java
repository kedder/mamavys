package lt.sklandymas.mamavys.web;

import lt.sklandymas.mamavys.web.aircraft.AircraftsPage;
import lt.sklandymas.mamavys.web.daily.CalendarPage;
import lt.sklandymas.mamavys.web.person.PeoplePage;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.HttpSessionStore;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.session.ISessionStore;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class GaeWicketApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
      return HomePage.class;
    }

    @Override
    protected void init() {
      super.init();
      getResourceSettings().setResourcePollFrequency(null);

      addComponentInstantiationListener(new SpringComponentInjector(this));
      
      mountBookmarkablePage("/people", PeoplePage.class);
      mountBookmarkablePage("/aircrafts", AircraftsPage.class);
      mountBookmarkablePage("/calendar", CalendarPage.class);
    }

    @Override
    protected ISessionStore newSessionStore() {
      return new HttpSessionStore(this);
    }
}
