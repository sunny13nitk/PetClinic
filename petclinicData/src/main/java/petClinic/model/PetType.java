package petClinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pettypes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetType extends BaseEntity
{
	
	private String name;
	
}
