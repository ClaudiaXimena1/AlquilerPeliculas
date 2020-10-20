package co.com.ceiba.alquilerpeliculas.dominio.servicio.cliente;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.ClienteRepositorio;

public class CrearClienteServicio {
	
	private ClienteRepositorio clienteRepositorio;

	public CrearClienteServicio(ClienteRepositorio clienteRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
	}
	
	public void ejecutar(Cliente cliente) {
		this.clienteRepositorio.crearCliente(cliente);
	}

}
