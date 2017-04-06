package ejb;

import java.util.List;

import javax.ejb.Local;

import jpa.AddressJPA;
import jpa.PhoneJPA;
import jpa.UserJPA;

@Local
public interface UserFacadeLocal {

	public UserJPA registerUser(String nif, String email, String name, String surname, List<PhoneJPA> phones, AddressJPA address);
	
}
