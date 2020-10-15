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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
