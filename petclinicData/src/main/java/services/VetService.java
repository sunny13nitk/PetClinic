package services;

import java.util.List;

import model.Vet;

public interface VetService
{
	
	List<Vet> findAll(
	        Long id
	);
	
	Vet findbyId(
	        long id
	);
	
	Vet save(
	        Vet vet
	);
}
