package co.com.ceiba.alquilerpeliculas.infraestructura.testdatabuilder;

import java.util.Date;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.AlquilerDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;

public class AlquilerTestDataBuilder {

	private Date fechaAlquiler;
	private Date fechaEntrega;
	private Double valor;
	private ClienteDto clienteDto;
	private PeliculaDto peliculaDto;

	public AlquilerTestDataBuilder() {
		this.fechaAlquiler = new Date();
		this.fechaEntrega = new Date();
		this.valor = (double) 5000;
	}

	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ClienteDto getClienteDto() {
		return clienteDto;
	}

	public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}

	public PeliculaDto getPeliculaDto() {
		return peliculaDto;
	}

	public void setPeliculaDto(PeliculaDto peliculaDto) {
		this.peliculaDto = peliculaDto;
	}
	
	public AlquilerDto build() {
		return new AlquilerDto(fechaAlquiler, fechaEntrega, valor, clienteDto, peliculaDto);
	}

}
