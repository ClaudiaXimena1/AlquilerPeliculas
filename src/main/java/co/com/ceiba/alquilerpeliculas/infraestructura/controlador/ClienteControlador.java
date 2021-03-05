package co.com.ceiba.alquilerpeliculas.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.cliente.CrearClienteManejador;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;

@RestController
@RequestMapping("/gestion-clientes")
public class ClienteControlador {

	private final CrearClienteManejador crearClienteManejador;
	private static final String CLIENTE_CREADO = "Cliente Creado Correctamente.";

	public ClienteControlador(CrearClienteManejador crearClienteManejador) {
		this.crearClienteManejador = crearClienteManejador;

	}

	@PostMapping("/clientes")
	public ResponseEntity<String> crearCliente(@RequestBody ClienteDto clienteDto) {
		crearClienteManejador.ejecutar(clienteDto);
		
		return new ResponseEntity<>(CLIENTE_CREADO, HttpStatus.CREATED);
	}

}
