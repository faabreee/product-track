package arreglos;

import clases.Producto;
import clases.Venta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloProductos {
	
	private ArrayList <Producto> producto;
	
	public ArregloProductos() {
		producto = new ArrayList <Producto> ();
		cargarProducto();
	}
	
	public void adicionar(Producto x) {
		producto.add(x);
		grabarProducto();
	}
	
	public int tamanio() {
		return producto.size();
	}
	
	public Producto obtener(int i) {
		return producto.get(i);
	}
	
	public Producto buscar(int codigoProducto) {
		for	(int i=0; i<tamanio(); i++)
			if (obtener(i).getCodigoProducto() == codigoProducto)
				return obtener(i);
		return null;
	}
	
	public void eliminar(Producto x) {
		producto.remove(x);
		grabarProducto();
	}
	
	public void actualizarArchivo() {
		grabarProducto();
	}
	
	
	private void grabarProducto() {
		try {
			PrintWriter pw;
			String linea;
			Producto x;
			pw = new PrintWriter(new FileWriter("productos.txt"));
			for(int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoProducto() + ";" +
						x.getNombre() + ";" +
						x.getPrecio() + ";" +
						x.getStockActual() + ";" +
						x.getStockMinimo() + ";" +
						x.getStockMaximo() ;
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	private void cargarProducto() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codigoProducto,stockActual,stockMinimo,stockMaximo;
			String nombre;
			double precio;
			br = new BufferedReader(new FileReader("productos.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				codigoProducto = Integer.parseInt(s[0].trim());
				nombre = (s[1].trim());
				precio = Double.parseDouble(s[2].trim());
				stockActual = Integer.parseInt(s[3].trim());
				stockMinimo = Integer.parseInt(s[4].trim());
				stockMaximo = Integer.parseInt(s[5].trim());
				adicionar(new Producto(codigoProducto, nombre, precio, stockActual, stockMinimo, stockMaximo));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 2001;
		else
			return obtener(tamanio()-1).getCodigoProducto() + 1;
	}
	
		
}
