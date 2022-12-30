package edu.up.consorcio.clase;

import java.time.LocalDate;

public class Movimiento {
	
	private int id;
	private LocalDate fecha;
	private String detalle;
	private double salida;
	private double entrada;
	
	
	public Movimiento(int id, LocalDate fecha, String detalle, double entrada, double salida) {
		this.setId(id);
		this.fecha=fecha;
		this.detalle=detalle;
		this.salida=salida;
		this.entrada=entrada;
	}
	
	public Movimiento(LocalDate fecha, String detalle) {
		this.fecha=fecha;
		this.detalle=detalle;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getSalida() {
		return salida;
	}
	public void setSalida(double salida) {
		this.salida = salida;
	}
	public double getEntrada() {
		return entrada;
	}
	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
