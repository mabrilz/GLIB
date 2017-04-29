package jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GLIB.address")
public class AddressJPA implements Serializable{
	
	private static final long serialVersionUID = 1411549778662750774L;
	
	/** The identifier of the class. */
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, insertable=false)
	private Integer id;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
}
