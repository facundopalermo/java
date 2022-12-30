package edu.up.config.otros;

import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ImprimirTablaModel {

	public void imprimirTabla(JTable jTable, String header, String footer, boolean showPrintDialog){        
	    boolean fitWidth = true;        
	    boolean interactive = true;
	    JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
	    try {          
	        boolean complete = jTable.print(mode,
	                new MessageFormat(header),
	                new MessageFormat(footer),
	                showPrintDialog,
	                null,
	                interactive);                 
	        if (complete) {
	            JOptionPane.showMessageDialog(jTable,
	                    "Impresión completa", "Resultado de la impresión",
	                    JOptionPane.INFORMATION_MESSAGE);
	        } else {                
	            JOptionPane.showMessageDialog(jTable,
	                    "Impresión cancelada","Resultado de la impresión",
	                    JOptionPane.WARNING_MESSAGE);
	        }
	    } catch (PrinterException pe) {
	        JOptionPane.showMessageDialog(jTable, 
	                "Fallo de impresión: " + pe.getMessage(), 
	                "Resultado de la impresión", 
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
}
