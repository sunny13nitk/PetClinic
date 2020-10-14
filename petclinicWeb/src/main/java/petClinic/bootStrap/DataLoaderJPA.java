package petClinic.bootStrap;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import petClinic.model.Owner;
import petClinic.model.Pet;
import petClinic.model.PetType;
import petClinic.model.Speciality;
import petClinic.model.Vet;
import petClinic.repositories.OwnersRepository;
import petClinic.repositories.PetTypesRepository;
import petClinic.repositories.SpecialitiesRepository;
import petClinic.repositories.VetsRepository;

/*
 * Data Loader Class create under petClinic package as this is the main package
 * inside which the MainApplication resides. so the Component scan picks this up implicitly
 */
@Component
@Profile("springDataJPA")
public class DataLoaderJPA implements CommandLineRunner
{
	
	private final OwnersRepository       ownerSrv;
	private final VetsRepository         vetSrv;
	private final PetTypesRepository     petTypeSrv;
	private final SpecialitiesRepository specialitySrv;
	
	@Autowired
	public DataLoaderJPA(
	        OwnersRepository ownerSrv, VetsRepository vetSrv, PetTypesRepository petTypeSrv,
	        SpecialitiesRepository specialitySrv
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
		owner1.setFirstname("Sunny");
		owner1.setLastname("Bhardwaj");
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
		owner2.setFirstname("Karan");
		owner2.setLastname("Salhotra");
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
		vet1.setFirstname("Suneet");
		vet1.setLastname("Singla");
		vet1.getSpecialities().add(savedSurgery);
		
		vetSrv.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstname("Himani");
		vet2.setLastname("Chaudhary");
		vet2.getSpecialities().add(savedDentisrty);
		vetSrv.save(vet2);
		
		System.out.println("Vets Loaded ....");
		
		System.out.println("Inside SD JPA Proile");
	}
	
}
