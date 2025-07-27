package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnMantenimiento;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProducto;
	private JMenu mnVentas;
	private JMenuItem mntmVender;
	private JMenu mnAlmacen;
	private JMenuItem mntmStock;
	private JMenu mnReportes;
	private JMenuItem mntmListadogeneralventa;
	private JMenuItem mntmListadoproductostock;
	private JMenuItem mntmListadoproductounidadesacumunladas;
	private JMenuItem mntmListadoproductoimportetotal;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setResizable(false);
		setTitle("SISTEMA DE VENTAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(this);
		mnMantenimiento.add(mntmProducto);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mnAlmacen = new JMenu("Almacen");
		menuBar.add(mnAlmacen);
		
		mntmStock = new JMenuItem("Nuevo Stock");
		mntmStock.addActionListener(this);
		mnAlmacen.add(mntmStock);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mntmListadogeneralventa = new JMenuItem("Listado general de venta mostrado en cada caso");
		mntmListadogeneralventa.addActionListener(this);
		mnReportes.add(mntmListadogeneralventa);
		
		mntmListadoproductostock = new JMenuItem("Listado de productos cuyos stock se encuntra por debajo del stock minimo en cada caso");
		mntmListadoproductostock.addActionListener(this);
		mnReportes.add(mntmListadoproductostock);
		
		mntmListadoproductounidadesacumunladas = new JMenuItem("Listado de productos por unidades vendidas acumuladas mostrado por cada producto");
		mntmListadoproductounidadesacumunladas.addActionListener(this);
		mnReportes.add(mntmListadoproductounidadesacumunladas);
		
		mntmListadoproductoimportetotal = new JMenuItem("Listado de productos por importe total acumulado mostrado por cada producto");
		mntmListadoproductoimportetotal.addActionListener(this);
		mnReportes.add(mntmListadoproductoimportetotal);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmProducto) {
			actionPerformedmntmProducto(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedmntmClientes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedmntmBoleta(e);
		}
		if (e.getSource() == mntmStock) {
			actionPerformedmntmStock(e);
		}
		if (e.getSource() == mntmListadogeneralventa) {
			actionPerformedmntmListadogeneralventa(e);
		}
		if (e.getSource() == mntmListadoproductostock) {
			actionPerformedmntmListadoproductostock(e);
		}
		if (e.getSource() == mntmListadoproductounidadesacumunladas) {
			actionPerformedmntmListadoproductounidadesacumunladas(e);
		}
		if (e.getSource() == mntmListadoproductoimportetotal) {
			actionPerformedmntmListadoproductoimportetotal(e);
		}
	}
	
	public void actionPerformedmntmProducto(ActionEvent e) {
		producto p=new producto();
		p.setLocationRelativeTo(p);
		p.setVisible(true);
	}
	public void actionPerformedmntmClientes(ActionEvent e) {
		clientes c=new clientes();
		c.setLocationRelativeTo(c);
		c.setVisible(true);
	}
	public void actionPerformedmntmBoleta(ActionEvent e) {
		venta b=new venta();
		b.setLocationRelativeTo(b);
		b.setVisible(true);
	}
	public void actionPerformedmntmStock(ActionEvent e) {
		nuevostock s=new nuevostock();
		s.setLocationRelativeTo(s);
		s.setVisible(true);
	}
	public void actionPerformedmntmListadogeneralventa(ActionEvent e) {
		listadogeneral lg=new listadogeneral();
		lg.setLocationRelativeTo(lg);
		lg.setVisible(true);
	}
	public void actionPerformedmntmListadoproductostock(ActionEvent e) {
		listadoproductosstock ls=new listadoproductosstock();
		ls.setLocationRelativeTo(ls);
		ls.setVisible(true);
	}
	public void actionPerformedmntmListadoproductounidadesacumunladas(ActionEvent e) {
		listadoproductosacumuladas la=new listadoproductosacumuladas();
		la.setLocationRelativeTo(la);
		la.setVisible(true);
	}
	public void actionPerformedmntmListadoproductoimportetotal(ActionEvent e) {
		listadoproductosimportetotal lt=new listadoproductosimportetotal();
		lt.setLocationRelativeTo(lt);
		lt.setVisible(true);
	}
}
