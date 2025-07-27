package gui;

import clases.*;
import arreglos.*;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class listadoproductosstock extends JDialog {
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			listadoproductosstock dialog = new listadoproductosstock();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public listadoproductosstock() {
		setTitle("Productos cuyo stock se encuentra debajo del stock minimo");
		setBounds(100, 100, 503, 464);
		getContentPane().setLayout(null);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 469, 407);
			getContentPane().add(scrollPane);
			txtS = new JTextArea();
			txtS.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
			scrollPane.setViewportView(txtS);
		
			listar();
		}
		ArregloProductos ap = new ArregloProductos();
		
		void listar() {
			txtS.setText("");
			imprimir("    PRODUCTOS CUYO STOCK SE ECUENTRA DEBAJO DEL STOCK MINIMO");
			imprimir("--------------------------------------------------------------------------------------------------------------------");
			Producto p = null;
			for (int i=0; i<ap.tamanio(); i++) {
				p = ap.obtener(i);
				p = ap.buscar(p.getCodigoProducto());
				if(p.getStockActual()<p.getStockMinimo()) {
					imprimir(" Codigo de Producto "+"\t" + ": " + p.getCodigoProducto());
					imprimir(" Nombre de Producto "+"\t"+": " + p.getNombre());
					imprimir(" Stock Actual"+"\t"+"\t"+": " + p.getStockActual()+" unidades");
					imprimir(" Stock Minimo "+"\t"+"\t"+": " + p.getStockMinimo()+" unidades");
					imprimir("------------------------------------------------------------");
				}
	
			}
			
		}
		//*******************************
			void imprimir() {
			imprimir("");
		}
		void imprimir(String s) {
			txtS.append(s + "\n");
		}

		

}
