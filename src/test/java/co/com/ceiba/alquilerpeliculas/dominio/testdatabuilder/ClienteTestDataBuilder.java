package co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;

public class ClienteTestDataBuilder {
	
	private Long id;
	private String identificacion;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefonoFijo;
	private String telefonoMovil;

	public ClienteTestDataBuilder() {
		this.id = null;
		this.identificacion = "14992992";
		this.nombres = "Samuel";
		this.apellidos = "Bustamante Grisales";
		this.direccion = "Cra. 1E #D70E22";
		this.telefonoFijo = "4445566";
		this.telefonoMovil = "3182525252";
	}

	public ClienteTestDataBuilder setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public ClienteTestDataBuilder setNombres(String nombres) {
		this.nombres = nombres;
		return this;
	}

	public ClienteTestDataBuilder setApellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	}

	public ClienteTestDataBuilder setDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public ClienteTestDataBuilder setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
		return this;
	}

	public ClienteTestDataBuilder setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
		return this;
	}

	public Cliente build() {
		return new Cliente(id, identificacion, nombres, apellidos, direccion, telefonoFijo, telefonoMovil);
	}

}
