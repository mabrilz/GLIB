package jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GLIB.User_Phones")
public class UserVsPhoneJPA implements Serializable{

	private static final long serialVersionUID = 4213864979739076057L;

	@Id
	private UserJPA user;
	
	@Id
	private PhoneJPA phone;
	
	public UserJPA getUser(){
		return user;
	}
	
	public void setUser(UserJPA user){
		this.user = user;
	}
	
	public PhoneJPA getPhone(){
		return phone;
	}
	
	public void setPhone(PhoneJPA phone){
		this.phone = phone;
	}
	
}
