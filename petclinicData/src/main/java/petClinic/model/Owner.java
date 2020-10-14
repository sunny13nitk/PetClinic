package petClinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*Owner POJO
 */
@Entity
@Table(name = "owners")
public class Owner extends Person
{
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "telephone")
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Pet> pets;
	
	public String getAddress(
	)
	{
		return address;
	}
	
	public void setAddress(
	        String address
	)
	{
		this.address = address;
	}
	
	public String getCity(
	)
	{
		return city;
	}
	
	public void setCity(
	        String city
	)
	{
		this.city = city;
	}
	
	public String getTelephone(
	)
	{
		return telephone;
	}
	
	public void setTelephone(
	        String telephone
	)
	{
		this.telephone = telephone;
	}
	
	public List<Pet> getPets(
	)
	{
		return pets;
	}
	
	public void setPets(
	        List<Pet> pets
	)
	{
		this.pets = pets;
	}
	
	public Owner(
	)
	{
		this.pets = new ArrayList<Pet>();
	}
	
	public Owner(
	        String firstName, String lastName
	)
	{
		this.pets = new ArrayList<Pet>();
	}
	
	/*
	 * Convenience Method to Add a Pet
	 */
	public Owner addPet(
	        Pet newPet
	)
	{
		newPet.setOwner(this);
		this.pets.add(newPet);
		return this;
	}
	
}
