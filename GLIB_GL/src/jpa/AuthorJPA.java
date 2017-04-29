package jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JPA class representing the database table Author
 * @author Miguel
 *
 */

public class AuthorJPA implements Serializable{

	private static final long serialVersionUID = 6731100611573485120L;

	/**
	 * id attribute, representing uniquely each instance of the class 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, insertable=false)
	private Integer id;
	
	/**
	 * This attribute represents the name of the author
	 */
	@Column(nullable=false, length=40)
	private String name;
	
	/**
	 * This attribute represents the surname of the author
	 */
	@Column(nullable=false, length=40)
	private String surname;
	
	/**
	 * This attribute represents a biography of the author
	 */
	@Column(nullable=false, length=500)
	private String biography;
	
	/**
	 * This attribute represents the birth date of the author
	 */
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date birthDate;
	
	/**
	 * Setter method of the id attribute
	 * @param id value to be set
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 * Getter method of the id attribute
	 * @return value of the id attribute
	 */
	public Integer getId(){
		return id;
	}
	
	/**
	 * Setter method of the name attribute
	 * @param name value to be set
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Getter name of the name attribute
	 * @return value of the attribute
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Setter method of the surname attribute
	 * @param surname value to be set
	 */
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	/**
	 * Getter method of the surname attribute
	 * @return value of the attribute
	 */
	public String getSurname(){
		return surname;
	}
	
	/**
	 * Setter method of the biography attribute
	 * @param biography value to be set
	 */
	public void setBiography(String biography){
		this.biography = biography;
	}
	
	/**
	 * Getter method of the biography attribute
	 * @return value of the attribute
	 */
	public String getBiography(){
		return biography;
	}
	
	/**
	 * Setter method of the birthDate attribute
	 * @param birthDate value to be set
	 */
	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}
	
	/**
	 * Getter method of the birthDate attribute
	 * @return value of the attribute
	 */
	public Date getBirthDate(){
		return birthDate;
	}
	
	@Override
	public String toString(){
		return name + " " + surname;
	}
	
}
