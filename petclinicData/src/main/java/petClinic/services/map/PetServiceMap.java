package petClinic.services.map;

import org.springframework.stereotype.Service;

import petClinic.model.Pet;
import petClinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService
{
	
	@Override
	public Pet save(
	        Pet object
	)
	{
		
		return super.save(object.getId(), object);
	}
	
}
