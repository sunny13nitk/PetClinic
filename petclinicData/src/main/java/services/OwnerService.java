package services;

import java.util.List;

import model.Owner;

public interface OwnerService
{
	List<Owner> findByLastName(
	);
	
	List<Owner> findAll(
	        Long id
	);
	
	Owner findbyId(
	        long id
	);
	
	Owner save(
	        Owner owner
	);
}
