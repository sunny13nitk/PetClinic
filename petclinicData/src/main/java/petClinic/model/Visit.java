package petClinic.model;

import java.util.Date;

public class Visit extends BaseEntity
{
	private Date   date;
	private String description;
	private Pet    pet;
	
	public Date getDate(
	)
	{
		return date;
	}
	
	public void setDate(
	        Date date
	)
	{
		this.date = date;
	}
	
	public String getDescription(
	)
	{
		return description;
	}
	
	public void setDescription(
	        String description
	)
	{
		this.description = description;
	}
	
	public Pet getPet(
	)
	{
		return pet;
	}
	
	public void setPet(
	        Pet pet
	)
	{
		this.pet = pet;
	}
	
	public Visit(
	)
	{
		
	}
	
}
