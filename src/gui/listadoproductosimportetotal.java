package gui;

import javax.swing.JDialog;

import arreglos.ArregloProductos;
import arreglos.ArregloVenta;
import clases.Producto;
import clases.Venta;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class listadoproductosimportetotal extends JDialog {
	private JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			listadoproductosimportetotal dialog = new listadoproductosimportetotal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public listadoproductosimportetotal() {
		setTitle("Productos por importe total acumulado");
		setBounds(100, 100, 503, 464);
		getContentPane().setLayout(null);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 469, 407);
			getContentPane().add(scrollPane);
			txtArea = new JTextArea();
			txtArea.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
			scrollPane.setViewportView(txtArea);
			
			listar();
		}
		ArregloVenta ave = new ArregloVenta();
		ArregloProductos ap = new ArregloProductos();

		void listar() {
			txtArea.setText("");
			imprimir("                        PRODUCTOS POR IMPORTE TOTAL");
			imprimir("----------------------------------------------------------------------------------------------------------------");
			Venta v = null ;
			Producto p = null;
			int cant=0;
			for (int i=0; i<ap.tamanio(); i++) {
				p = ap.obtener(i);
				cant=0;
				for (int j=0; j<ave.tamanio(); j++) {
					v = ave.obtener(j);
					if(p.getCodigoProducto() == v.getCodigoProducto()) {
						cant += v.getPrecio();
					}
				}
				
				imprimir(" Producto "+"\t"+"\t" + ": " + p.getCodigoProducto());
				imprimir(" Nombre "+"\t"+"\t"+": " + p.getNombre());
				imprimir(" Importe total acumulado"+"\t"+": "+"S/. "+cant);
				imprimir("-----------------------------------------------------------------");
				}


	
			}
		
		//************************************************
		void imprimir() {
			imprimir(" ");
		}
		
		void imprimir(String s) {
			txtArea.append(s +"\n");
		
	}
	
		
}

