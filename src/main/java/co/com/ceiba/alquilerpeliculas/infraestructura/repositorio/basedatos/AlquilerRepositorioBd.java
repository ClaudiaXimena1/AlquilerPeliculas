package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.basedatos;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.AlquilerEntity;

public interface AlquilerRepositorioBd extends JpaRepository<AlquilerEntity, Long> {

}
