package petClinic.services.map;

import org.springframework.stereotype.Service;

import petClinic.model.Vet;
import petClinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService
{
	
	@Override
	public Vet save(
	        Vet object
	)
	{
		return super.save(object.getId(), object);
	}
	
}
