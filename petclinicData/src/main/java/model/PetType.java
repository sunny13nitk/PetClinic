package model;

public class PetType extends BaseEntity
{
	private String name;
	
	public String getName(
	)
	{
		return name;
	}
	
	public void setName(
	        String name
	)
	{
		this.name = name;
	}
	
	public PetType(
	        String name
	)
	{
		super();
		this.name = name;
	}
	
	public PetType(
	)
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
}
