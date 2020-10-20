package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.cliente;

import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.cliente.CrearClienteServicio;

@Component
public class CrearClienteManejador {
	
	private CrearClienteServicio clienteServicio;

	public CrearClienteManejador(CrearClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}
	
	public void ejecutar(Cliente cliente) {
		this.clienteServicio.ejecutar(cliente);
	}

}
