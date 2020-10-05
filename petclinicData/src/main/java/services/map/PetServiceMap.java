package services.map;

import org.springframework.stereotype.Service;

import model.Pet;
import services.PetService;

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
