paquete para objeto de tipo DTO para la transferencia de datos entre capas y comunicación con el exterior (API).  

Un ejemplo clase DTO podría ser:

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2004440174929362136L;

	private Long idPlayer;

	private String name;

	private Integer age;

	private Long number;

	@Override
	public String toString() {
		return number + " - " + name + " (" + age + ")";
	}

}
