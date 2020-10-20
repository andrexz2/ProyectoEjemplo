paquete para clases de utilidad de los tests. Aquí se crean clases para construir objetos necesarios
para los tests. Por ejemplo, para una clase Player y su DTO asociado, esto sería un ejemplo:


public class TeamServiceHelper {

	public static Player createPlayer() {
		Player player = new Player();
		player.setIdPlayer(1L);
		player.setName("Player 1");
		player.setAge(11);
		player.setNumber(1L);
		return player;
	}

	public static List<Player> createPlayers() {
		return Arrays.asList(createPlayer());
	}

	public static PlayerDTO createPlayerDTO() {
		return PlayerDTO.builder().idPlayer(1L).name("Player 1").age(11).number(1L).build();
	}

	public static List<PlayerDTO> createPlayersDTO() {
		return Arrays.asList(createPlayerDTO());
	}

	public static List<PlayerDTO> createPlayersDTOEmpty() {
		return new ArrayList<>();
	}
}


