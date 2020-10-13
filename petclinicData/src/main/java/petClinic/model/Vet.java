package petClinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person
{
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "vets_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id")
	)
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
