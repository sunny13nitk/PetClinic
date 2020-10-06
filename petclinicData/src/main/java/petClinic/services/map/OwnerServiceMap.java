package petClinic.services.map;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import petClinic.model.Owner;
import petClinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService
{
	
	@Override
	public Owner save(
	        Owner object
	)
	{
		
		return super.save(object);
	}
	
	@Override
	public List<Owner> findByLastName(
	        String lastName
	)
	{
		
		return this.findAll().stream().filter(x -> x.getLastName().equalsIgnoreCase(lastName))
		        .collect(Collectors.toList());
	}
	
}
