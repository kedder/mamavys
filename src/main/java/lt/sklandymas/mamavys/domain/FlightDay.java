package lt.sklandymas.mamavys.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
@NamedQuery(
		name = "byDate", 
		query = "SELECT o FROM FlightDay o WHERE o.date = :date")
public class FlightDay implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	@Column(nullable=false)
	private Date date;
	
	@OneToMany(mappedBy="day", cascade=CascadeType.PERSIST)
	private Set<AircraftFlightDay> aircrafts = new HashSet<AircraftFlightDay>();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Key getKey() {
		return key;
	}

	public Set<AircraftFlightDay> getAircrafts() {
		return aircrafts;
	}
}
