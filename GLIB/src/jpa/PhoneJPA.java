package jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GLIB.phones")
public class PhoneJPA implements Serializable{

	private static final long serialVersionUID = 2990016256638111583L;

	@Id
	private long id;
	
	@Column(nullable = false, length=12)
	private String number;
	
	/**
	 * Default constructor
	 */
	public PhoneJPA()
	{		
	}
	
	/**
	 * Constructor that sets the phone number, storing it into the appropiate attribute
	 * @param number
	 */
	public PhoneJPA(String number){
		this.number = number;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getNumber(){
		return number;
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
}
