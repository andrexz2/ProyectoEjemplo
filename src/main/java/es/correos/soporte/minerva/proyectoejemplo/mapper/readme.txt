paquete para las clases (interfaces) de tipo Mapper (mapstruct) que permiten la conversión de 
objetos entidad <-> dto. Son de utilidad para el paso de objetos entre capas.

Un ejemplo de mapper podría ser:

import java.util.List;

import org.mapstruct.Mapper;

import es.correos.soporte.minerva.proyectoejemplo.domain.Player;
import es.correos.soporte.minerva.proyectoejemplo.dto.PlayerDTO;

/**
 * @author everis
 *
 */
@Mapper
public interface PlayerMapper {

	PlayerDTO playerToPlayerDto(Player player);

	List<PlayerDTO> playerToPlayerDto(List<Player> player);

	Player playerDtoToPlayer(PlayerDTO player);

	List<Player> playerDtoToPlayer(List<PlayerDTO> player);
}
