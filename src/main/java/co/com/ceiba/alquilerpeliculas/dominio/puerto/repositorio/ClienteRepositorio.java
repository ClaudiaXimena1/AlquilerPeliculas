package co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;

public interface ClienteRepositorio {
	
	public ClienteDto crearCliente(Cliente cliente);
	
	public ClienteDto findByIdentificacion(String identificacion);
	
	public Long findIdByIdentificacion(String identificacion);
	
	public Cliente findById(Long id);

}
