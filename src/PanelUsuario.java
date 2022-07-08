import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PanelUsuario {

	Scanner t=new Scanner(System.in);
	Conexion conn=new Conexion();
	//private String[][] matrizResultado;
	int fila;
	int columna;
	private Usuario u;
	public PanelUsuario(Usuario u) throws SQLException{
		
		this.u=u;
		System.out.println();
		System.out.println("\t\t=========================");
		System.out.println("\t\t===== Menu Usuario ======");
		System.out.println("\t 1 - Seleccionar productos");
		System.out.println("\t 2 - Ver listado de productos seleccionados");
		System.out.println("\t 3 - Autorizar compra");
		
		
		int op=t.nextInt();
		switch(op) {
		
		case 1:
			
			this.seleccionarProductos();
			break;
		}
	}
	
	public void seleccionarProductos() throws SQLException {
		
		//ResultSet r=conn.devolverConsulta("select count(*) from ProductosSeleccionados where idCarrito=(select idUsuario from Carrito where idUsuario="+u.getId()+");");
		//int cant= r.getInt("count");
		int b=1;
		
		System.out.print("Seleccione los productos que desea agregar al carrito");
		
		//deberia mostrar de nuevo los productos cada vez que el usuario eliga un producto para controlar el stock
		do {
			ResultSet r = conn.devolverConsulta("select idProducto, nombre, precio from Producto where stock>0;");
			String sql;
			//String sql="select idProducto,Nombre,Precio from Producto where Stock>0;";
			r=conn.devolverConsulta(sql);
			System.out.print("idProducto|\t Nombre|\t Precio|\t");
			while(r.next()){
				System.out.print(r.getInt("idProducto"));
				System.out.print(r.getString("Nombre"));
				System.out.print(r.getString("Precio"));
				System.out.print("\n");
			}
			
			
			System.out.println("Ingrese el id del producto que quiere agregar al carrito");
			int id=t.nextInt();
			
			
			String sql1="insert into ProductosSeleccionados values(null,(select idCarrito from Carrito where idUsuario="+u.getId()+"),"+id+");";
			conn.EjecutarConsulta(sql1);
			
			System.out.println("Producto seleccionado!!!!");
			System.out.println("Desea agregar otro producto 1-SI 0-NO");
			b=t.nextInt();
			
			//r=conn.devolverConsulta("select count(*) from ProductosSeleccionados where idCarrito=(select idCarrito from Carrito where idUsuario="+u.getId()+");");
			//cant= r.getInt("count");
		
		//while(cant<=30 && b==1);
	}

	
	public void VerProductosSeleccionados() {
		
		
	}
}
