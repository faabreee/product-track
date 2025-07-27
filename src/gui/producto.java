package gui;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloProductos;
import clases.Producto;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

public class producto extends JDialog implements ActionListener, KeyListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMinimo;
	public static JTextField txtStockMaximo;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblStockActual;
	private JLabel lblStockMinimo;
	private JLabel lblStockMaximo;
	private JScrollPane scrollPane;
	private JButton btnIngreso;
	private JButton btnModificacion;
	private JButton btnConsulta;
	private JButton btnEliminacion;
	private JButton btnListado;
	private JTable tbltable;
	private JScrollPane scrollPane_1;
	private DefaultTableModel modelo;
	private JTextArea txtArea;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					producto frame = new producto();
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
	public producto() {
		setResizable(false);
		setTitle("Producto");
		setBounds(100, 100, 686, 568);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("CODIGO :");
		lblCodigo.setBounds(10, 10, 115, 13);
		contentPane.add(lblCodigo);
		
		lblNombre = new JLabel("NOMBRE :");
		lblNombre.setBounds(10, 33, 115, 13);
		contentPane.add(lblNombre);
		
		lblPrecio = new JLabel("PRECIO :");
		lblPrecio.setBounds(10, 56, 115, 13);
		contentPane.add(lblPrecio);
		
		lblStockActual = new JLabel("STOCK ACTUAL :");
		lblStockActual.setBounds(10, 79, 115, 13);
		contentPane.add(lblStockActual);
		
		lblStockMinimo = new JLabel("STOCK MINIMO :");
		lblStockMinimo.setBounds(10, 102, 115, 13);
		contentPane.add(lblStockMinimo);
		
		lblStockMaximo = new JLabel("STOCK MAXIMO :");
		lblStockMaximo.setBounds(10, 125, 115, 13);
		contentPane.add(lblStockMaximo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtCodigo.setBounds(120, 7, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtNombre.setBounds(120, 30, 171, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtPrecio.setBounds(120, 53, 171, 19);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStockActual = new JTextField();
		txtStockActual.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtStockActual.setBounds(120, 76, 171, 19);
		contentPane.add(txtStockActual);
		txtStockActual.setColumns(10);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtStockMinimo.setBounds(120, 99, 171, 19);
		contentPane.add(txtStockMinimo);
		txtStockMinimo.setColumns(10);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		txtStockMaximo.setBounds(120, 122, 171, 19);
		contentPane.add(txtStockMaximo);
		txtStockMaximo.setColumns(10);
		
		btnIngreso = new JButton("INGRESO");
		btnIngreso.addActionListener(this);
		btnIngreso.setBounds(535, 6, 127, 21);
		contentPane.add(btnIngreso);
		
		btnModificacion = new JButton("MODIFICACION");
		btnModificacion.addActionListener(this);
		btnModificacion.setBounds(535, 29, 127, 21);
		contentPane.add(btnModificacion);
		
		btnConsulta = new JButton("CONSULTA");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(535, 52, 127, 21);
		contentPane.add(btnConsulta);
		
		btnEliminacion = new JButton("ELIMINACION");
		btnEliminacion.addActionListener(this);
		btnEliminacion.setBounds(535, 75, 127, 21);
		contentPane.add(btnEliminacion);
		
		btnListado = new JButton("LISTADO");
		btnListado.addActionListener(this);
		btnListado.setBounds(535, 98, 127, 21);
		contentPane.add(btnListado);
		
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
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(226, 6, 96, 21);
		contentPane.add(btnAceptar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("PRECIO");
		modelo.addColumn("STOCK ACTUAL");
		modelo.addColumn("STOCK MINIMO");
		modelo.addColumn("STOCK MAXIMO");
		
		tbltable.setModel(modelo);

		txtCodigo.setEditable(false);
		txtNombre.setEditable(false);
		txtPrecio.setEditable(false);
		txtStockActual.setEditable(false);
		txtStockMinimo.setEditable(false);
		txtStockMaximo.setEditable(false);
	
		ajustarAnchoColumnas();
		listar();
		editarFila();
		habilitarEntradas(false);
	}
		ArregloProductos ap = new ArregloProductos();
	
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
		if (ap.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen clientes");	
		}
		else {
			editarFila();
			int codigoProducto = leerCodigoProducto();
			ap.buscar(codigoProducto);
				txtNombre.setEditable(true);
				txtPrecio.setEditable(true);
				txtStockActual.setEditable(true);
				txtStockMinimo.setEditable(true);
				txtStockMaximo.setEditable(true);
				btnAceptar.setEnabled(true);
		}
	}
	public void actionPerformedbtnConsulta(ActionEvent e) {
		txtArea.setText("");
		Producto x=ap.buscar(leerCodigoProducto());
		if(x!=null) {
			limpiar();
			imprimir("Producto "+"\t"+": "+x.getCodigoProducto());
			imprimir(" Nombre "+"\t"+": " + x.getNombre());
			imprimir(" Precio "+"\t"+": " + x.getPrecio());
			imprimir(" Stock Actual "+"\t"+": " + x.getStockActual());
			imprimir(" Stock Minimo "+"\t"+": "+ x.getStockMinimo());
			imprimir(" Stock Maximo"+"\t"+": "+ x.getStockMaximo());
		}
		else
			mensaje(" El código ingresado NO existe ");
	}
	public void actionPerformedbtnEliminacion(ActionEvent e) {
		btnIngreso.setEnabled(true);
		btnModificacion.setEnabled(true);
		btnConsulta.setEnabled(true);
		btnListado.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (ap.tamanio() == 0)
			mensaje("No existen productos");
		else {
			editarFila();
			habilitarEntradas(false);
			int codigoProducto = leerCodigoProducto();
			ap.buscar(codigoProducto);
			int ok = confirmar(" Desea eliminar el producto ?");
			if (ok == 0) {
				ap.eliminar(ap.buscar(leerCodigoProducto()));
				listar();
				editarFila();
			}
		}
	}
	public void actionPerformedbtnListado(ActionEvent e) {
		txtArea.setText("");
		Producto p;
		for (int i=0; i<ap.tamanio(); i++) {
			p = ap.obtener(i);
				p = ap.buscar(p.getCodigoProducto());
				imprimir("Producto "+"\t" + ": " + p.getCodigoProducto());
				imprimir("Nombre "+"\t"+": " + p.getNombre());
				imprimir("Precio"+"\t"+": " + p.getPrecio());
				imprimir("Stock Actual"+"\t"+": " + p.getStockActual());
				imprimir("Stock Minimo "+"\t"+": " + p.getStockMinimo());
				imprimir("Stock Maximo "+"\t"+": " + p.getStockMaximo());
				imprimir("");
		}
	}
	public void actionPerformedbtnAceptar(ActionEvent e) {
		int codigoProducto = leerCodigoProducto();
		String nombre = leerNombreProducto();
		if(nombre.length() > 0) {
			double precio = leerPrecioProducto();
			if(precio> 0) {
				int stockActual = leerStockActualProducto();
				if(stockActual > 0) {
					int stockMinimo = leerStockMinimoProducto();
					if(stockMinimo > 0) {
						int stockMaximo = leerStockMaximoProducto();
						if(stockMaximo > 0) {
							if (btnIngreso.isEnabled() == false) {
								Producto nueva = new Producto(codigoProducto, nombre, precio, stockActual, stockMinimo, stockMaximo);
								ap.adicionar(nueva);
								btnIngreso.setEnabled(true);
							}
							if (btnModificacion.isEnabled() == false) {
								Producto x = ap.buscar(codigoProducto);
								x.setNombre(nombre);
								x.setPrecio(precio);
								x.setStockActual(stockActual);
								x.setStockMinimo(stockMinimo);
								x.setStockMaximo(stockMaximo);
								btnModificacion.setEnabled(true);
							}
							listar();
							ap.actualizarArchivo();
							habilitarEntradas(false);
							deshabilitarDatos(true);
						}
						else
							error("Ingrese STOCK MAXIMO correcto",txtStockMaximo);
					}
					else
						error("Ingrese STOCK MINMO correcto", txtStockMinimo);
				}
				else
					error("ingrese STOCK ACTUAL correcta", txtStockActual);
			}
			else
				error("ingrese PRECIO correctos", txtPrecio);
		}
		else
			error("ingrese CODIGO correctos", txtCodigo);
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
		tcm.getColumn(0).setPreferredWidth(anchoColumna(25));  // codigoProducto
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  // precio
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25));  // stock actual
		tcm.getColumn(4).setPreferredWidth(anchoColumna(25));  // stock minimo
		tcm.getColumn(5).setPreferredWidth(anchoColumna(25));  // stock maximo
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tbltable.getSelectedRow();
		if (modelo.getRowCount() == ap.tamanio() - 1)
			posFila = ap.tamanio() - 1;
		if (posFila == ap.tamanio())
			posFila --;
		modelo.setRowCount(0);
		Producto x;
		for (int i=0; i<ap.tamanio(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCodigoProducto(),
			          		  x.getNombre(),
			          		  "S/. "+x.getPrecio(),
			          		  x.getStockActual(),
			          		  x.getStockMinimo(),
			          		  x.getStockMaximo()};
			modelo.addRow(fila);
		}
		if (ap.tamanio() > 0)
			tbltable.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (ap.tamanio() == 0)
			limpieza();
		else {
			Producto x = ap.obtener(tbltable.getSelectedRow());
			txtCodigo.setText("" + (x.getCodigoProducto()));
			txtNombre.setText("" + (x.getNombre()));
			txtPrecio.setText("" + (x.getPrecio()));
			txtStockActual.setText("" + (x.getStockActual()));
			txtStockMinimo.setText("" + (x.getStockMinimo()));
			txtStockMaximo.setText("" + (x.getStockMaximo()));
		}	
	}
	
	void limpiar() {
		txtArea.setText(" ");
	}
	
	void limpieza() {
		txtCodigo.setText("" + ap.codigoCorrelativo());
		txtNombre.setText(" ");
		txtPrecio.setText(" ");
		txtStockActual.setText(" ");
		txtStockMinimo.setText(" ");
		txtStockMaximo.setText(" ");
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
		txtNombre.setEditable(false);
		txtPrecio.setEditable(false);
		txtStockActual.setEditable(false);
		txtStockMinimo.setEditable(false);
		txtStockMaximo.setEditable(false);
	}
	
	void habilitarDatos(boolean sino) {
		txtNombre.setEditable(true);
		txtPrecio.setEditable(true);
		txtStockActual.setEditable(true);
		txtStockMinimo.setEditable(true);
		txtStockMaximo.setEditable(true);
	}
	
	//*************************************
	
	int leerCodigoProducto() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	String leerNombreProducto() {
		return txtNombre.getText().trim();
	}
	
	double leerPrecioProducto() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	
	int leerStockActualProducto() {
		return Integer.parseInt(txtStockActual.getText().trim());
	}
	
	int leerStockMinimoProducto() {
		return Integer.parseInt(txtStockMinimo.getText().trim());
	}
	
	int leerStockMaximoProducto() {
		return Integer.parseInt(txtStockMaximo.getText().trim());
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
		// TODO Auto-generated method stub
		
	}
	
}
