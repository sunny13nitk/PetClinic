package services.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import services.CrudService;

/*
 * Abstract Class that Implements CrudService Interface
 * Specific POJO Services can Extend this One for Own Impl
 */
public abstract class AbstractMapService<T, ID> implements CrudService<T, ID>
{
	protected Map<ID, T> map = new HashMap<>();
	
	public List<T> findAll(
	)
	{
		return (List<T>) map.values();
	}
	
	public T findById(
	        ID id
	)
	{
		return map.get(id);
	}
	
	public T save(
	        ID id, T object
	)
	{
		map.put(id, object);
		
		return object;
	}
	
	public void deleteById(
	        ID id
	)
	{
		map.remove(id);
	}
	
	public void delete(
	        T object
	)
	{
		map.entrySet().removeIf(x -> x.getValue().equals(object));
	}
}
