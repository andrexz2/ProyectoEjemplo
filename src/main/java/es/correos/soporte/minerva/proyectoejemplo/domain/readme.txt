paquete para las clases de entidad que mapean el modelo de la BBDD a clases java. Estas clases nunca 
deben salir de la capa de servicios hacia el exterior.  

Un ejemplo de clase de entidad podría ser:


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PLAYER")
public class Player {

	@Id
	@Column(name = "ID_PLAYER", nullable = false)
	private Long idPlayer;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "AGE", nullable = false)
	private Integer age;

	@Column(name = "NUMBER", nullable = false)
	private Long number;

	@Override
	public String toString() {
		return number + " - " + name + " (" + age + ")";
	}

}