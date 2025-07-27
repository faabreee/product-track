package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import arreglos.ArregloProductos;
import clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


	
	public class nuevostock extends JDialog implements ActionListener{

		private final JPanel contentPanel = new JPanel();
		private JComboBox<Integer> cmbCodigoProducto;
		private JLabel lblCodigoProducto;
		private JLabel lblCantidad;
		private JTextField txtCantidad;
		private JButton btnAgregar;
		private JButton btnCancelar;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			try {
				nuevostock dialog = new nuevostock();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Create the dialog.
		 */ 
		public nuevostock() {
			setTitle("Ingresar nuevo stock");
			setBounds(100, 100, 532, 128);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBackground(SystemColor.menu);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			
			cmbCodigoProducto = new JComboBox<Integer>();
			cmbCodigoProducto.setBackground(Color.WHITE);
			cmbCodigoProducto.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
			cmbCodigoProducto.setBounds(167, 22, 100, 21);
			contentPanel.add(cmbCodigoProducto);
			
			lblCodigoProducto = new JLabel("CODIGO DE PRODUCTO :");
			lblCodigoProducto.setBounds(10, 28, 156, 13);
			contentPanel.add(lblCodigoProducto);
			
			lblCantidad = new JLabel("CANTIDAD :");
			lblCantidad.setBounds(10, 50, 80, 13);
			contentPanel.add(lblCantidad);
			
			txtCantidad = new JTextField();
			txtCantidad.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
			txtCantidad.setBounds(167, 47, 100, 19);
			contentPanel.add(txtCantidad);
			txtCantidad.setColumns(10);
			
			btnAgregar = new JButton("AGREGAR");
			btnAgregar.addActionListener(this);
			btnAgregar.setBounds(399, 23, 109, 21);
			contentPanel.add(btnAgregar);
			
			btnCancelar = new JButton("CANCELAR");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(399, 46, 109, 21);
			contentPanel.add(btnCancelar);
			listarCodigo();
		}
		ArregloProductos ap = new ArregloProductos();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnAgregar) {
				actionPerformedbtnAgregar(e);
			}
			if(e.getSource() == btnCancelar) {
				actionPerformedbtnCancelar(e);
			}
		}
		public void actionPerformedbtnAgregar(ActionEvent e) {
			try {
				Producto x = ap.buscar(leerCodigo());
				producto p = new producto();
				int cantidad = leerCantidad();
				if((cantidad+x.getStockActual()) <= x.getStockMaximo()) {
					x.setStockActual(x.getStockActual()+leerCantidad());
					mensaje("Stock ingresado correctamente");
					ap.actualizarArchivo();
				}
				else
					mensaje("Stock Maximo es : " + x.getStockMaximo() + "\n"+" Ingrese nuevamente");
				limpieza();
			} catch (Exception e2) {
				// TODO: handle exception
				mensaje("Por favor Ingrese la cantidad");
			}
		}
		public void actionPerformedbtnCancelar(ActionEvent e) {
			limpieza();
		}
		
		//***********************************
		
		int leerCodigo () {
			return Integer.parseInt(cmbCodigoProducto.getSelectedItem().toString());
		}
		
		int leerCantidad () {
			return  Integer.parseInt(txtCantidad.getText().trim());
		}
		
		void mensaje (String s) {
			JOptionPane.showMessageDialog(this, s);
		}
		
		void limpieza () {
			txtCantidad.setText("");
		}
		
		void listarCodigo () {
			cmbCodigoProducto.removeAllItems();
			for(int i =0; i < ap.tamanio(); i++) {
				cmbCodigoProducto.addItem(ap.obtener(i).getCodigoProducto());
			}
		}
		
		void sumaCantStock(){
			Producto x = ap.buscar(leerCodigo());
			x.setStockActual(x.getStockActual()+leerCantidad());
		}
		
	}

	
