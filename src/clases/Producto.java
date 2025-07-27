package clases;

public class Producto {
	private int codigoProducto,stockActual,stockMinimo,stockMaximo;
	private String nombre;
	private  double precio;
	
	public Producto(int codigoProducto, String nombre,double precio, int stockActual, int stockMinimo, int stockMaximo) {
		this.codigoProducto = codigoProducto;		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;		this.stockMaximo = stockMaximo;
		this.nombre = nombre;		this.precio = precio;
	}

	public int getCodigoProducto() {return codigoProducto;}
	public void setCodigoProducto(int codigoProducto) {this.codigoProducto = codigoProducto;}
	public int getStockActual() {return stockActual;}
	public void setStockActual(int stockActual) {this.stockActual = stockActual;}
	public int getStockMinimo() {return stockMinimo;}
	public void setStockMinimo(int stockMinimo) {this.stockMinimo = stockMinimo;}
	public int getStockMaximo() {return stockMaximo;}
	public void setStockMaximo(int stockMaximo) {this.stockMaximo = stockMaximo;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public double getPrecio() {return precio;}
	public void setPrecio(double precio) {this.precio = precio;}
	
	public int productomenorStockMin() {
		if(stockActual < stockMinimo)
		return codigoProducto;
		return codigoProducto;
	}
	
}
