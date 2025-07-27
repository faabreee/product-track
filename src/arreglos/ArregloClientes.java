package arreglos;

import clases.Cliente;
import clases.Producto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
public class ArregloClientes {
	
	private ArrayList <Cliente> cliente;
	
	public ArregloClientes() {
		cliente = new ArrayList <Cliente> ();
		cargarCliente();
	}
	
	public void adicionar(Cliente x) {
		cliente.add(x);
		grabarCliente();
	}
	
	public int tamanio() {
		return cliente.size();
	}
	
	public Cliente obtener(int i) {
		return cliente.get(i);
	}
	
	public Cliente buscar(int codigoCliente) {
		for	(int i=0; i<tamanio(); i++)
			if (obtener(i).getCodigoCliente() == codigoCliente)
				return obtener(i);
		return null;
	}
	
	public void eliminar(Cliente x) {
		cliente.remove(x);
		grabarCliente();
	}
	
	public void actualizarArchivo() {
		grabarCliente();
	}
	
	private void grabarCliente() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for(int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoCliente() + ";" +
						x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDireccion() + ";" +
						x.getTelefono() + ";" +
						x.getDni() ;
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	private void cargarCliente() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codigoCliente;
			String nombres,apellidos,direccion,telefono,dni;
			br = new BufferedReader(new FileReader("clientes.txt"));
			
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				codigoCliente = Integer.parseInt(s[0].trim());
				nombres = (s[1].trim());
				apellidos = (s[2].trim());
				direccion = (s[3].trim());
				telefono = (s[4].trim());
				dni = (s[5].trim());
				adicionar(new Cliente(codigoCliente, nombres, apellidos, direccion, telefono, dni));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio()-1).getCodigoCliente() + 1;
	}
}
