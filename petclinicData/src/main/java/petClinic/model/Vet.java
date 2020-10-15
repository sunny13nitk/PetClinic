package petClinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vet extends Person
{
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "vets_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id")
	)
	private List<Speciality> specialities = new ArrayList<Speciality>();;
	
}
