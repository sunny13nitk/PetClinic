package petclinicWeb.bootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import model.Owner;
import model.Vet;
import services.OwnerService;
import services.VetService;
import services.map.OwnerServiceMap;
import services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner
{
	
	private final OwnerService ownerSrv;
	private final VetService   vetSrv;
	
	public DataLoader(
	    // OwnerService ownerSrv, PetService petSrv
	)
	{
		// currently Instantiated - Will be Injected Later depending on Profile
		this.ownerSrv = (OwnerService) new OwnerServiceMap();
		this.vetSrv   = (VetService) new VetServiceMap();
	}
	
	@Override
	public void run(
	        String... args
	) throws Exception
	{
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Sunny");
		owner1.setLastName("Bhardwaj");
		ownerSrv.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Karan");
		owner2.setLastName("Salhotra");
		ownerSrv.save(owner2);
		
		System.out.println("Owners Loaded ....");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Suneet");
		vet1.setLastName("Singla");
		vetSrv.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Himani");
		vet2.setLastName("Chaudhary");
		vetSrv.save(vet2);
		
		System.out.println("Vets Loaded ....");
		
	}
	
}
