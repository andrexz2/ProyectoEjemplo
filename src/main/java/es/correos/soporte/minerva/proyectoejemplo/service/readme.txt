paquete para las interfaces de los servicios de negocio de la aplicación. Los objetos de 
entrada/salida de esta capa solo pueden ser DTOs. Se usarán los conversores para el mapeo
de objetos cuando sea necesario (siempre que se trabaje con clase Repository).

Un ejemplo de interfaz de negocio podría ser:

import java.util.List;

import es.correos.soporte.minerva.proyectoejemplo.dto.PlayerDTO;
import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerExistsConflictException;

public interface ITeamService {

	PlayerDTO getPlayerById(long id);
	
	PlayerDTO getPlayerWithNumber(long number);

	List<PlayerDTO> getPlayers();

	void insert(PlayerDTO player) throws PlayerExistsConflictException;

	void update(PlayerDTO player);

    void delete(long id);

    boolean isUserExist(long id);

}