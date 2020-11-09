package co.com.ceiba.alquilerpeliculas.dominio.servicio.cliente;

import java.util.Date;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaExistenciaExcepcion;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.ClienteRepositorio;

public class CrearClienteServicio {
	
	private ClienteRepositorio clienteRepositorio;
	private static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El Cliente ya existe en el sistema";


	public CrearClienteServicio(ClienteRepositorio clienteRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
	}
	
	public ClienteDto ejecutar(Cliente cliente) {
		Boolean existe = validaExisteCliente(cliente.getIdentificacion());

		if (Boolean.TRUE.equals(existe)) {
			throw new ValidaExistenciaExcepcion(EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
		}
		cliente.setFechaRegistro(new Date());
		
		return this.clienteRepositorio.crearCliente(cliente);
	}
	
	private Boolean validaExisteCliente(String identificacion) {
		ClienteDto clienteDto = clienteRepositorio.findByIdentificacion(identificacion);
		Boolean existe = true;

		if (clienteDto == null) {
			existe = false;
		}
		return existe;
	}

}
