package gui;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloClientes;
import arreglos.ArregloProductos;
import arreglos.ArregloVenta;
import clases.Cliente;
import clases.Producto;
import clases.Venta;
import libreria.Fecha;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;


public class venta extends JDialog implements ActionListener, KeyListener, MouseListener{

	/**
	 * 
	 */
	private JPanel contentPane;
	private JLabel lblCodigoCliente;
	private JLabel lblCodigoProducto;
	private JLabel lblCantidadUnidadesAquiridas;
	private JButton btnAceptar;
	private JButton btnLimpiar;
	private JTextArea txtArea;
	private JTextField txtCodigoVenta;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private JTextField txtCantidad;
	private JLabel lblCaantidad;
	private JButton btnNuevo;
	private JComboBox <String>cmbCodigoCliente;
	private JComboBox <String>cmbCodigoProducto;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venta frame = new venta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public venta() {
		setTitle("Vender");
		setBounds(100, 100, 686, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigoCliente = new JLabel("CODIGO DE VENTA :");
		lblCodigoCliente.setBounds(10, 10, 158, 13);
		contentPane.add(lblCodigoCliente);
		
		lblCodigoProducto = new JLabel("CODIGO DE CLIENTE:");
		lblCodigoProducto.setBounds(10, 33, 158, 13);
		contentPane.add(lblCodigoProducto);
		
		lblCantidadUnidadesAquiridas = new JLabel("CODIGO DE PRODUCTO :");
		lblCantidadUnidadesAquiridas.setBounds(10, 56, 158, 13);
		contentPane.add(lblCantidadUnidadesAquiridas);
		
		cmbCodigoCliente = new JComboBox<String>();
		cmbCodigoCliente.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		cmbCodigoCliente.setBounds(168, 33, 145, 19);
		contentPane.add(cmbCodigoCliente);
		
		cmbCodigoProducto = new JComboBox<String>();
		cmbCodigoProducto.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		cmbCodigoProducto.setBounds(168, 56, 145, 19);
		contentPane.add(cmbCodigoProducto);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(323, 10, 111, 21);
		contentPane.add(btnAceptar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(551, 33, 111, 21);
		contentPane.add(btnLimpiar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 652, 242);
		contentPane.add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
		scrollPane.setViewportView(txtArea);
		
		txtCodigoVenta = new JTextField();
		txtCodigoVenta.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtCodigoVenta.setBounds(168, 7, 145, 19);
		contentPane.add(txtCodigoVenta);
		txtCodigoVenta.setColumns(10);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(551, 10, 111, 21);
		contentPane.add(btnNuevo);
		
		lblCaantidad = new JLabel("CANTIDAD :");
		lblCaantidad.setBounds(10, 79, 145, 13);
		contentPane.add(lblCaantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtCantidad.setBounds(168, 79, 145, 19);
		contentPane.add(txtCantidad);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO VENTA");
		modelo.addColumn("CODIGO CLIENTE");
		modelo.addColumn("CODIGO PRODUCTO");
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("PRECIO");
		modelo.addColumn("FECHA");

		txtCodigoVenta.setEditable(false);
		cmbCodigoCliente.setEnabled(false);
		cmbCodigoProducto.setEnabled(false);
		txtCantidad.setEditable(false);
		
		
		habilitarEntradas(false);
		habilitarProceder(false);
		colocarCodigosClientes();
		colocarCodigosProductos();
		visibleInvisible(false);
		
	}
		ArregloVenta av = new ArregloVenta();
		ArregloProductos ap = new ArregloProductos();
		
	//*************************************
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAceptar) {
			actionPerformedbtnAceptar(e);
		}
		if(e.getSource() == btnNuevo) {
			actionPerformedbtnNuevo(e);
		}
		if(e.getSource() == btnLimpiar) {
			actionPerformedbtnLimpiar(e);
		}
	}
	public void actionPerformedbtnAceptar(ActionEvent e) {
		Producto p = null;
		String cantidadStr = txtCantidad.getText().toString().trim();
		if(cantidadStr.equals("") || !tryParseInt(cantidadStr)) {
			error("Ingrese CANTIDAD correcta", txtCantidad);
			return;
		}
		
		int codigoVenta = leerCodigoVenta();
		int codigoCliente = leerCodigoCliente();
		int codigoProducto = leerCodigoProducto();
		int cantidad = Integer.parseInt(cantidadStr); //leerCantidad();
		p = ap.buscar(codigoProducto);
		if(cantidad > 0) {
			if(cantidad <= p.getStockActual()) {
				
				double precio = leerPrecio(codigoProducto);
				if(precio > 0) {
					String fecha = fechaActual(); //leerFecha(codigoVenta);
					if(!fecha.equals("")) { // "!" es igual a "== false"
						Venta nueva = new Venta(codigoVenta, codigoCliente, codigoProducto, cantidad, precio, fecha);
						restarStock();
						av.adicionar(nueva);
						btnNuevo.setEnabled(true);
						habilitarEntradas(false);
						deshabilitarDatos(true);
						listarBoleta();
					}
				}
			
			}
			else
				error("No hay suficiente Stock", txtCantidad);
			
			
			
		}
		else
			error("ingrese CANTIDAD correcta", txtCantidad);
	}
	public void actionPerformedbtnNuevo(ActionEvent e) {
		btnNuevo.setEnabled(false);
		btnLimpiar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		habilitarEntradas(true);
		habilitarDatos(true);
		visibleInvisible(false);
	}
	public void actionPerformedbtnLimpiar(ActionEvent e) {
		visibleInvisible(false);
		txtArea.setText("");
	}
	
	//*************

	public void mouseClicked(MouseEvent arg0) {
	}
	
	public void mouseClickedtbltable(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	
	//*************
	
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			mouseEnteredbtnAceptar(arg0);
		}		
		if (arg0.getSource() == btnNuevo) {
			mouseEnteredbtnNuevo(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			mouseEnteredbtnLimpiar(arg0);
		}
	}
	public void mouseEnteredbtnAceptar(MouseEvent arg0) {
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseEnteredbtnNuevo(MouseEvent arg0) {
		btnNuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseEnteredbtnLimpiar(MouseEvent arg0) {
		btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
		
	//*************************************
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}

	void listarBoleta(){
		ArregloVenta av = new ArregloVenta();
		ArregloClientes ar = new ArregloClientes();
		ArregloProductos ap = new ArregloProductos();
		
		Venta v = av.buscar(leerCodigoVenta());
	    Cliente c = ar.buscar(leerCodigoCliente());
	    Producto p = ap.buscar(leerCodigoProducto());
		
		txtArea.setText("");
		imprimir(" ------------------------- BOLETA DE PAGO -------------------------");
		imprimir(" Código de Cliente "+"\t"+"\t"+": "+ v.getCodigoCliente());
		imprimir(" Nombres y Apellidos del Cliente "+"\t"+": "+c.getNombres()+" "+c.getApellidos());
		imprimir(" ------------------------------------------------------------------------------");
		imprimir(" Código del producto "+"\t"+"\t"+": "+p.getCodigoProducto());
		imprimir(" Nombre del producto "+"\t"+"\t"+": "+p.getNombre());
		imprimir(" Cantidad de unidades vendidas "+"\t"+": "+v.getCantidad());
		imprimir(" Precio unitario "+"\t"+"\t"+": "+"S/."+v.getPrecio());
		imprimir(" ------------------------------------------------------------------------------");
		imprimir(" Importe subtotal "+"\t"+"\t"+": "+"S/."+v.importeSubtotal());
		imprimir(" Importe del IGV "+"\t"+"\t"+": "+"S/."+v.importeIgv());
		imprimir(" ------------------------------------------------------------------------------");
		imprimir(" Importe total a pagar "+"\t"+"\t"+": "+"S/."+v.importeTotal());
	}
	
	void editarFila() {

	}
	
	void limpiar() {
		txtArea.setText(" ");
	}
	
	void limpieza() {
		txtCodigoVenta.setText("" + av.codigoCorrelativo());
		txtCantidad.setText("");
	}
	
	//*************************************
	
	void colocarCodigosClientes() {
		ArregloClientes ar = new ArregloClientes();
		Cliente c;
		
		for (int i=0; i<ar.tamanio(); i++) {
			c = ar.obtener(i);
			if (av.procedeCodigoClientes(c.getCodigoCliente()))
				cmbCodigoCliente.addItem("" + c.getCodigoCliente());
		}
	}
		
	void colocarCodigosProductos() {
		ArregloProductos ap = new ArregloProductos();
		Producto c;
		for (int i=0; i<ap.tamanio(); i++) {
			c = ap.obtener(i);
			if (av.procedeCodigoProductos(c.getCodigoProducto()))
				cmbCodigoProducto.addItem("" + c.getCodigoProducto());
		}
	}

	String obtenerDatosCliente() {
		ArregloVenta av = new ArregloVenta();
		ArregloClientes ar = new ArregloClientes();
		ArregloProductos ap = new ArregloProductos();
		
		Venta v = av.buscar(leerCodigoVenta());
	    Cliente c = ar.buscar(leerCodigoCliente());
	    Producto p = ap.buscar(leerCodigoProducto());
	    
	    return "Cliente  :  " + c.getCodigoCliente() + "\n" +
	    	   "Nombres :  " + c.getNombres() + "\n" +
	    	   "Apellidos :  " + c.getApellidos() + "\n" + "\n" +
	    	   
	    	   "Producto :" + p.getCodigoProducto() + "\n" +
		       "Nombres :" + p.getNombre() + "\n" +
	    	   "Cantidad de unidades :" + v.getCantidad() + "\n" +
		       "Precio Unitario : " + p.getPrecio();
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void imprimir(String s) {
		txtArea.append(s + "\n");
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
	}
	
	void habilitarProceder(boolean sino) {
	}

	void habilitarBotones(boolean sino) {
		btnNuevo.setEnabled(sino);
		btnLimpiar.setEnabled(sino);
	}
	
	void deshabilitarDatos(boolean sino) {
		cmbCodigoCliente.setEnabled(false);
		cmbCodigoProducto.setEnabled(false);
		txtCantidad.setEditable(false);

	}
	
	void habilitarDatos(boolean sino) {
		cmbCodigoCliente.setEnabled(true);
		cmbCodigoProducto.setEnabled(true);
		txtCantidad.setEditable(true);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void visibleInvisible(boolean sino) {
		}
	

		
	//*************************************
	
	int leerCodigoVenta() {
		return Integer.parseInt(txtCodigoVenta.getText().trim());
	}
	
	int leerCodigoCliente() {
		return Integer.parseInt(cmbCodigoCliente.getSelectedItem().toString());
	}
	
	int leerCodigoProducto() {
		return Integer.parseInt(cmbCodigoProducto.getSelectedItem().toString());
	}
	
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText().trim());
	}
	
	double leerPrecio(int codigoProducto) {
		 Producto p = ap.buscar(codigoProducto);
		    return (p.getPrecio());		
	}
	
	String leerFecha(int codigoVenta) {
			Venta v = av.buscar(codigoVenta);
				return v.getFecha().trim();
	}
	
	
	public void restarStock() {
		try {
			int index = cmbCodigoProducto.getSelectedIndex();
			Producto x = ap.obtener(index);
			int cantidad = leerCantidad();
			if((cantidad <= x.getStockActual())) {
				x.setStockActual(x.getStockActual()-leerCantidad());
				mensaje("Venta ejecutada correctamente");
				ap.actualizarArchivo();
			}
			else
				mensaje("El Stock llego a su maxima capacidad");
			limpieza();
		} catch (Exception e2) {
			mensaje("Por favor Ingrese la cantidad");
		}
	}
	
	
	
	

	//*************************************	
	
	int confirmar(String s1, String s2) {
		return JOptionPane.showConfirmDialog(this, s1, s2, 0, 1, null);
	}
	
	String fechaActual() {
			int dd, mm, aa;
			Calendar c = new GregorianCalendar();
			dd = c.get(Calendar.DAY_OF_MONTH);
			mm = c.get(Calendar.MONTH) + 1;
			aa = c.get(Calendar.YEAR);
			return Fecha.ajustar(dd) + "/" + Fecha.ajustar(mm) + "/" + aa;
		}
		
	//*************************************

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) { 
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	boolean tryParseInt(String value) { 
		try { 
			Integer.parseInt(value); 
			return true;
		} catch(NumberFormatException nfe) { 
			return false; 
		}
	}
}
