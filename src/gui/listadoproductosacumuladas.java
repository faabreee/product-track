package gui;

import java.awt.BorderLayout;
import clases.*;
import arreglos.*;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class listadoproductosacumuladas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			listadoproductosacumuladas dialog = new listadoproductosacumuladas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public listadoproductosacumuladas() {
		setTitle("Productos por unidades vendidas acumuladas");
		setBounds(100, 100, 503, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 469, 407);
		contentPanel.add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
		scrollPane.setViewportView(txtArea);
		
		listar();
		}
	ArregloProductos ap = new ArregloProductos();
	ArregloVenta av = new ArregloVenta();
		
	void listar() {
			txtArea.setText("");
			imprimir("               PRODUCTOS POR UNIDADES VENDIDAS ACUMULADAS");
			imprimir("----------------------------------------------------------------------------------------------------------------");
			Producto p;
			Venta v;
			for (int i=0; i<ap.tamanio(); i++) {
				p = ap.obtener(i);
				imprimir(" Codigo de producto"+"\t"+"\t"+": "+p.getCodigoProducto());
				imprimir(" Nombre de producto"+"\t"+"\t"+": "+p.getNombre());
				imprimir(" Cantidad de unidades vendidas"+"\t"+"\t"+": "+av.cantidadUnidades(p)+" unidades");
				imprimir("------------------------------------------------------");
			}	



			
			/*for (int i=0; i<ave.tamanio(); i++) {
				v = ave.obtener(i);
				p = ap.obtener(i);
					v = ave.buscar(v.getCodigoVenta());
					imprimir(" Codigo de producto "+"\t"+"\t" + ": " + p.getCodigoProducto());
					imprimir(" Nombre del producto "+"\t"+"\t" + ": " + p.getNombre());
					imprimir(" Cantidad de unidades vendidas "+"\t" + ": " + ave.importeTotal());
					imprimir("----------------------------------------------------------------------------------");
			}*/
		}
		
	void imprimir() {
		imprimir("");
	}
	void imprimir(String s) {
		txtArea.append(s +"\n");
	}
}
