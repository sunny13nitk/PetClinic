package petClinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petClinic.model.Vet;

@Repository
public interface VetsRepository extends JpaRepository<Vet, Long>
{
	public List<Vet> findAllByFirstNameAndLastName(
	        String firstName, String lastName
	);
	
	public List<Vet> findAllBySpecialitiesDescriptionContainingIgnoreCase(
	        String speciality
	);
}
