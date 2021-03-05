package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import java.util.Date;

public class Cliente {

	private static final String LA_IDENTIFICACION_ES_UN_DATO_OBLIGATORIO = "La Identificacion del Cliente es un dato obligatorio.";
	private static final String EL_NOMBRE_ES_UN_DATO_OBLIGATORIO = "El Nombre del Cliente es un dato obligatorio.";
	private static final String EL_APELLIDO_ES_UN_DATO_OBLIGATORIO = "El Apellido del Cliente es un dato obligatorio.";
	private static final String LA_DIRECCION_ES_UN_DATO_OBLIGATORIO = "La Direccion del Cliente es un dato obligatorio.";
	private static final String EL_TELEFONO_ES_UN_DATO_OBLIGATORIO = "Por lo menos un telefono es obligatorio.";
	
	private Long id;
	private String identificacion;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefonoFijo;
	private String telefonoMovil;
	private Date fechaRegistro;

	public Cliente() {

	}

	public Cliente(Long id, String identificacion, String nombres, String apellidos, String direccion, String telefonoFijo,
			String telefonoMovil) {
		
		ValidadorAtributos.validarAtributos(identificacion, LA_IDENTIFICACION_ES_UN_DATO_OBLIGATORIO);
		ValidadorAtributos.validarAtributos(nombres, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);
		ValidadorAtributos.validarAtributos(apellidos, EL_APELLIDO_ES_UN_DATO_OBLIGATORIO);
		ValidadorAtributos.validarAtributos(direccion, LA_DIRECCION_ES_UN_DATO_OBLIGATORIO);
		ValidadorAtributos.validarAtributos(telefonoFijo, EL_TELEFONO_ES_UN_DATO_OBLIGATORIO);
		
		this.id = id;
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
		this.fechaRegistro = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public Date getFechaRegistro() {
		return (Date) fechaRegistro.clone();
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = (Date) fechaRegistro.clone();
	}

}
