package petClinic.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity
{
	@Column(name = "name")
	private String name;
	private Date   dob;
	
	@ManyToOne
	@JoinColumn(name = "owner_id") // snake case hibernate col name
	private Owner owner;
	
	@ManyToOne
	@JoinColumn(name = "pettype_id")
	private PetType petType;
	
	@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
	private List<Visit> visits = new ArrayList<Visit>();
	
	public List<Visit> getVisits(
	)
	{
		return visits;
	}
	
	public void setVisits(
	        List<Visit> visits
	)
	{
		this.visits = visits;
	}
	
	public PetType getPetType(
	)
	{
		return petType;
	}
	
	public void setPetType(
	        PetType petType
	)
	{
		this.petType = petType;
	}
	
	public String getName(
	)
	{
		return name;
	}
	
	public void setName(
	        String name
	)
	{
		this.name = name;
	}
	
	public Date getDob(
	)
	{
		return dob;
	}
	
	public void setDob(
	        Date dob
	)
	{
		this.dob = dob;
	}
	
	public Owner getOwner(
	)
	{
		return owner;
	}
	
	public void setOwner(
	        Owner owner
	)
	{
		this.owner = owner;
	}
	
	public Pet(
	        String name, Date dob, Owner owner
	)
	{
		super();
		this.name  = name;
		this.dob   = dob;
		this.owner = owner;
	}
	
	public Pet(
	        String name, Date dob
	)
	{
		super();
		this.name = name;
		this.dob  = dob;
	}
	
	public Pet(
	)
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Convenience Method to Add Visit for Pet
	 */
	public Pet addVisitforPet(
	        Visit newVisit
	)
	{
		newVisit.setPet(this);
		this.visits.add(newVisit);
		
		return this;
	}
	
}
