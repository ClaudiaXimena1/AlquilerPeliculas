package co.com.ceiba.alquilerpeliculas.dominio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClienteDto {

	private String identificacion;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefonoFijo;
	private String telefonoMovil;	

}
