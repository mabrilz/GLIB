package managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.naming.Context;
import javax.naming.InitialContext;

import ejb.UserFacadeRemote;
import jpa.AddressJPA;
import jpa.PhoneJPA;
import jpa.UserJPA;
import utils.Helper;

@ManagedBean(name="registerUser")
@SessionScoped
public class RegisterUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1338543122451956749L;
	/**
	 * The user's email, used as id to log in the application
	 */
	private String email;
	/**
	 * The user's password
	 */
	private String password;
	/**
	 * The user's password repeated, to check if it has been correctly introduced
	 */
	private String password2;
	/**
	 * The user's nif
	 */
	private String nif;
	/**
	 * The user's name
	 */
	private String name;
	/**
	 * The user's surname
	 */
	private String surname;
	/**
	 * The user's phone
	 */
	private List<String> phones = new ArrayList<String>();;
	
	private String newPhone;
	
	/**
	 * The user's address
	 */
	private String address;
	
	 @EJB
	 private UserFacadeRemote userRemote;
	 
	 /**
	 * Default constructor
	 * @throws Exception
	 */
	public RegisterUser() throws Exception{
	}
	
	/**
	 * Setter method of the attribute nif
	 * @param nif nif to be set
	 */
	public void setNif(String nif){
		this.nif = nif;
	}
	
	/**
	 * Getter method of the attribute nif
	 * @return
	 */
	public String getNif(){
		return nif;
	}
	
	/**
	 * Setter method of the email parameter
	 * @param email the email to be set
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
	/**
	 * Getter method of the email attribute
	 * @return the email of the user
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * Setter method of the password attribute
	 * @param password the password of the user to be set
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * Getter method of the attribute password
	 * @return the password of the user
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * Setter method of the attribute name
	 * @param name the name to be set
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Getter method of the name attribute
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Setter method of the surname attribute
	 * @param surname the surname to be set
	 */
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	/**
	 * Getter method of the surname attribute
	 * @return the surname of the user
	 */
	public String getSurname(){
		return surname;
	}
	
	/**
	 * Setter method of the phone attribute
	 * @param phone the phone of the user to be set
	 */
	public void setPhones(List<String> phones){
		this.phones = phones;
	}
	
	/**
	 * Getter method of the phone attribute
	 * @return the phone of the user
	 */
	public List<String> getPhones(){
		return phones;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	/**
	 * Getter method of the attribute password2
	 * @return the password of the user
	 */
	public void setPassword2(String password2){
		this.password2 = password2;
	}
	
	/**
	 * Getter method of the attribute password2
	 * @return the password of the user
	 */
	public String getPassword2(){
		return password2;
	}
	
	/**
	 * Method that is invoked from the facelet login, updating the value stored in the nif attribute
	 * @param evt this parameter stores the new value updated
	 */
	public void nifChanged(ValueChangeEvent evt){
		nif = evt.getNewValue().toString();
	}
	
	/**
	 * Method that is invoked from the facelet login, updating the value stored in the name attribute
	 * @param evt this parameter stores the new value updated
	 */
	public void nameChanged(ValueChangeEvent evt){
		name = evt.getNewValue().toString();
	}

	/**
	 * Method that is invoked from the facelet login, updating the value stored in the surname attribute
	 * @param evt this parameter stores the new value updated
	 */
	public void surnameChanged(ValueChangeEvent evt){
		surname = evt.getNewValue().toString();
	}
	
	/**
	 * Method that is invoked from the facelet login, updating the value stored in the address attribute
	 * @param evt this parameter stores the new value updated
	 */
	public void addressChanged(ValueChangeEvent evt){
		address = evt.getNewValue().toString();
	}

	/**
	 * Method that is invoked from the facelet login, updating the value stored in the phone attribute
	 * @param evt this parameter stores the new value updated
	 */
	public void phoneChanged(ValueChangeEvent evt){
		newPhone = evt.getNewValue().toString();
	}
	
	public void addPhone(){
		phones.add(newPhone);
	}

	/**
	 * Method that is invoked from the facelet login, updating the value stored in the password attribute
	 * @param evt this parameter stores the new value updated
	 */
	public void passwordChanged(ValueChangeEvent evt){
		password = evt.getNewValue().toString();
	}

	/**
	 * Method that is invoked from the facelet login, updating the value stored in the password2 attribute
	 * @param evt this parameter stores the new value updated
	 */
	public void password2Changed(ValueChangeEvent evt){
		password2 = evt.getNewValue().toString();
	}
	
	/**
	 * Method that is invoked from the facelet login, updating the value stored in the email attribute
	 * @param evt this parameter stores the new value updated
	 */
	public void emailChanged(ValueChangeEvent evt){
		email = evt.getNewValue().toString();
	}
	
	public String loadFormRegisterUser(){
		return "registerUserView";
	}
	
	/**
	 * Method that validates the data introduced by the user, when the data is updated.
	 * @param validatePassword true if the password will be validated (only if the user introduces a password)
	 * @return true if the data is valid, false otherwise
	 */
	public boolean validateData(){
		if(nif.equals("") || name.equals("") || surname.equals("") || phones == null || password.equals("")|| password2.equals("") || email.equals("")){
			return false;
		}		
		if(!Helper.validateEmail(email)) return false;		
		if(!Helper.validatePassword(password, password2)) return false;
		if(!Helper.validateNIF(nif)) return false;
		// en caso de encontrar valores numéricos en el nombre o el apellido la validación no es correcta
		if(name.matches(".*\\d+.*") || surname.matches(".*\\d+.*")){
			return false;
		}
		try{
			for(String phone: phones){
				Long.valueOf(phone);
			}
		}
		catch (Exception ex){
			return false;
		}
		return true;
	}
	
	/**
	 * Method that registers a user in the application, storing the information in the database, and returns the login view, 
	 * so the user can introduce the email and password and can check the register has been successful.
	 * If the data is not correct, it returns a view informing the user, and allowing to return to the register view
	 * In case of error, it returns the error view
	 * @return view to be shown to the user
	 */
	public String registerUser(){
		String result = "registerUserOk";
		try{
			if(validateData()){
				Properties props = System.getProperties();
				Context ctx = new InitialContext(props);
				userRemote = (UserFacadeRemote) ctx.lookup("java:app/GLIB.jar/UserFacadeBean!ejb.UserFacadeRemote");
				AddressJPA addressjpa = new AddressJPA();
				List<PhoneJPA> phonesjpa = new ArrayList<PhoneJPA>();
				for(String phone: phones){
					phonesjpa.add(new PhoneJPA(phone));
				}
				UserJPA user = userRemote.registerUser(nif, email, name, surname, Helper.encrypt(password), phonesjpa, addressjpa);
				if(user!=null){
					setNif(user.getNif());
					setName(user.getName());
					setSurname(user.getSurname());
					setEmail(user.getEmail());
					setPhones(phones);
				}
				else result = "errorView";
				return result;
			}
			else{
				return "checkRegisterDataView";
			}
		}
		catch(Exception ex){
			return "errorView";
		}
	}
}
