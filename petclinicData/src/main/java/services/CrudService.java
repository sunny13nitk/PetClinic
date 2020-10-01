package services;

import java.util.List;

/*
 * Generic CRUD Service takes in a Type and an ID Object
 */
public interface CrudService<T, ID>
{
	List<T> findAll(
	);
	
	T findById(
	        ID id
	);
	
	T save(
	        T object
	);
	
	void delete(
	        T object
	);
	
	void deleteById(
	        ID id
	);
}
