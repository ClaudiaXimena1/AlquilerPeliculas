package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.factory;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.ClienteEntity;

public final class ClienteFactory {

	private ClienteFactory() {

	}

	public static ClienteEntity toEntity(Cliente cliente) {
		return ClienteEntity.builder().id(cliente.getId()).identificacion(cliente.getIdentificacion())
				.nombres(cliente.getNombres()).apellidos(cliente.getApellidos()).direccion(cliente.getDireccion())
				.telefonoFijo(cliente.getTelefonoFijo()).telefonoMovil(cliente.getTelefonoMovil())
				.fechaRegistro(cliente.getFechaRegistro()).build();
	}

}
