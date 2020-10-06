package petClinic.bootStrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import petClinic.model.Owner;
import petClinic.model.Vet;
import petClinic.services.OwnerService;
import petClinic.services.VetService;

/*
 * Data Loader Class create under petClinic package as this is the main package
 * inside which the MainApplication resides. so the Component scan picks this up implicitly
 */
@Component
public class DataLoader implements CommandLineRunner
{
	
	private final OwnerService ownerSrv;
	private final VetService   vetSrv;
	
	@Autowired
	public DataLoader(
	        OwnerService ownerSrv, VetService vetSrv
	)
	{
		super();
		this.ownerSrv = ownerSrv;
		this.vetSrv   = vetSrv;
	}
	
	@Override
	public void run(
	        String... args
	) throws Exception
	{
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
