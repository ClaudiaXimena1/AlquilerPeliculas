package co.com.ceiba.alquilerpeliculas.dominio.model.dto;

import lombok.Getter;

@Getter
public class ClienteDto {

	private String identificacion;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefonoFijo;
	private String telefonoMovil;

	public ClienteDto() {

	}

	public ClienteDto(String identificacion, String nombres, String apellidos, String direccion, String telefonoFijo,
			String telefonoMovil) {
		super();
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
	}

}
