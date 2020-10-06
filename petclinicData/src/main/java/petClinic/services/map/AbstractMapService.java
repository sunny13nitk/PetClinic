package petClinic.services.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import petClinic.model.BaseEntity;
import petClinic.services.CrudService;

/*
 * Abstract Class that Implements CrudService Interface
 * Specific POJO Services can Extend this One for Own Impl
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID>
{
	protected Map<Long, T> map = new HashMap<>();
	
	public List<T> findAll(
	)
	{
		return new ArrayList<T>(map.values());
	}
	
	public T findById(
	        ID id
	)
	{
		return map.get(id);
	}
	
	public T save(
	        T object
	)
	{
		
		if (object != null)
		{
			if (object.getId() == null)
			{
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else
		{
			throw new RuntimeException("Not able to Save Null Object!");
		}
		
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
	
	private Long getNextId(
	)
	{
		Long nextId = null;
		if (map.isEmpty())
		{
			nextId = 1L;
		} else
		{
			nextId = Collections.max(map.keySet()) + 1;
		}
		
		return nextId;
	}
	
}
