package petClinic.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petClinic.model.Pet;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long>
{
	public Optional<Pet> findByNameContains(
	        String petName
	);
	
	public List<Pet> findAllByPetTypeNameIgnoreCase(
	        String petType
	);
	
	public List<Pet> findAllByOwnerFirstNameAndLastNameIgnoreCase(
	        String OwnerFname, String OwnerLname
	);
}
