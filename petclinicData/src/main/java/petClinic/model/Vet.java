package petClinic.model;

import java.util.ArrayList;
import java.util.List;

public class Vet extends Person
{
	private List<Speciality> specialities;
	
	public List<Speciality> getSpecialities(
	)
	{
		return specialities;
	}
	
	public void setSpecialities(
	        List<Speciality> specialities
	)
	{
		this.specialities = specialities;
	}
	
	public Vet(
	)
	{
		this.specialities = new ArrayList<Speciality>();
	}
	
}
