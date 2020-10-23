package es.correos.soporte.minerva.proyectoejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.correos.soporte.minerva.proyectoejemplo.domain.Orden;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {

}
