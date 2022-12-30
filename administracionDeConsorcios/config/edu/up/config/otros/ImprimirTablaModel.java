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
	                    "Impresi�n completa", "Resultado de la impresi�n",
	                    JOptionPane.INFORMATION_MESSAGE);
	        } else {                
	            JOptionPane.showMessageDialog(jTable,
	                    "Impresi�n cancelada","Resultado de la impresi�n",
	                    JOptionPane.WARNING_MESSAGE);
	        }
	    } catch (PrinterException pe) {
	        JOptionPane.showMessageDialog(jTable, 
	                "Fallo de impresi�n: " + pe.getMessage(), 
	                "Resultado de la impresi�n", 
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
}
