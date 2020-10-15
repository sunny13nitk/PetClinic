package petClinic.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit extends BaseEntity
{
	
	private Date   date;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
}
