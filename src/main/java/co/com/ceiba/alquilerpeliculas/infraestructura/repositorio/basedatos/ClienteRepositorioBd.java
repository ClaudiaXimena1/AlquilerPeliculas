package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.basedatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.ClienteEntity;

public interface ClienteRepositorioBd extends JpaRepository<ClienteEntity, Long> {
	
	@Query("Select p from ClienteEntity p where p.identificacion =:identificacion")
	public ClienteEntity findByIdentificacion(@Param("identificacion") String identificacion);

}