package edu.up.consorcio.services;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import edu.up.config.excepciones.ExpensasServiceExeption;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.ui.comun.Frame;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.UF;
import edu.up.consorcio.ui.ExpensasTablePanel;
import edu.up.consorcio.ui.MovimientosTablePanel;

public class GenerarResumen implements Printable{
	
	private JPanel marco = new JPanel();
	
	public void armar(int mes, int anio, Edificio edificio, UF uf) throws ExpensasServiceExeption {
		
		Frame ventana = new Frame(630, 870, "Vista Previa", false, JFrame.DISPOSE_ON_CLOSE);
		int posY=0;
		int ancho=630;
		ventana.setBackground(Color.WHITE);
		
		marco.setLayout(null);
		marco.setSize(630,870);
		marco.setOpaque(true);
		marco.setBackground(Color.WHITE);
		
		//1
		JLabel lbl_titulo = new JLabel ("Resumen Expensas - Consorcio " + edificio.getDir_calle() + " " + edificio.getDir_altura() + " - Departamento " + uf.getU() + "° " + uf.getF() + "°");
		lbl_titulo.setBounds(0, posY, ancho, 30);
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		marco.add(lbl_titulo);
		
		//2
		posY+=31;
		JLabel lbl_separador1 = new JLabel(" ");
		lbl_separador1.setBounds(0, posY, ancho, 10);
		marco.add(lbl_separador1);
		
		//3
		posY+=11;
		JLabel lbl_resumeGastos = new JLabel("Resumen de gastos");
		lbl_resumeGastos.setBounds(0, posY, ancho, 30);
		lbl_resumeGastos.setHorizontalAlignment(SwingConstants.CENTER);
		marco.add(lbl_resumeGastos);
		
		//4
		posY+=31;
		MovimientosTablePanel movimientosTablePanel = new MovimientosTablePanel(edificio);
		JTable tablaMV = movimientosTablePanel.getTablaMov();
		tablaMV.setRowHeight(20);
		JScrollPane scroll = new JScrollPane(tablaMV);
		String consolidado = movimientosTablePanel.setContenido(mes, anio);
		
		int n = (tablaMV.getRowCount() * 20)+23;
		scroll.setBounds(0, posY, ancho-30, n);
		marco.add(scroll);
		
		//5
		posY+=n;
		JLabel lbl_separador2 = new JLabel(" ");
		lbl_separador2.setBounds(0, posY, ancho, 10);
		marco.add(lbl_separador2);
		
		//6
		posY+=11;
		JLabel lbl_consolidado = new JLabel(consolidado);
		lbl_consolidado.setBounds(0, posY, ancho, 30);
		lbl_consolidado.setHorizontalAlignment(SwingConstants.CENTER);
		marco.add(lbl_consolidado);
		
		//7
		posY+=31;
		JLabel lbl_separador3 = new JLabel(" ");
		lbl_separador3.setBounds(0, posY, ancho, 10);
		marco.add(lbl_separador3);
		
		//8
		posY+=11;
		JLabel lbl_resumeExpensas = new JLabel("Resumen de expensas");
		lbl_resumeExpensas.setBounds(0, posY, ancho, 30);
		lbl_resumeExpensas.setHorizontalAlignment(SwingConstants.CENTER);
		marco.add(lbl_resumeExpensas);
		
		//9
		posY+=31;
		ExpensasTablePanel expensasTablePanel = new ExpensasTablePanel(uf, edificio);
		JTable tablaEx = expensasTablePanel.getTablaMov();
		tablaEx.setRowHeight(20);
		JScrollPane scroll2 = new JScrollPane(tablaEx);
		expensasTablePanel.setContenido(mes, anio);
		
		scroll2.setBounds(0, posY, ancho-30, 43);
		marco.add(scroll2);

		ventana.add(marco);
		ventana.validate();
		ventana.repaint();
		ventana.setVisible(true);
		ventana.setVisible(false);
		
		
        try {
			  PrinterJob job = PrinterJob.getPrinterJob();
			  job.setPrintable(this);
			  if(job.printDialog()) {;
			  	job.print();
			  }else {
				  Mensaje.info(ventana, "Impresion cancelada", "Imprimir");
			  }
		} catch (PrinterException ex) {
			  throw new ExpensasServiceExeption(ex);
		}
		
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 0) {
			  return NO_SUCH_PAGE;
		}
			Graphics2D g2d = (Graphics2D)graphics;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

			marco.printAll(graphics);

			return PAGE_EXISTS;
	}
}
