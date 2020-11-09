package co.com.ceiba.alquilerpeliculas.infraestructura.testdatabuilder;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;

public class ClienteTestDataBuilder {
	
	private String identificacion;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefonoFijo;
	private String telefonoMovil;
	
	public ClienteTestDataBuilder() {
		this.identificacion = "94444555";
		this.nombres = "Alexander";
		this.apellidos = "Lozada Avila";
		this.direccion = "Calle 8 #34-21";
		this.telefonoFijo = "5554422";
		this.telefonoMovil = "3166993322";
	}
	
	public ClienteDto build() {
		return new ClienteDto(identificacion, nombres, apellidos, direccion, telefonoFijo, telefonoMovil);
	}

}
