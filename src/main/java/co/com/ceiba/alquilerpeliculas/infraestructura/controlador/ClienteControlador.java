package co.com.ceiba.alquilerpeliculas.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	public ClienteControlador(CrearClienteManejador crearClienteManejador) {
		this.crearClienteManejador = crearClienteManejador;

	}

	@PostMapping("/clientes")
	public ResponseEntity<ClienteDto> crearCliente(@RequestBody ClienteDto clienteDto) {
		return new ResponseEntity<>(crearClienteManejador.ejecutar(clienteDto), HttpStatus.CREATED);
	}

}
