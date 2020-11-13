package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.basedatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.AlquilerEntity;

public interface AlquilerRepositorioBd extends JpaRepository<AlquilerEntity, Long> {
	
	@Query(value = "Select IFNULL(SUM(a.valor), 0) from alquiler_entity a, cliente_entity c where a.id_cliente = c.id and c.identificacion = :identificacion and a.fecha_alquiler LIKE :fechaAlquiler%", nativeQuery = true)
	public Double calcularTotalAlquiler(@Param("identificacion") String identificacion, @Param("fechaAlquiler") String fechaAlquiler);

}
