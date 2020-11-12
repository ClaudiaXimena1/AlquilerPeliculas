package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.factory;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.AlquilerDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Alquiler;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.AlquilerEntity;

public final class AlquilerFactory {

	private AlquilerFactory() {

	}

	public static AlquilerDto toModel(AlquilerEntity alquilerEntity) {
		ClienteDto clienteDto = ClienteFactory.toModel(alquilerEntity.getClienteEntity());
		PeliculaDto peliculaDto = PeliculaFactory.toModel(alquilerEntity.getPeliculaEntity());

		return new AlquilerDto(alquilerEntity.getFechaAlquiler(), alquilerEntity.getFechaEntrega(),
				alquilerEntity.getValor(), clienteDto, peliculaDto);

	}

	public static AlquilerEntity toEntity(Alquiler alquiler) {

		return AlquilerEntity.builder().id(alquiler.getId()).fechaAlquiler(alquiler.getFechaAlquiler())
				.fechaEntrega(alquiler.getFechaEntrega()).valor(alquiler.getValor())
				.fechaRegistro(alquiler.getFechaRegistro())
				.clienteEntity(ClienteFactory.toEntity(alquiler.getCliente()))
				.peliculaEntity(PeliculaFactory.toEntity(alquiler.getPelicula())).build();
	}

	public static Alquiler toEntidad(AlquilerDto alquilerDto) {
		Cliente cliente = ClienteFactory.toEntidad(alquilerDto.getClienteDto());
		Pelicula pelicula = PeliculaFactory.toEntidad(alquilerDto.getPeliculaDto());

		return new Alquiler(alquilerDto.getFechaAlquiler(), alquilerDto.getFechaEntrega(), alquilerDto.getValor(),
				cliente, pelicula);

	}

}
