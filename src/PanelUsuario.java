import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		System.out.println("\t=========================");
		System.out.println("\t===== Menu Usuario ======");
		System.out.println("\t 1 - Seleccionar productos");
		System.out.println("\t 2 - Ver Carrito");
		System.out.println("\t 3 - Autorizar compra");
		
		
		int op=t.nextInt();
		switch(op) {
		
		case 1:
			
			this.seleccionarProductos();
			break;
			
		case 2:
			this.VerCarrito();
			break;
		case 3:
			this.FinalizarCompra();
			break;
		}
	}
	
	public void seleccionarProductos() throws SQLException {		
		//=====================================================================================
		int b = 1;
	do {
		String sql = "SELECT * FROM PRODUCTOS";
		ResultSet r = conn.devolverConsulta(sql);
		
		System.out.println("\t============= PRODUCTOS ============== ");
		System.out.println("\t~~idProducto - Nombre - CodigoProducto - Stock - Precio~~");
		System.out.println("\t====================================== ");
		
		while (r.next()) {
			System.out.println("\t" + r.getInt("idProducto")+ " - " +r.getString("Nombre")+ " - " 
								+ r.getString("codigoBarras") + " - " + r.getString("Stock")+" - "+ "$" +r.getString("Precio"));
		}
		
		//Conexion conn=new Conexion();
		System.out.println("Esta por agregar un producto");
		System.out.println();
		System.out.println("Ingrese el ID del producto");
		String n=t.next();
		System.out.println("Ingrese el nombre del producto");
		String c=t.next();
		System.out.println("Ingrese el precio");
		String s=t.next();

		ArrayList<String >e=new ArrayList<>();
		e.add(n);
		e.add(c);
		e.add(s);
		
		conn.ProductoCarrito(e);
		System.out.println("Producto agregado con exito!");
		System.out.println();
		System.out.println("Desea agregar otro producto 1-SI 0-NO");
		b=t.nextInt();
		}while (b==1);
		
		Usuario u = null;
		PanelUsuario p = new PanelUsuario(u);
	}
		
		/*String sql = "SELECT * FROM PRODUCTOS";
		ResultSet r = conn.devolverConsulta(sql);
		
		System.out.println("\t============= PRODUCTOS ============== ");
		System.out.println("\t~~idProducto - Nombre - CodigoProducto - Stock - Precio~~");
		System.out.println("\t====================================== ");
		
		while (r.next()) {
			
			
			System.out.println("\t" + r.getInt("idProducto")+ " - " +r.getString("Nombre")+ " - " 
								+ r.getString("codigoBarras") + " - " + r.getString("Stock")+" - "+ "$" +r.getString("Precio"));
		}
		
		System.out.println("Seleccione el ID del producto a agregar");
		int id = t.nextInt();		
		do {
			String sql2 = "insert into carrito(idCarrito) values ('select from productos where idProducto = "+id+"')";
			conn.ProductoCarrito(sql2);
			
		} while (id == 0);*/
		
			
		
		//==========================================================================================================

		
		/*ResultSet r=conn.devolverConsulta("select count(*) from ProductosSeleccionados where idCarrito=(select idUsuario from Carrito where idUsuario="+u.getId()+");");
		int cant= r.getInt("count");
		int b=1;
		
		System.out.print("Seleccione los productos que desea agregar al carrito");
		
		int cant1;
		int cant11;
		int cant111;
		do {
			ResultSet r1 = conn.devolverConsulta("select idProducto, nombre, precio from Producto where stock>0;");
			String sql;
			String sql2="select idProducto,Nombre,Precio from Producto where Stock>0;";
			r1=conn.devolverConsulta(sql2);
			System.out.print("idProducto|\t Nombre|\t Precio|\t");
			while(r1.next()){
				System.out.print(r1.getInt("idProducto"));
				System.out.print(r1.getString("Nombre"));
				System.out.print(r1.getString("Precio"));
				System.out.print("\n");
			}
			
			
			System.out.println("Ingrese el id del producto que quiere agregar al carrito");
			int id=t.nextInt();
			
			
			String sql1="insert into ProductosSeleccionados values(null,(select idCarrito from Carrito where idUsuario="+u.getId()+"),"+id+");";
			conn.EjecutarConsulta(sql1);
			
			System.out.println("Producto seleccionado!!!!");
			System.out.println("Desea agregar otro producto 1-SI 0-NO");
			b=t.nextInt();
			
			r1=conn.devolverConsulta("select count(*) from ProductosSeleccionados where idCarrito=(select idCarrito from Carrito where idUsuario="+u.getId()+");");
			int cant2 = r1.getInt("count");
		
		
		}while(cant<=30 && b==1);*/
		
		
	public void VerCarrito() throws SQLException{
		String sql3 = "select * from carrito";
		ResultSet r = conn.devolverConsulta(sql3);
		
		System.out.println();
		System.out.println("\t============= CARRITO ============== ");
		System.out.println("\t~~idProducto - Nombre - Precio~~");
		System.out.println();
		
		while (r.next()) {
			System.out.println("\t"+r.getInt("idCarrito")+"\t"+ " - "+r.getString("Nombre")+"\t"+ " - "+"$"+r.getInt("Precio"));
		}
		Usuario u = null;
		PanelUsuario p = new PanelUsuario(u);
	}
	
	public void FinalizarCompra() {
		System.out.println();
		System.out.println("\t********GRACIAS POR SU COMPRA!************");
	}
}

