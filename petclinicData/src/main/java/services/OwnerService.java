package services;

import java.util.List;

import model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
	List<Owner> findByLastName(
	        String lastName
	);
	
}
