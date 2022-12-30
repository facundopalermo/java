package edu.up.consorcio.services;

import java.awt.Component;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import edu.up.config.excepciones.DAOException;
import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.excepciones.ExpensasServiceExeption;
import edu.up.config.mensaje.Mensaje;
import edu.up.consorcio.DAO.ExpensasDAO;
import edu.up.consorcio.DAO.ExpensasDAOH2Impl;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.Expensas;
import edu.up.consorcio.clase.Movimiento;
import edu.up.consorcio.clase.UF;

public class ExpensasService {
	
	private static final double INTERES_DEUDA = 0.05;
	private static final int REGLA_COEF = 3;
	private static final double COEF_PISO = 1;
	
	public static void generarExpensas(Edificio edificio, int mes, int anio) throws DAOServiceException, ExpensasServiceExeption {
		
		
		double deuda = 0;
		double interesDeuda = 0;
		double expensaSinCoef = 0;
		double expensaActual = 0;
		double total = 0;
		
				
		double gastos = edificio.getGastosTotales(mes);
		double valorM2 = gastos / edificio.getSuperficieTotal();
		
		if(!validarMesAnio(edificio, mes, anio)) {
		
			for (UF uf : edificio.getDepartamento()) {
				
				if ((uf.getListaExpensas().size()-1)>=0) {
					deuda = (uf.getListaExpensas().get(uf.getListaExpensas().size()-1).getTotal()) - (uf.getListaExpensas().get(uf.getListaExpensas().size()-1).getPago());
				}
				
				if (deuda>0) {
					interesDeuda = deuda * INTERES_DEUDA; 
				}
				
				expensaSinCoef = valorM2 * uf.getSuperficie();
				
				if (uf.getU() > REGLA_COEF) {
					expensaActual = expensaSinCoef * (1 + (COEF_PISO * (uf.getU()-REGLA_COEF))/100);
				}else {
					expensaActual = expensaSinCoef ;
				}
				
				total = deuda + interesDeuda + expensaActual;			
				
				Expensas expensa = new Expensas(mes, anio, deuda, interesDeuda, expensaActual, total, 0);
				
				crearExpensas (uf, expensa);
			}
		}

	}
	
	private static void crearExpensas (UF uf, Expensas expensas) throws DAOServiceException {
			
		ExpensasDAO dao = new ExpensasDAOH2Impl();
		try {
			dao.crearExpensas(uf, expensas);
			
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
	}
	
	private static boolean validarMesAnio(Edificio edificio, int mes, int anio) throws ExpensasServiceExeption{
		
		for (UF uf : edificio.getDepartamento()) {
			for (Expensas ex : uf.getListaExpensas()) {
				if (ex.getMes()==mes && ex.getAnio()==anio) {
					throw new ExpensasServiceExeption();
				}
			}
		}
		return false;
	}

	public static void ingresarPago(Component comp, Edificio edificio, UF uf) throws ExpensasServiceExeption, DAOServiceException {
		
		Expensas ultimaExpensa = uf.getListaExpensas().get(uf.getListaExpensas().size()-1);
		
		double monto=0;
		String entrada=JOptionPane.showInputDialog(comp, "Ingrese el monto pagado (en $)","");
		
		try {
			if(entrada!=null) {
				monto = Double.parseDouble(entrada);
				
				double pagoAnteriorSiHay = ultimaExpensa.getPago();
				ultimaExpensa.setPago(pagoAnteriorSiHay + monto);
				ultimaExpensa.setFechaPago(LocalDate.now());
				
				ExpensasDAO dao = new ExpensasDAOH2Impl();
				dao.modificarExpensa(ultimaExpensa);
				
				
				String detalle="Pago expensas de " + uf.getU() + "° " + uf.getF() + "°";
				LocalDate fecha=ultimaExpensa.getFechaPago();

				Movimiento mov_pago = new Movimiento(fecha, detalle);
				if(monto>=0) {
				mov_pago.setEntrada(ultimaExpensa.getPago());
				}else {
					mov_pago.setSalida(ultimaExpensa.getPago());
				}
				
				MovimientoService.crearMovimiento(mov_pago, edificio);
				
				Mensaje.info(comp, "Se ha registrado el pago con exito", "Pago realizado");
			}
		}catch(NumberFormatException e) {
			throw new ExpensasServiceExeption(e);
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
		
	}
	
	
}
