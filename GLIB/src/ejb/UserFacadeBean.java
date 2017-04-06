package ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jpa.AddressJPA;
import jpa.PhoneJPA;
import jpa.UserJPA;

public class UserFacadeBean implements UserFacadeRemote{
	
	//Persistence Unit Context
	@PersistenceContext(unitName="GLIB") 
	private EntityManager entman;

	@Override
	public UserJPA registerUser(String nif, String email, String name, String surname, List<PhoneJPA> phones, AddressJPA address) {
		// TODO Auto-generated method stub
		return null;
	}
}
