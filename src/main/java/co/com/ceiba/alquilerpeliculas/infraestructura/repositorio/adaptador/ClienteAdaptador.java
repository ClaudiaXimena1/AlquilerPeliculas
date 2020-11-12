package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.adaptador;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.ClienteRepositorio;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.basedatos.ClienteRepositorioBd;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.ClienteEntity;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.factory.ClienteFactory;

@Repository
public class ClienteAdaptador implements ClienteRepositorio {

	private ClienteRepositorioBd clienteRepositorioBd;

	public ClienteAdaptador(ClienteRepositorioBd clienteRepositorioBd) {
		this.clienteRepositorioBd = clienteRepositorioBd;
	}

	@Override
	public ClienteDto crearCliente(Cliente cliente) {
		ClienteEntity clienteEntity = ClienteFactory.toEntity(cliente);
		return ClienteFactory.toModel(clienteRepositorioBd.save(clienteEntity));

	}

	public ClienteDto findByIdentificacion(String identificacion) {
		ClienteEntity clienteEntity = clienteRepositorioBd.findByIdentificacion(identificacion);
		if (clienteEntity == null) {
			return null;
		}
		return ClienteFactory.toModel(clienteEntity);
	}

	@Override
	public Long findIdByIdentificacion(String identificacion) {
		Long id;
		id = clienteRepositorioBd.findIdByIdentificacion(identificacion);

		return id;
	}

	@Override
	public Cliente findById(Long id) {
		Optional<ClienteEntity> clienteEntity = clienteRepositorioBd.findById(id);
		Cliente cliente = null;

		if (clienteEntity.isPresent()) {
			ClienteEntity clientEntity = clienteEntity.get();
			cliente = ClienteFactory.toEntidad(clientEntity);
		}

		return cliente;

	}

}