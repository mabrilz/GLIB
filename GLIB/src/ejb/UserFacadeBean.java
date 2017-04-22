package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import enums.Profile;
import jpa.AddressJPA;
import jpa.PhoneJPA;
import jpa.UserJPA;

@Stateless
public class UserFacadeBean implements UserFacadeRemote{
	
	//Persistence Unit Context
	@PersistenceContext(unitName="GLIB") 
	private EntityManager entman;

	@Override
	public UserJPA registerUser(String nif, String email, String name, String surname, String password, List<PhoneJPA> phones, AddressJPA address) {
		entman.persist(address);
		for(PhoneJPA phone: phones){
			entman.persist(phone);
		}
		UserJPA user = new UserJPA();
		user.setNif(nif);
		user.setEmail(email);
		user.setName(name);
		user.setSurname(surname);
		user.setPassword(password);
		user.setPhones(phones);
		user.setAddress(address);
		user.setSendMessagesToForum(true);
		user.setForcePasswordChange(false);
		user.setProfile(Profile.Reader);
		user.setActive(true);
		entman.persist(user);
		return null;
	}
}
