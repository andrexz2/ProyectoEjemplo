paquete para clases de tests de servicios. Un ejemplo podría ser:

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import es.correos.soporte.minerva.proyectoejemplo.domain.Player;
import es.correos.soporte.minerva.proyectoejemplo.dto.PlayerDTO;
import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerExistsConflictException;
import es.correos.soporte.minerva.proyectoejemplo.helpers.TeamServiceHelper;
import es.correos.soporte.minerva.proyectoejemplo.mapper.PlayerMapper;
import es.correos.soporte.minerva.proyectoejemplo.repository.ITeamRepository;

@RunWith(SpringRunner.class)
public class TeamServiceImplTest {

	@MockBean
	private PlayerMapper playerMapper;

	@MockBean
	private ITeamRepository teamRepository;
	
	private TeamServiceImpl teamService;

	@Before
	public void setup() {
		teamService = new TeamServiceImpl(playerMapper, teamRepository);
	}
	
	@Test
	public void testGetPlayer() throws Exception {
		Player player = TeamServiceHelper.createPlayer();
		when(teamRepository.getOne(1L)).thenReturn(TeamServiceHelper.createPlayer());
		when(playerMapper.playerToPlayerDto(player)).thenReturn(TeamServiceHelper.createPlayerDTO());

		PlayerDTO playerDTO = teamService.getPlayerById(1L);

		verify(teamRepository, times(1)).getOne(1L);
		assertNotNull(player);
		assertEquals(player.getIdPlayer(), playerDTO.getIdPlayer());
		assertEquals(player.getName(), playerDTO.getName());
		assertEquals(player.getNumber(), playerDTO.getNumber());
		assertEquals(player.getAge(), playerDTO.getAge());
	}

	@Test
	public void testGetPlayers() throws Exception {
		List<Player> players = TeamServiceHelper.createPlayers();
		when(teamRepository.findAll()).thenReturn(TeamServiceHelper.createPlayers());
		when(playerMapper.playerToPlayerDto(players)).thenReturn(TeamServiceHelper.createPlayersDTO());

		List<PlayerDTO> playerList = teamService.getPlayers();

		verify(teamRepository, times(1)).findAll();
		assertNotNull(playerList);
		assertEquals(1, playerList.size());
	}

	@Test
	public void testGetPlayerWithNumber() throws Exception {
		Player player = TeamServiceHelper.createPlayer();
		when(teamRepository.findByNumber(1)).thenReturn(TeamServiceHelper.createPlayer());
		when(playerMapper.playerToPlayerDto(player)).thenReturn(TeamServiceHelper.createPlayerDTO());

		PlayerDTO playerDTO = teamService.getPlayerWithNumber(1);

		verify(teamRepository, times(1)).findByNumber(any(Long.class));
		assertNotNull(playerDTO);
		assertEquals(player.getIdPlayer(), playerDTO.getIdPlayer());
		assertEquals(player.getName(), playerDTO.getName());
		assertEquals(player.getNumber(), playerDTO.getNumber());
		assertEquals(player.getAge(), playerDTO.getAge());
	}

	@Test
	public void testInsert() throws Exception {
		PlayerDTO playerDTO = TeamServiceHelper.createPlayerDTO();
		Player player = TeamServiceHelper.createPlayer();
		when(playerMapper.playerDtoToPlayer(playerDTO)).thenReturn(player);
		when(teamRepository.existsById(1L)).thenReturn(false);

		teamService.insert(playerDTO);

		verify(teamRepository, times(1)).saveAndFlush(player);
	}
	
	@Test(expected = PlayerExistsConflictException.class)
	public void testInsertException() throws Exception {
		PlayerDTO playerDTO = TeamServiceHelper.createPlayerDTO();
		Player player = TeamServiceHelper.createPlayer();
		when(playerMapper.playerToPlayerDto(player)).thenReturn(playerDTO);
		when(teamRepository.findByNumber(1L)).thenReturn(player);

		teamService.insert(playerDTO);
	}

	@Test
	public void testUpdate() throws Exception {
		PlayerDTO playerDTO = TeamServiceHelper.createPlayerDTO();
		Player player = TeamServiceHelper.createPlayer();
		when(playerMapper.playerDtoToPlayer(playerDTO)).thenReturn(player);

		teamService.update(playerDTO);

		verify(teamRepository, times(1)).saveAndFlush(player);
	}

	@Test
	public void testDelete() throws Exception {
		teamService.delete(1);

		verify(teamRepository, times(1)).deleteById(1L);
	}

	@Test
	public void testIsUserExist() throws Exception {
		teamService.isUserExist(1L);

		verify(teamRepository, times(1)).existsById(1L);
	}

}
