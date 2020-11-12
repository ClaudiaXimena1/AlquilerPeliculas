package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.basedatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.PeliculaEntity;

public interface PeliculaRepositorioBd extends JpaRepository<PeliculaEntity, Long> {
	
	@Query("Select p from PeliculaEntity p where p.genero =:genero")
	public List<PeliculaEntity> findByGenero(@Param("genero") String genero);
	
	@Query("Select p from PeliculaEntity p where p.nombre LIKE %:nombre%")
	public List<PeliculaEntity> findByNombre(@Param("nombre") String nombre);
	
	@Query("Select p.id from PeliculaEntity p where p.nombre =:nombre")
	public Long findIdByNombre(@Param("nombre") String nombre);

}
