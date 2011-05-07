package lt.sklandymas.mamavys.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Person implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	private String firstName;
	
	private String lastName;
	
	public Key getKey() {
		return key;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
