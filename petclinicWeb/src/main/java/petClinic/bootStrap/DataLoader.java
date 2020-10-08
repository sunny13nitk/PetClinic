package petClinic.bootStrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import petClinic.model.Owner;
import petClinic.model.PetType;
import petClinic.model.Vet;
import petClinic.services.OwnerService;
import petClinic.services.PetTypeService;
import petClinic.services.VetService;

/*
 * Data Loader Class create under petClinic package as this is the main package
 * inside which the MainApplication resides. so the Component scan picks this up implicitly
 */
@Component
public class DataLoader implements CommandLineRunner
{
	
	private final OwnerService   ownerSrv;
	private final VetService     vetSrv;
	private final PetTypeService petTypeSrv;
	
	@Autowired
	public DataLoader(
	        OwnerService ownerSrv, VetService vetSrv, PetTypeService petTypeSrv
	)
	{
		super();
		this.ownerSrv   = ownerSrv;
		this.vetSrv     = vetSrv;
		this.petTypeSrv = petTypeSrv;
	}
	
	@Override
	public void run(
	        String... args
	) throws Exception
	{
		
		PetType ptypeDog      = new PetType("dog");
		PetType ptypeDogSaved = petTypeSrv.save(ptypeDog);
		
		PetType ptypeCat      = new PetType("cat");
		PetType ptypeCatSaved = petTypeSrv.save(ptypeCat);
		
		System.out.println("Pet Types Loaded ....");
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Sunny");
		owner1.setLastName("Bhardwaj");
		ownerSrv.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Karan");
		owner2.setLastName("Salhotra");
		ownerSrv.save(owner2);
		
		System.out.println("Owners Loaded ....");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Suneet");
		vet1.setLastName("Singla");
		vetSrv.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Himani");
		vet2.setLastName("Chaudhary");
		vetSrv.save(vet2);
		
		System.out.println("Vets Loaded ....");
		
	}
	
}
