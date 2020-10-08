package petClinic.services.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petClinic.model.Speciality;
import petClinic.model.Vet;
import petClinic.services.SpecialityService;
import petClinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService
{
	
	private SpecialityService specialitySrv;
	
	@Autowired
	public VetServiceMap(
	        SpecialityService specialitySrv
	)
	{
		super();
		this.specialitySrv = specialitySrv;
	}
	
	@Override
	public Vet save(
	        Vet object
	)
	{
		if (object != null)
		{
			
			if (object.getSpecialities() != null)
			{
				if (object.getSpecialities().size() > 0)
				{
					// Scan each Speciality and Save One(s) which don't have an Id and tie them back to the respective
					// Vet - Map is not Association Sensitive
					
					object.getSpecialities().forEach(speciality ->
					{
						if (speciality.getId() == null)
						{
							// This one is to be saved
							Speciality savedSp = specialitySrv.save(speciality);
							speciality.setId(savedSp.getId());
						}
						
					});
					
				}
			}
			// Now Save the Vet
			return super.save(object);
			
		} else
		{
			return null;
		}
	}
	
}
