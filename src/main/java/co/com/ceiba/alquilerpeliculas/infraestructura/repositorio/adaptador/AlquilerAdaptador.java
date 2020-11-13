package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.adaptador;

import org.springframework.stereotype.Repository;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.AlquilerDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Alquiler;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.AlquilerRepositorio;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.basedatos.AlquilerRepositorioBd;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.AlquilerEntity;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.factory.AlquilerFactory;

@Repository
public class AlquilerAdaptador implements AlquilerRepositorio {

	private AlquilerRepositorioBd alquilerRepositorioBd;

	public AlquilerAdaptador(AlquilerRepositorioBd alquilerRepositorioBd) {
		this.alquilerRepositorioBd = alquilerRepositorioBd;
	}

	@Override
	public AlquilerDto registrarAlquiler(Alquiler alquiler) {
		AlquilerEntity alquilerEntity = AlquilerFactory.toEntity(alquiler);

		return AlquilerFactory.toModel(alquilerRepositorioBd.save(alquilerEntity));
	}

	@Override
	public Double calcularTotalAlquiler(String identificacion, String fechaAlquiler) {
		return alquilerRepositorioBd.calcularTotalAlquiler(identificacion, fechaAlquiler);
	}
	
}
