package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.factory;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.PeliculaEntity;

public final class PeliculaFactory {

	private PeliculaFactory() {

	}

	public static PeliculaDto toModel(PeliculaEntity peliculaEntity) {
		return new PeliculaDto(peliculaEntity.getNombre(), peliculaEntity.getGenero(), peliculaEntity.getDuracion());

	}

	public static PeliculaEntity toEntity(Pelicula pelicula) {
		return PeliculaEntity.builder().id(pelicula.getId()).nombre(pelicula.getNombre()).genero(pelicula.getGenero())
				.duracion(pelicula.getDuracion()).build();
	}

	public static Pelicula toEntidad(PeliculaDto peliculaDto) {
		return new Pelicula(null, peliculaDto.getNombre(), peliculaDto.getGenero(), peliculaDto.getDuracion());
	}

}
