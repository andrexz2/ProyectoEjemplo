paquete para la implementación de los servicios de negocio.

Una implementación de un servicio de negocio podría ser:


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.correos.soporte.minerva.proyectoejemplo.dto.PlayerDTO;
import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerExistsConflictException;
import es.correos.soporte.minerva.proyectoejemplo.mapper.PlayerMapper;
import es.correos.soporte.minerva.proyectoejemplo.repository.ITeamRepository;
import es.correos.soporte.minerva.proyectoejemplo.service.ITeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class TeamServiceImpl implements ITeamService {

	private final PlayerMapper playerMapper;

	private final ITeamRepository teamRepository;

	@Override
	public List<PlayerDTO> getPlayers() {
		return playerMapper.playerToPlayerDto(teamRepository.findAll());
	}

	@Override
    public PlayerDTO getPlayerWithNumber(long number) {
        return playerMapper.playerToPlayerDto(teamRepository.findByNumber(number));
	}

	@Override
	public void insert(PlayerDTO player) throws PlayerExistsConflictException {
		if (getPlayerWithNumber(player.getNumber()) != null ) {
			if (log.isWarnEnabled()) {
				log.error("Unable to create. A User with name {} already exist" + player.getName());
			}
			throw new PlayerExistsConflictException(
					"Imposible la creacion. El usuario con el nombre " + player.getName() + ", ya existe.");
		}
		teamRepository.saveAndFlush(playerMapper.playerDtoToPlayer(player));
	}

	@Override
	public void update(PlayerDTO player) {
		teamRepository.saveAndFlush(playerMapper.playerDtoToPlayer(player));
	}

	@Override
    public PlayerDTO getPlayerById(long id) {
        return playerMapper.playerToPlayerDto(teamRepository.getOne(id));
    }
    
    @Override
	public void delete(long id) {
		teamRepository.deleteById(id);
	}

	@Override
	public boolean isUserExist(long id) {
		return teamRepository.existsById(id);
	}
}
