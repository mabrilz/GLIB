package jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enums.Profile;

@Entity
@Table(name="GLIB.users")
public class UserJPA implements Serializable{

	private static final long serialVersionUID = 4398030861963645224L;
	
	@Id
	@Column(unique=true, nullable=false, length=9)
	private String nif;
	
	@Column(nullable=false, length=40)
	private String name;
	
	@Column(nullable=false, length=40)
	private String surname;
	
	@Column(nullable=false, unique=true, length=60)
	private String email;
	
	@Column(nullable=false, length=20)
	@Enumerated(EnumType.STRING)
	private Profile profile;
	
	@Column(nullable=false)
	private Boolean active;
	
	@Column(nullable=false)
	private Boolean sendMessagesToForum;
	
	@Column(nullable=false)
	private Boolean forcePasswordChange;
	
	@OneToMany(mappedBy="user")
	@JoinTable(name="User_Phones",
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="phone_id"))
	private List<PhoneJPA> phones;
	
	public String getNif(){
		return nif;
	}
	
	public void setNif(String nif){
		this.nif = nif;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public Profile getProfile(){
		return profile;
	}
	
	public void setProfile(Profile profile){
		this.profile = profile;
	}
	
	public Boolean getActive(){
		return active;
	}
	
	public void setActive(Boolean active){
		this.active = active;
	}
	
	public Boolean getSendMessagesToForum(){
		return sendMessagesToForum;
	}
	
	public void setSendMessagesToForum(Boolean sendMessagesToForum){
		this.sendMessagesToForum = sendMessagesToForum;
	}
	
	public Boolean getForcePasswordChange(){
		return forcePasswordChange;
	}
	
	public void setForcePasswordChange(Boolean forcePasswordChange){
		this.forcePasswordChange = forcePasswordChange;
	}
}
