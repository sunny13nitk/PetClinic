package model;

import java.util.Date;

public class Pet
{
	private String name;
	private Date   dob;
	private Owner  owner;

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

	public Date getDob(
	)
	{
		return dob;
	}

	public void setDob(
	        Date dob
	)
	{
		this.dob = dob;
	}

	public Owner getOwner(
	)
	{
		return owner;
	}

	public void setOwner(
	        Owner owner
	)
	{
		this.owner = owner;
	}

	public Pet(
	        String name, Date dob, Owner owner
	)
	{
		super();
		this.name  = name;
		this.dob   = dob;
		this.owner = owner;
	}

	public Pet(
	        String name, Date dob
	)
	{
		super();
		this.name = name;
		this.dob  = dob;
	}

	public Pet(
	)
	{
		super();
		// TODO Auto-generated constructor stub
	}

}
