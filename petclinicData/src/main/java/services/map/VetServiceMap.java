package services.map;

import model.Vet;

public class VetServiceMap extends AbstractMapService<Vet, Long>
{
	
	@Override
	public Vet save(
	        Vet object
	)
	{
		return super.save(object.getId(), object);
	}
	
}
