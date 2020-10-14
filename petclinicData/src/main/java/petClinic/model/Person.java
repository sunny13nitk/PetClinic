package petClinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity
{
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	public String getFirstname(
	)
	{
		return firstname;
	}
	
	public void setFirstname(
	        String firstName
	)
	{
		this.firstname = firstName;
	}
	
	public String getLastname(
	)
	{
		return lastname;
	}
	
	public void setLastname(
	        String lastName
	)
	{
		this.lastname = lastName;
	}
	
	public Person(
	        String firstName, String lastName
	)
	{
		super();
		this.firstname = firstName;
		this.lastname  = lastName;
	}
	
	public Person(
	)
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
}
