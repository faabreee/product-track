package gui;

import arreglos.*;
import clases.*;
import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class listadogeneral extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			listadogeneral dialog = new listadogeneral();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public listadogeneral() {
		setTitle("Listado general de ventas");
		setBounds(100, 100, 503, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 469, 407);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
			
		listar();
		
		}
		ArregloVenta av = new ArregloVenta();

	void listar() {
		txtS.setText("");
		imprimir("                             LISTADO GENERAL DE LAS VENTAS");
		imprimir("----------------------------------------------------------------------------------------------------------------");
		Venta v;
		for (int i=0; i<av.tamanio(); i++) {
			v = av.obtener(i);
				v = av.buscar(v.getCodigoVenta());
				imprimir(" Codigo de venta "+"\t" + ": " + v.getCodigoVenta());
				imprimir(" Codigo de cliente "+"\t" + ": " + v.getCodigoCliente());
				imprimir(" Codigo de producto "+"\t" + ": " + v.getCodigoProducto());
				imprimir(" Fecha "+"\t"+"\t" + ": " + v.getFecha());
				imprimir("");
				imprimir(" Importe subtotal "+"\t" + ": "+"S/. " + v.importeSubtotal());
				imprimir(" Importe IGV "+"\t"+"\t" + ": "+"S/. " + v.importeIgv());
				imprimir("");
				imprimir(" Importe total "+"\t"+"\t" + ": "+"S/. " + v.importeTotal());
				imprimir("---------------------------------------------------------------");
				imprimir("");
		}
	}
	
	
	//***************************
	void imprimir() {
		imprimir("");
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
