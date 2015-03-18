package models;

import javax.persistence.*;

@Entity
@Table(name="DICA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

}
