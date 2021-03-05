package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.cliente;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.cliente.CrearClienteServicio;

@Component
public class CrearClienteManejador {

	private CrearClienteServicio clienteServicio;

	public CrearClienteManejador(CrearClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}
	
	@Transactional
	public ClienteDto ejecutar(ClienteDto clienteDto) {
		Cliente cliente = new Cliente(null, clienteDto.getIdentificacion(), clienteDto.getNombres(),
				clienteDto.getApellidos(), clienteDto.getDireccion(), clienteDto.getTelefonoFijo(),
				clienteDto.getTelefonoMovil());

		return this.clienteServicio.ejecutar(cliente);
	}

}
