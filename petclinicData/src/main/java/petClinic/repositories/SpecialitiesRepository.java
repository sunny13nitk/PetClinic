package petClinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petClinic.model.Speciality;

@Repository
public interface SpecialitiesRepository extends JpaRepository<Speciality, Long>
{
	public List<Speciality> findAllByDescriptionContainingIgnoreCase(
	        String description
	);
}
