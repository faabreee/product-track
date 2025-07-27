package gui;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloClientes;
import clases.Cliente;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class clientes extends JDialog implements ActionListener, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JButton btnIngreso;
	private JButton btnModificacion;
	private JButton btnConsulta;
	private JButton btnEliminacion;
	private JButton btnListado;
	private JScrollPane scrollPane;
	private JTable tbltable;
	private JScrollPane scrollPane_1;
	private JTextArea txtArea;
	private DefaultTableModel modelo;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientes frame = new clientes();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	public clientes() {
		setResizable(false);
		setTitle("Clientes");
		setBounds(100, 100, 686, 568);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("CODIGO :");
		lblCodigo.setBounds(10, 10, 82, 13);
		contentPane.add(lblCodigo);
		
		lblNombres = new JLabel("NOMBRES :");
		lblNombres.setBounds(10, 33, 82, 13);
		contentPane.add(lblNombres);
		
		lblApellidos = new JLabel("APELLIDOS :");
		lblApellidos.setBounds(10, 56, 82, 13);
		contentPane.add(lblApellidos);
		
		lblDireccion = new JLabel("DIRECCION :");
		lblDireccion.setBounds(10, 79, 82, 13);
		contentPane.add(lblDireccion);
		
		lblTelefono = new JLabel("TELEFONO :");
		lblTelefono.setBounds(10, 102, 82, 13);
		contentPane.add(lblTelefono);
		
		lblDni = new JLabel("DNI :");
		lblDni.setBounds(10, 125, 82, 13);
		contentPane.add(lblDni);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtCodigo.setBounds(102, 7, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtNombres.setBounds(102, 30, 171, 19);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtApellidos.setBounds(102, 53, 171, 19);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtDireccion.setBounds(102, 76, 171, 19);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtTelefono.setBounds(102, 99, 171, 19);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtDni.setBounds(102, 122, 171, 19);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		btnIngreso = new JButton("INGRESO");
		btnIngreso.addActionListener(this);
		btnIngreso.setBounds(533, 6, 127, 21);
		contentPane.add(btnIngreso);
		
		btnModificacion = new JButton("MODIFICACION");
		btnModificacion.addActionListener(this);
		btnModificacion.setBounds(533, 29, 127, 21);
		contentPane.add(btnModificacion);
		
		btnConsulta = new JButton("CONSULTA");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(533, 52, 127, 21);
		contentPane.add(btnConsulta);
		
		btnEliminacion = new JButton("ELIMINACION");
		btnEliminacion.addActionListener(this);
		btnEliminacion.setBounds(533, 75, 127, 21);
		contentPane.add(btnEliminacion);
		
		btnListado = new JButton("LISTADO");
		btnListado.addActionListener(this);
		btnListado.setBounds(533, 98, 127, 21);
		contentPane.add(btnListado);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(208, 6, 106, 21);
		contentPane.add(btnAceptar);
		
			scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 650, 220);
		contentPane.add(scrollPane);
		
		tbltable = new JTable();
		tbltable.addMouseListener(this);
		tbltable.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		tbltable.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbltable);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 380, 650, 138);
		contentPane.add(scrollPane_1);
		
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
		scrollPane_1.setViewportView(txtArea);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		
		tbltable.setModel(modelo);

		txtCodigo.setEditable(false);
		txtNombres.setEditable(false);
		txtApellidos.setEditable(false);
		txtDireccion.setEditable(false);
		txtTelefono.setEditable(false);
		txtDni.setEditable(false);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		habilitarEntradas(false);
	}
		ArregloClientes ar = new ArregloClientes();
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnIngreso) {
			actionPerformedbtnIngreso(e);
		}
		if(e.getSource() == btnModificacion) {
			actionPerformedbtnModificacion(e);
		}
		if(e.getSource() == btnConsulta) {
			actionPerformedbtnConsulta(e);
		}
		if(e.getSource() == btnEliminacion) {
			actionPerformedbtnEliminacion(e);
		}
		if(e.getSource() == btnListado) {
			actionPerformedbtnListado(e);
		}
		if(e.getSource() == btnAceptar) {
			actionPerformedbtnAceptar(e);
		}
	}
	
	public void actionPerformedbtnIngreso(ActionEvent e) {
		btnIngreso.setEnabled(false);
		btnModificacion.setEnabled(true);
		btnConsulta.setEnabled(true);
		btnEliminacion.setEnabled(true);
		btnListado.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		habilitarEntradas(true);
		habilitarDatos(true);
	}
	public void actionPerformedbtnModificacion(ActionEvent e) {
		btnIngreso.setEnabled(true);
		btnModificacion.setEnabled(false);
		btnConsulta.setEnabled(true);
		btnEliminacion.setEnabled(true);
		btnListado.setEnabled(true);
		if (ar.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen clientes");	
		}
		else {
			editarFila();
			int numeroCliente = leerCodigoCliente();
			ar.buscar(numeroCliente);
				txtNombres.setEditable(true);
				txtApellidos.setEditable(true);
				txtDireccion.setEditable(true);
				txtTelefono.setEditable(true);
				txtDni.setEditable(true);
				btnAceptar.setEnabled(true);
		}
	}
	public void actionPerformedbtnConsulta(ActionEvent e) {
		txtArea.setText("");
		Cliente x=ar.buscar(leerCodigoCliente());
		if(x!=null) {
			limpiar();
			imprimir("Cliente "+"\t"+": "+x.getCodigoCliente());
			imprimir(" Nombres "+"\t"+": " + x.getNombres());
			imprimir(" Apellidos "+"\t"+": " + x.getApellidos());
			imprimir(" Direccion "+"\t"+": " + x.getDireccion());
			imprimir(" Telefono "+"\t"+": "+ x.getTelefono());
			imprimir(" DNI"+"\t"+": "+ x.getDni());
		}
		else
			mensaje(" El codigo ingresado NO existe ");
}
	public void actionPerformedbtnEliminacion(ActionEvent e) {
		btnIngreso.setEnabled(true);
		btnModificacion.setEnabled(true);
		btnConsulta.setEnabled(true);
		btnListado.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (ar.tamanio() == 0)
			mensaje("No existen camas");
		else {
			editarFila();
			habilitarEntradas(false);
			int codigoCliente = leerCodigoCliente();
			ar.buscar(codigoCliente);
			int ok = confirmar(" Desea eliminar el cliente ?");
			if (ok == 0) {
				ar.eliminar(ar.buscar(leerCodigoCliente()));
				listar();
				editarFila();
			}
		}
	}
	public void actionPerformedbtnListado(ActionEvent e) {
		txtArea.setText("");
		Cliente c;
		for (int i=0; i<ar.tamanio(); i++) {
			c = ar.obtener(i);
				c = ar.buscar(c.getCodigoCliente());
				imprimir(" Cliente "+"\t" + ": " + c.getCodigoCliente());
				imprimir(" Nombres "+"\t"+": " + c.getNombres());
				imprimir(" Apellidos"+"\t"+": " + c.getApellidos());
				imprimir(" Direccion"+"\t"+": " + c.getDireccion());
				imprimir(" Telefono "+"\t"+": " + c.getTelefono());
				imprimir(" Dni "+"\t"+": " + c.getDni());
				imprimir("--------------------------------------");
		}
	
	}
	public void actionPerformedbtnAceptar(ActionEvent e) {
		int codigoCliente = leerCodigoCliente();
		String nombres = leerNombreCliente();
		if(nombres.length() > 0) {
			String apellidos = leerApellidoCliente();
			if(apellidos.length() > 0) {
				String direccion = leerDireccionCliente();
				if(direccion.length() > 0) {
					String telefono = leerTelefonoCliente();
					if(telefono.length() > 0) {
						String dni = leerDniCliente();
						if(dni.length() > 0) {
							if (btnIngreso.isEnabled() == false) {
								Cliente nueva = new Cliente(codigoCliente, nombres, apellidos, direccion, telefono, dni);
								ar.adicionar(nueva);
								btnIngreso.setEnabled(true);
							}
							if (btnModificacion.isEnabled() == false) {
								Cliente x = ar.buscar(codigoCliente);
								x.setNombres(nombres);
								x.setApellidos(apellidos);
								x.setDireccion(direccion);
								x.setTelefono(telefono);
								x.setDni(dni);
								btnModificacion.setEnabled(true);
							}
							listar();
							habilitarEntradas(false);
							deshabilitarDatos(true);
						}
						else
							error("Ingrese un DNI correcto",txtDni);
					}
					else
						error("Ingrese un TELEFONO correcto", txtTelefono);
				}
				else
					error("ingrese una DIRECCION correcta", txtDireccion);
			}
			else
				error("ingrese un APELLIDO correcto", txtApellidos);
		}
		else
			error("ingrese un NOMBRE correcto", txtNombres);
	}
	
	//*************
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tbltable) {
			mouseClickedtbltable(arg0);
			deshabilitarDatos(true);
		}
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
		if (arg0.getSource() == btnIngreso) {
			mouseEnteredbtnIngreso(arg0);
		}
		if (arg0.getSource() == btnModificacion) {
			mouseEnteredbtnModificacion(arg0);
		}
		if (arg0.getSource() == btnConsulta) {
			mouseEnteredbtnConsulta(arg0);
		}
		if (arg0.getSource() == btnEliminacion) {
			mouseEnteredbtnEliminacion(arg0);
		}
		if (arg0.getSource() == btnListado) {
			mouseEnteredbtnListado(arg0);
		}
		if (arg0.getSource() == tbltable) {
			mouseEnteredtbltable(arg0);
		}		
	}
	public void mouseEnteredbtnAceptar(MouseEvent arg0) {
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseEnteredbtnIngreso(MouseEvent arg0) {
		btnIngreso.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseEnteredbtnConsulta(MouseEvent arg0) {
		btnConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseEnteredbtnModificacion(MouseEvent arg0) {
		btnModificacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseEnteredbtnEliminacion(MouseEvent arg0) {
		btnEliminacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseEnteredbtnListado(MouseEvent arg0) {
		btnListado.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseEnteredtbltable(MouseEvent arg0) {
		tbltable.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	//*************************************

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbltable.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(25));  // codigoCliente
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25));  // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  // apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25));  // direccion
		tcm.getColumn(4).setPreferredWidth(anchoColumna(25));  // telefono
		tcm.getColumn(5).setPreferredWidth(anchoColumna(25));  // dni
	}
	
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tbltable.getSelectedRow();
		if (modelo.getRowCount() == ar.tamanio() - 1)
			posFila = ar.tamanio() - 1;
		if (posFila == ar.tamanio())
			posFila --;
		modelo.setRowCount(0);
		Cliente x;
		for (int i=0; i<ar.tamanio(); i++) {
			x = ar.obtener(i);
			Object[] fila = { x.getCodigoCliente(),
			          		  x.getNombres(),
			          		  x.getApellidos(),
			          		  x.getDireccion(),
			          		  x.getTelefono(),
			          		  x.getDni()};
			modelo.addRow(fila);
		}
		if (ar.tamanio() > 0)
			tbltable.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (ar.tamanio() == 0)
			limpieza();
		else {
			Cliente x = ar.obtener(tbltable.getSelectedRow());
			txtCodigo.setText("" + (x.getCodigoCliente()));
			txtNombres.setText("" + (x.getNombres()));
			txtApellidos.setText("" + (x.getApellidos()));
			txtDireccion.setText("" + (x.getDireccion()));
			txtTelefono.setText("" + (x.getTelefono()));
			txtDni.setText("" + (x.getDni()));
		}	
	}
	
	void limpiar() {
		txtArea.setText(" ");
	}
	
	void limpieza() {
		txtCodigo.setText("" + ar.codigoCorrelativo());
		txtNombres.setText(" ");
		txtApellidos.setText(" ");
		txtDireccion.setText(" ");
		txtTelefono.setText(" ");
		txtDni.setText(" ");
	}
	
	//*************************************

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informacion", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
	}
	
	void habilitarBotones(boolean sino) {
		btnIngreso.setEnabled(sino);
		btnModificacion.setEnabled(sino);
	}
	
	void deshabilitarDatos(boolean sino) {
		txtNombres.setEditable(false);
		txtApellidos.setEditable(false);
		txtDireccion.setEditable(false);
		txtTelefono.setEditable(false);
		txtDni.setEditable(false);
	}
	void habilitarDatos(boolean sino) {
		txtNombres.setEditable(true);
		txtApellidos.setEditable(true);
		txtDireccion.setEditable(true);
		txtTelefono.setEditable(true);
		txtDni.setEditable(true);
	}
	
	
	//*************************************
	
	int leerCodigoCliente() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	String leerNombreCliente() {
		return txtNombres.getText().trim();
	}
	
	String leerApellidoCliente() {
		return txtApellidos.getText().trim();
	}
	
	String leerDireccionCliente() {
		return txtDireccion.getText().trim();
	}
	
	String leerTelefonoCliente() {
		return txtTelefono.getText().trim();
	}
	
	String leerDniCliente() {
		return txtDni.getText().trim();
	}
	
	//*************************************
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	//*************************************
	void imprimir() {
		imprimir("");
	}
	
	void imprimir(String s) {
		txtArea.append(s + "\n");
	}
	
	//************************************************************

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
		// TODO Auto-generated method stub*
		
	}
	
}
