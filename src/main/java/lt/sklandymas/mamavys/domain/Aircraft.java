package lt.sklandymas.mamavys.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Aircraft implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String model;
	
	private String regNumber;
	
	public Key getKey() {
		return key;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
}
