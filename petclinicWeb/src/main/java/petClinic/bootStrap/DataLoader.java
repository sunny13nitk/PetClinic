package petClinic.bootStrap;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import petClinic.model.Owner;
import petClinic.model.Pet;
import petClinic.model.PetType;
import petClinic.model.Speciality;
import petClinic.model.Vet;
import petClinic.services.OwnerService;
import petClinic.services.PetTypeService;
import petClinic.services.SpecialityService;
import petClinic.services.VetService;

/*
 * Data Loader Class create under petClinic package as this is the main package
 * inside which the MainApplication resides. so the Component scan picks this up implicitly
 */
@Component
public class DataLoader implements CommandLineRunner
{
	
	private final OwnerService      ownerSrv;
	private final VetService        vetSrv;
	private final PetTypeService    petTypeSrv;
	private final SpecialityService specialitySrv;
	
	@Autowired
	public DataLoader(
	        OwnerService ownerSrv, VetService vetSrv, PetTypeService petTypeSrv, SpecialityService specialitySrv
	)
	{
		super();
		this.ownerSrv      = ownerSrv;
		this.vetSrv        = vetSrv;
		this.petTypeSrv    = petTypeSrv;
		this.specialitySrv = specialitySrv;
	}
	
	@Override
	public void run(
	        String... args
	) throws Exception
	{
		if (petTypeSrv.findAll().size() == 0)
			loadData();
		
	}
	
	private void loadData(
	)
	{
		PetType ptypeDog      = new PetType("dog");
		PetType ptypeDogSaved = petTypeSrv.save(ptypeDog);
		
		PetType ptypeCat      = new PetType("cat");
		PetType ptypeCatSaved = petTypeSrv.save(ptypeCat);
		
		System.out.println("Pet Types Loaded ....");
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Sunny");
		owner1.setLastName("Bhardwaj");
		owner1.setAddress("114, Williamson Street");
		owner1.setCity("toronto");
		owner1.setTelephone("6478769932");
		
		// Adding Pet to Sunny
		Pet sunnysPet = new Pet();
		sunnysPet.setPetType(ptypeDogSaved);
		sunnysPet.setDob(new Date(System.currentTimeMillis()));
		sunnysPet.setName("tommy");
		
		// both Way Association
		sunnysPet.setOwner(owner1);
		owner1.getPets().add(sunnysPet);
		
		ownerSrv.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Karan");
		owner2.setLastName("Salhotra");
		ownerSrv.save(owner2);
		
		// Adding Pet to Karan
		Pet karansPet = new Pet();
		karansPet.setPetType(ptypeDogSaved);
		karansPet.setDob(new Date(System.currentTimeMillis()));
		karansPet.setName("bruno");
		
		// both Way Association
		karansPet.setOwner(owner2);
		owner2.getPets().add(karansPet);
		
		System.out.println("Owners Loaded ....");
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialitySrv.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentist");
		Speciality savedDentisrty = specialitySrv.save(dentistry);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Suneet");
		vet1.setLastName("Singla");
		vet1.getSpecialities().add(savedSurgery);
		
		vetSrv.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Himani");
		vet2.setLastName("Chaudhary");
		vet2.getSpecialities().add(savedDentisrty);
		vetSrv.save(vet2);
		
		System.out.println("Vets Loaded ....");
	}
	
}
