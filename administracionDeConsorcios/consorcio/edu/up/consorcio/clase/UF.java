package edu.up.consorcio.clase;

import java.util.List;

public class UF{
	
	private int id;
	private int u;
	private int f;
	private int superficie;
	private String ocupante;
	
	private List<Expensas> listaExpensas;
	
	
	public UF(int id, int u, int f, int mc, String ocupante, List<Expensas> listaExpensas) {
		this.id=id;
		this.u=u;
		this.f=f;
		this.superficie=mc;
		this.ocupante=ocupante;
		this.listaExpensas=listaExpensas;
	}
	
	public UF(int id, int u, int f, int mc, String ocupante) {
		this.id=id;
		this.u=u;
		this.f=f;
		this.superficie=mc;
		this.ocupante=ocupante;
	}
	
	public UF(int u, int f, int mc, String ocupante) {
		this.u=u;
		this.f=f;
		this.superficie=mc;
		this.ocupante=ocupante;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getOcupante() {
		return ocupante;
	}
	public void setOcupante(String ocupante) {
		this.ocupante = ocupante;
	}

	public String toString() {
		return id+" - "+u+" - "+f+" - "+superficie+" - "+ocupante;
	}

	public List<Expensas> getListaExpensas() {
		return listaExpensas;
	}

	public void setListaExpensas(List<Expensas> listaExpensas) {
		this.listaExpensas = listaExpensas;
	}
	
}
