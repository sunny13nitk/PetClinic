package petClinic.services.map;

import org.springframework.stereotype.Service;

import petClinic.model.PetType;
import petClinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService
{
	
}
