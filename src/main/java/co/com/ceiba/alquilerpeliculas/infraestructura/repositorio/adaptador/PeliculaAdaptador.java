package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.adaptador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.basedatos.PeliculaRepositorioBd;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.PeliculaEntity;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.factory.PeliculaFactory;

@Repository
public class PeliculaAdaptador implements PeliculaRepositorio {

	private PeliculaRepositorioBd peliculaRepositorioBd;
	
	@Autowired
	private ModelMapper modelMapper;

	public PeliculaAdaptador(PeliculaRepositorioBd peliculaRepositorioBd) {
		this.peliculaRepositorioBd = peliculaRepositorioBd;
	}

	@Override
	public PeliculaDto save(Pelicula pelicula) {
		PeliculaEntity peliculaEntity = PeliculaFactory.toEntity(pelicula);
		return PeliculaFactory.toModel(peliculaRepositorioBd.save(peliculaEntity));
	}

	@Override
	public List<PeliculaDto> findByGenero(String genero) {
		Iterable<PeliculaEntity> peliculas = peliculaRepositorioBd.findByGenero(genero);
		List<PeliculaDto> listaPeliculasDTO = new ArrayList<>();
		List<PeliculaEntity> listaPeliculas = new ArrayList<>();
		peliculas.iterator().forEachRemaining(listaPeliculas::add);

		for (int i = 0; i < listaPeliculas.size(); i++) {

			PeliculaDto peliculaDto = PeliculaFactory.toModel(listaPeliculas.get(i));
			listaPeliculasDTO.add(peliculaDto);

		}

		return listaPeliculasDTO;
	}

	@Override
	public List<PeliculaDto> findByNombre(String nombre) {
		Iterable<PeliculaEntity> peliculas = peliculaRepositorioBd.findByNombre(nombre);
		List<PeliculaDto> listaPeliculasDTO = new ArrayList<>();
		List<PeliculaEntity> listaPeliculas = new ArrayList<>();
		peliculas.iterator().forEachRemaining(listaPeliculas::add);

		for (int i = 0; i < listaPeliculas.size(); i++) {

			PeliculaDto peliculaDto = PeliculaFactory.toModel(listaPeliculas.get(i));
			listaPeliculasDTO.add(peliculaDto);

		}

		return listaPeliculasDTO;
	}

	@Override
	public Pelicula findById(Long id) {
		Optional<PeliculaEntity> peliculaEntity = peliculaRepositorioBd.findById(id);
		Pelicula pelicula = null;

		if (peliculaEntity.isPresent()) {
			PeliculaEntity peliEntity = peliculaEntity.get();
			pelicula = modelMapper.map(peliEntity, Pelicula.class);
			
		}

		return pelicula;

	}

}
