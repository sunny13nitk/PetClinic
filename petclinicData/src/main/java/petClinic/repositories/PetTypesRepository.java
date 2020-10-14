package petClinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petClinic.model.PetType;

@Repository
public interface PetTypesRepository extends JpaRepository<PetType, Long>
{
	public List<PetType> findAllByNameIgnoreCase(
	        String pettype
	);
}
