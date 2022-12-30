package edu.up.consorcio.clase;

import java.time.LocalDate;

public class Expensas {
	
	private int id;
	private int mes;
	private int anio;
	
	private double deuda=0;
	private double interesDeuda=0;
	private double expensaActual=0;
	private double total=0;
	
	private double pago=0;
	private LocalDate fechaPago;
	
	public Expensas(int id, int mes, int anio, double deuda, double interesDeuda, double expensaActual, double total, double pago, LocalDate fechaPago) {
		
		this.id=id;
		this.mes=mes;
		this.anio=anio;
		this.deuda=deuda;
		this.interesDeuda=interesDeuda;
		this.expensaActual=expensaActual;
		this.total=total;
		this.pago=pago;
		this.fechaPago=fechaPago;
	}
	
	public Expensas(int mes, int anio, double deuda, double interesDeuda, double expensaActual, double total, double pago) {
		
		this.mes=mes;
		this.anio=anio;
		this.deuda=deuda;
		this.interesDeuda=interesDeuda;
		this.expensaActual=expensaActual;
		this.total=total;
		this.pago=pago;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public double getInteresDeuda() {
		return interesDeuda;
	}

	public void setInteresDeuda(double interesDeuda) {
		this.interesDeuda = interesDeuda;
	}

	public double getExpensaActual() {
		return expensaActual;
	}

	public void setExpensaActual(double expensaActual) {
		this.expensaActual = expensaActual;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPago() {
		return pago;
	}

	public void setPago(double pago) {
		this.pago = pago;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}


	
}
