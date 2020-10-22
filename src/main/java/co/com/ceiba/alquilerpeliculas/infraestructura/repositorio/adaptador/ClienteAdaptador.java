package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.adaptador;

import org.springframework.stereotype.Repository;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.ClienteRepositorio;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.basedatos.ClienteRepositorioBd;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.factory.ClienteFactory;

@Repository
public class ClienteAdaptador implements ClienteRepositorio {
	
	private ClienteRepositorioBd clienteRepositorioBd;
	
	public ClienteAdaptador(ClienteRepositorioBd clienteRepositorioBd) {
		this.clienteRepositorioBd = clienteRepositorioBd;
	}

	@Override
	public void crearCliente(Cliente cliente) {
		this.clienteRepositorioBd.save(ClienteFactory.toEntity(cliente));
		
	}

}