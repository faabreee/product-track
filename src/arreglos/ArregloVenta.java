package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
import clases.Producto;
import clases.Venta;
import gui.producto;

public class ArregloVenta {
	
	private ArrayList <Venta> venta;
	
	public ArregloVenta() {
		venta = new ArrayList <Venta>();
		cargarVenta();
	}
	
	public void adicionar(Venta x) {
		venta.add(x);
		grabarVenta();
	}
	
	public int tamanio() {
		return venta.size();
	}
	
	public Venta obtener(int i) {
		return venta.get(i);
	}
	
	public Venta buscar(int codigoVenta) {
		for	(int i=0; i<tamanio(); i++)
			if (obtener(i).getCodigoVenta() == codigoVenta)
				return obtener(i);
		return null;
	}
	
	public void eliminar(Venta x) {
		venta.remove(x);
		grabarVenta();
	}
	
	public void actualizarArchivo() {
		grabarVenta();
	}
	
	private void grabarVenta() {
		try {
			PrintWriter pw;
			String linea;
			Venta x;
			pw = new PrintWriter(new FileWriter("ventas.txt"));
			for(int i=0; i<(tamanio()); i++) {
				x = obtener(i);
				linea = x.getCodigoVenta() + ";" +
						x.getCodigoCliente() + ";" +
						x.getCodigoProducto() + ";" +
						x.getCantidad() + ";" +
						x.getPrecio() + ";" +
						x.getFecha() ;
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	private void cargarVenta() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codigoVenta,codigoCliente,codigoProducto,cantidad;
			String fecha;
			double precio;
			br = new BufferedReader(new FileReader("ventas.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				codigoVenta = Integer.parseInt(s[0].trim());
				codigoCliente = Integer.parseInt(s[1].trim());
				codigoProducto = Integer.parseInt(s[2].trim());
				cantidad = Integer.parseInt(s[3].trim());
				precio = Double.parseDouble(s[4].trim());
				fecha = (s[5].trim());
				adicionar(new Venta(codigoVenta, codigoCliente, codigoProducto, cantidad, precio, fecha));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 3001;
		else
			return obtener(tamanio()-1).getCodigoVenta() + 1;
	}
	
	public boolean procedeCodigoClientes(int codigoCliente) {
		for (int i=tamanio()-1; i>=0; i--)
			if (obtener(i).getCodigoCliente() == codigoCliente  &&  obtener(i).getCantidad() == 0)
				return false;
		return true;
	}
	
	public boolean procedeCodigoProductos(int codigoProducto) {
		for (int i=tamanio()-1; i>=0; i--)
			if (obtener(i).getCodigoProducto() == codigoProducto  &&  obtener(i).getCantidad() == 0)
				return false;
		return true;
	}
	
	
	
	public int cantidadUnidades(Producto producto){
		try {
			int suma = 0;
	    	for (int i=0; i<tamanio(); i++) {
	    		Venta v = obtener(i);
	    		if(v.getCodigoProducto() == producto.getCodigoProducto())
	    			suma += v.getCantidad();
	    	}
	        	
		    return suma;			
		}catch(Exception e) {
			return 0;
		}
    }
	
	public int imoprteAcumulado(Producto producto){
		try {
			int suma = 0;
	    	for (int i=0; i<tamanio(); i++) {
	    		Venta v = obtener(i);
	    		if(v.getCodigoProducto() == producto.getCodigoProducto())
	    			suma += v.getCantidad()*v.getPrecio();
	    	}
	        	
		    return suma;			
		}catch(Exception e) {
			return 0;
		}
    }
	
	
	
	
	
	//*************

	public int posicion(int i) {return i;}

}
