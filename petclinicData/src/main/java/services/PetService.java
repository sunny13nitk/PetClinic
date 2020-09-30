package services;

import java.util.List;

import model.Pet;

public interface PetService
{
	
	List<Pet> findAll(
	        Long id
	);
	
	Pet findbyId(
	        long id
	);
	
	Pet save(
	        Pet pet
	);
}
