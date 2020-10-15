package petClinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*Owner POJO
 */
@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor

public class Owner extends Person
{
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "telephone")
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Pet> pets = new ArrayList<Pet>();
	
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
