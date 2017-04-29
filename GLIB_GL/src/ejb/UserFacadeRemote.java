package ejb;

import java.util.List;

import javax.ejb.Remote;

import jpa.AddressJPA;
import jpa.PhoneJPA;
import jpa.UserJPA;

@Remote
public interface UserFacadeRemote {

	public UserJPA registerUser(String nif, String email, String name, String surname, String password, List<PhoneJPA> phones, AddressJPA address);
	
}
