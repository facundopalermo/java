package edu.up.consorcio.clase;

import java.util.List;

public class Edificio {
	
	private int id;
	private String dir_calle;
	private int dir_altura;
	private String dir_localidad;
	private String nombre;
	private int superficieTotal;
	
	private int n_pisos;
	private List<UF> departamento;
	private List<Movimiento> movimientos;
	
	public Edificio(int id, String nombre, String direccion, int numero, String localidad, int pisos) {
		this.id=id;
		this.nombre=nombre;
		this.dir_calle=direccion;
		this.dir_altura=numero;
		this.dir_localidad=localidad;
		this.n_pisos=pisos;
		
	}
	
	public Edificio(int id, String nombre, String direccion, int numero, String localidad, int pisos, List<UF>departamento, List<Movimiento>movimientos) {
		this.id=id;
		this.nombre=nombre;
		this.dir_calle=direccion;
		this.dir_altura=numero;
		this.dir_localidad=localidad;
		this.n_pisos=pisos;
		this.departamento=departamento;	
		this.movimientos=movimientos;
	}

	
	public Edificio(String nombre, String direccion, int numero, String localidad, int pisos) {
		this.nombre=nombre;
		this.dir_calle=direccion;
		this.dir_altura=numero;
		this.dir_localidad=localidad;
		this.n_pisos=pisos;
	}
	
	public String getDir_calle() {
		return dir_calle;
	}
	public void setDir_calle(String dir_calle) {
		this.dir_calle = dir_calle;
	}
	public int getDir_altura() {
		return dir_altura;
	}
	public void setDir_altura(int dir_altura) {
		this.dir_altura = dir_altura;
	}
	public String getDir_localidad() {
		return dir_localidad;
	}
	public void setDir_localidad(String dir_localidad) {
		this.dir_localidad = dir_localidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String razon_social) {
		this.nombre = razon_social;
	}

	public int getN_pisos() {
		return n_pisos;
	}
	public void setN_pisos(int n_pisos) {
		this.n_pisos = n_pisos;
	}
	public List<UF> getDepartamento() {
		return departamento;
	}
	public void setDepartamento(List<UF> departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Consorcio " + nombre ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSuperficieTotal() {
		
		for(UF uf:this.departamento) {
			this.superficieTotal+=uf.getSuperficie();
		}
		return superficieTotal;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public double getGastosTotales(int mes) {
		
		double sumaGastos=0;
		
		for(Movimiento mv:this.movimientos) {
			
			if(mv.getFecha().getMonth().getValue()==mes) {
				sumaGastos+=mv.getSalida();
			}
		}
		
		return sumaGastos;
	}
	
	public double getIngresosTotales(int mes) {
		
		double sumaIngresos=0;
		
		for(Movimiento mv:this.movimientos) {
			
			if(mv.getFecha().getMonth().getValue()==mes) {
				sumaIngresos+=mv.getEntrada();
			}
		}
		
		return sumaIngresos;
	}
}
