package co.com.ceiba.alquilerpeliculas.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.alquiler.ConsultarTotalAlquilerManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.alquiler.RegistrarAlquilerManejador;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.AlquilerDto;

@RestController
@RequestMapping("/gestion-alquiler")
public class AlquilerControlador {

	private final RegistrarAlquilerManejador registrarAlquilerManejador;
	private final ConsultarTotalAlquilerManejador consultarTotalAlquilerManejador;

	@Autowired
	public AlquilerControlador(RegistrarAlquilerManejador registrarAlquilerManejador,
			ConsultarTotalAlquilerManejador consultarTotalAlquilerManejador) {
		this.registrarAlquilerManejador = registrarAlquilerManejador;
		this.consultarTotalAlquilerManejador = consultarTotalAlquilerManejador;

	}

	@PostMapping("/alquiler")
	public ResponseEntity<AlquilerDto> registrarAlquiler(@RequestBody AlquilerDto alquilerDto) {
		return new ResponseEntity<>(registrarAlquilerManejador.ejecutar(alquilerDto), HttpStatus.CREATED);
	}

	@PostMapping("/alquiler/{identificacion}/{fechaAlquiler}")
	public ResponseEntity<Double> calculaTotalAlquiler(@PathVariable String identificacion, @PathVariable String fechaAlquiler) {
		return new ResponseEntity<>(consultarTotalAlquilerManejador.ejecutar(identificacion, fechaAlquiler), HttpStatus.OK);
	}

}
