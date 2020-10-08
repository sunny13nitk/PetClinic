package petClinic.services.map;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petClinic.model.Owner;
import petClinic.model.Pet;
import petClinic.model.PetType;
import petClinic.services.OwnerService;
import petClinic.services.PetService;
import petClinic.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService
{
	
	private final PetService petSrv;
	
	private final PetTypeService petTypeSrv;
	
	@Autowired
	public OwnerServiceMap(
	        PetService petSrv, PetTypeService petTypeSrv
	)
	{
		this.petSrv     = petSrv;
		this.petTypeSrv = petTypeSrv;
	}
	
	@Override
	public Owner save(
	        Owner object
	)
	{
		if (object != null)
		{
			// Owner will have Pet(s)
			
			if (object.getPets() != null)
			{
				if (object.getPets().size() > 0)
				{
					object.getPets().forEach(pet ->
					{
						// Each of the Pets that ought to be saved - need to have a Pet Type Before we Process Save for
						// them
						if (pet.getPetType() == null)
						{
							throw new RuntimeException("Pet Type is required!"); // Incomplete Pet Object
						} else
						{
							// Identify the PetType that really needs to be saved here - One with Null Id Property
							if (pet.getPetType().getId() == null)
							{
								// Save the Pet Type using Pet Type Service
								PetType petTypeSaved = petTypeSrv.save(pet.getPetType());
								// Set the Same in Pet to establish Association
								pet.setPetType(petTypeSaved);
							}
						}
						
						// Each of the Pets that ought to be saved - Pet Id should be null (Coz we are looping on all
						// Pets)
						if (pet.getId() == null)
						{
							// Save this Pet using Pet Service
							Pet savedPet = petSrv.save(pet);
							
							// and publish the saved Pet Id to Current Pet loop pass - complete the association with
							// Owner
							pet.setId(savedPet.getId());
							
						}
						
					});
				}
			}
			// Finally Save the Owner with Published Id properties
			return super.save(object);
		} else
		{
			return null;
		}
		
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
