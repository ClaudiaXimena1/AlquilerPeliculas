package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.factory;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.ClienteEntity;

public final class ClienteFactory {

	private ClienteFactory() {

	}

	public static ClienteDto toModel(ClienteEntity clienteEntity) {
		return new ClienteDto(clienteEntity.getIdentificacion(), clienteEntity.getNombres(),
				clienteEntity.getApellidos(), clienteEntity.getDireccion(), clienteEntity.getTelefonoFijo(),
				clienteEntity.getTelefonoMovil());

	}

	public static ClienteEntity toEntity(Cliente cliente) {
		return ClienteEntity.builder().id(cliente.getId()).identificacion(cliente.getIdentificacion())
				.nombres(cliente.getNombres()).apellidos(cliente.getApellidos()).direccion(cliente.getDireccion())
				.telefonoFijo(cliente.getTelefonoFijo()).telefonoMovil(cliente.getTelefonoMovil())
				.fechaRegistro(cliente.getFechaRegistro()).build();
	}

	public static Cliente toEntidad(ClienteDto clienteDto) {
		return new Cliente(null, clienteDto.getIdentificacion(), clienteDto.getNombres(), clienteDto.getApellidos(),
				clienteDto.getDireccion(), clienteDto.getTelefonoFijo(), clienteDto.getTelefonoMovil());
	}
	
	public static Cliente toEntidad(ClienteEntity clienteEntity) {
		return new Cliente(clienteEntity.getId(), clienteEntity.getIdentificacion(), clienteEntity.getNombres(), clienteEntity.getApellidos(),
				clienteEntity.getDireccion(), clienteEntity.getTelefonoFijo(), clienteEntity.getTelefonoMovil());
	}

}
