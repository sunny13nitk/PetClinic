package petClinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petClinic.model.Owner;

@Repository
public interface OwnersRepository extends JpaRepository<Owner, Long>
{
	// Find Owner(s) by Pet Name
	public List<Owner> findAllByPetsNameIgnoreCase(
	        String petType
	);
	
	// Find Owner(s) by Pet Type
	public List<Owner> findAllByPetsPetTypeNameIgnoreCase(
	        String petType
	);
	
	// Find Owner(s) by City
	public List<Owner> findAllByCityContains(
	        String city
	);
}
