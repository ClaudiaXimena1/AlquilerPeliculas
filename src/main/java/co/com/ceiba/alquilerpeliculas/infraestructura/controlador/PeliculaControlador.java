package co.com.ceiba.alquilerpeliculas.infraestructura.controlador;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.ActualizarPeliculaManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.ConsultarPorGeneroManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.ConsultarPorIdManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.ConsultarPorNombreManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.CrearPeliculaManejador;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;

@RestController
@RequestMapping("/Peliculas")
public class PeliculaControlador {

	private final CrearPeliculaManejador crearPeliculaManejador;
	private final ActualizarPeliculaManejador actualizarPeliculaManejador;
	private final ConsultarPorGeneroManejador consultarPorGeneroManejador;
	private final ConsultarPorNombreManejador consultarPorNombreManejador;
	private final ConsultarPorIdManejador consultarPorIdManejador;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public PeliculaControlador(CrearPeliculaManejador crearPeliculaManejador,
			ActualizarPeliculaManejador actualizarPeliculaManejador,
			ConsultarPorGeneroManejador consultarPorGeneroManejador,
			ConsultarPorNombreManejador consultarPorNombreManejador, ConsultarPorIdManejador consultarPorIdManejador) {
		this.crearPeliculaManejador = crearPeliculaManejador;
		this.actualizarPeliculaManejador = actualizarPeliculaManejador;
		this.consultarPorGeneroManejador = consultarPorGeneroManejador;
		this.consultarPorNombreManejador = consultarPorNombreManejador;
		this.consultarPorIdManejador = consultarPorIdManejador;
	}

	@PostMapping("/crearPelicula")
	public ResponseEntity<PeliculaDto> crearPelicula(@RequestBody PeliculaDto peliculaDto) {

		return new ResponseEntity<>(crearPeliculaManejador.ejecutar(modelMapper.map(peliculaDto, Pelicula.class)),
				HttpStatus.CREATED);
	}

	@GetMapping("/consultarPeliGenero/{genero}")
	public ResponseEntity<List<PeliculaDto>> consultarPeliculaPorGenero(@PathVariable String genero) {

		return ResponseEntity.ok(consultarPorGeneroManejador.ejecutar(genero));

	}

	@GetMapping("/consultarPeliNombre/{nombre}")
	public ResponseEntity<List<PeliculaDto>> consultarPorNombreManejador(@PathVariable String nombre) {

		return ResponseEntity.ok(consultarPorNombreManejador.ejecutar(nombre));

	}

	@PutMapping("/actualizarPelicula/{id}")
	public ResponseEntity<PeliculaDto> actualizarPelicula(@RequestBody PeliculaDto peliculaDto, @PathVariable Long id) {
		Pelicula peliculaNew = consultarPorIdManejador.ejecutar(id);

		if (peliculaNew == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		peliculaNew.setNombre(peliculaDto.getNombre());
		peliculaNew.setGenero(peliculaDto.getGenero());
		peliculaNew.setDuracion(peliculaDto.getDuracion());

		return new ResponseEntity<>(actualizarPeliculaManejador.ejecutar(peliculaNew), HttpStatus.OK);
	}

}
