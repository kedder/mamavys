package lt.sklandymas.mamavys.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.google.appengine.api.datastore.Key;

@Entity
public class FlightDayEntry implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	@ManyToOne(fetch=FetchType.LAZY)
	private AircraftFlightDay aicraftDay;

	private Key pilotKey;
	
	@Transient
	private Person pilot;
	
	private Key studentKey;
	
	@Transient
	private Person student;
	
	private Date takeoffTime;
	
	private Date landingTime;
	
	private Key relatedEntryKey;
	
	@Transient
	private FlightDayEntry relatedEntry;
	
	public AircraftFlightDay getAicraftDay() {
		return aicraftDay;
	}

	public void setAicraftDay(AircraftFlightDay aicraftDay) {
		this.aicraftDay = aicraftDay;
	}

	public Key getPilotKey() {
		return pilotKey;
	}

	public void setPilotKey(Key pilotKey) {
		this.pilotKey = pilotKey;
	}

	public Key getStudentKey() {
		return studentKey;
	}

	public void setStudentKey(Key studentKey) {
		this.studentKey = studentKey;
	}

	public Date getTakeoffTime() {
		return takeoffTime;
	}

	public void setTakeoffTime(Date takeoffTime) {
		this.takeoffTime = takeoffTime;
	}

	public Date getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(Date landingTime) {
		this.landingTime = landingTime;
	}

	public Key getRelatedEntryKey() {
		return relatedEntryKey;
	}

	public void setRelatedEntryKey(Key relatedEntryKey) {
		this.relatedEntryKey = relatedEntryKey;
	}

	public Key getKey() {
		return key;
	}

	public Person getPilot() {
		return pilot;
	}

	public void setPilot(Person pilot) {
		this.pilot = pilot;
		if (pilot != null) {
			setPilotKey(pilot.getKey());
		}
	}

	public Person getStudent() {
		return student;
	}

	public void setStudent(Person student) {
		this.student = student;
		if (student != null) {
			setStudentKey(student.getKey());
		}
	}

	public FlightDayEntry getRelatedEntry() {
		return relatedEntry;
	}

	public void setRelatedEntry(FlightDayEntry relatedEntry) {
		this.relatedEntry = relatedEntry;
		if (relatedEntry != null) {
			setRelatedEntryKey(relatedEntry.getKey());
		}
	}
}
