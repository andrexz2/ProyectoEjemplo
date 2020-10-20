paquete para las interfaces jpa (se usa spring-data-jpa para implementar automáticamente todos los métodos)
que contienen todas las operaciones que se pueden realizar contra la BBDD. 
En este paquete se trabaja con clases Entity del paquete model.

Una clase repository podría ser:

import org.springframework.data.jpa.repository.JpaRepository;

import es.correos.soporte.minerva.proyectoejemplo.domain.Player;

public interface ITeamRepository extends JpaRepository<Player, Long> {

	Player findByNumber(long number);

}