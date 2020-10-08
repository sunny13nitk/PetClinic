package petClinic.services.map;

import org.springframework.stereotype.Service;

import petClinic.model.Speciality;
import petClinic.services.SpecialityService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService
{
	
}
