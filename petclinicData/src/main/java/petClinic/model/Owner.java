package petClinic.model;

import java.util.ArrayList;
import java.util.List;

/*Owner POJO
 */
public class Owner extends Person
{
	private List<Pet> pets;
	
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
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Owner(
	        String firstName, String lastName
	)
	{
		this.pets = new ArrayList<Pet>();
	}
	
}
