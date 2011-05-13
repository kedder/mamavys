package lt.sklandymas.mamavys.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class AircraftFlightDay implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	@Column(nullable=false)
	private Key aircraftKey;

	@ManyToOne(fetch=FetchType.LAZY)
	private FlightDay day;
	
	@OneToMany(mappedBy="aicraftDay", cascade=CascadeType.ALL)
	private Set<FlightDayEntry> entries = new HashSet<FlightDayEntry>();

	public AircraftFlightDay() {
		super();
	}

	public AircraftFlightDay(Aircraft aircraft) {
		super();
		this.aircraftKey = aircraft.getKey();
	}

	public Key getAircraftKey() {
		return aircraftKey;
	}

	public void setAircraftKey(Key aircraftKey) {
		this.aircraftKey = aircraftKey;
	}

	public FlightDay getDay() {
		return day;
	}

	public void setDay(FlightDay day) {
		this.day = day;
	}

	public Key getKey() {
		return key;
	}

	public Set<FlightDayEntry> getEntries() {
		return entries;
	}
}
