package petClinic.services;

import java.util.List;

import petClinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
	List<Owner> findByLastName(
	        String lastName
	);
	
}
