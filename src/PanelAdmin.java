import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PanelAdmin {

	Scanner t=new Scanner(System.in);
	Conexion conn=new Conexion();
	private String[][] matrizResultado;
	int fila;
	int columna;
	public PanelAdmin(Usuario u) throws SQLException{
		
		System.out.println();
		System.out.println("\t\t==============================");
		System.out.println("\t\t===== Menu Administrador =====");
		System.out.println("");
		System.out.println("\t\t 1 - Ver listado productos");
		System.out.println("\t\t 2 - Cargar productos a la aplicacion");
		System.out.println("\t\t 3 - Modificar los datos de los productos cargados");
		System.out.println("\t\t 4 - Ver todos los usuarios que realizaron una compra");
		System.out.println("\t\t 5 - Ver listado de productos seleccionados por el usuario");
		
		int op=t.nextInt();
		switch(op) {
		
		case 1:
			VerProductos();
			break;
		case 2:
			addProducto();
			break;
		case 3:
			ModificarProducto();
			break;
		case 4:
			VerUsuariosCompras();
			break;
		}
	
	}
	
	
	public void VerUsuariosCompras() throws SQLException {
		String sql="select c.Nombre,u.Nombre as Usuario,e.Estado,c.fecha from Compras as c "
				+ "inner join Estado as e using(idEstado) "
				+ "inner join Usuario as u using(idUsuario);";
		
		ResultSet r=conn.devolverConsulta(sql);
		
		System.out.println("Nombre|\t Usuario\t Estado\t Fecha");
		while(r.next()) {
			System.out.print(r.getString("Nombre")+"\t");
			System.out.print(r.getString("Usuario")+"\t");
			System.out.print(r.getString("Estado")+"\t");
			System.out.print(r.getString("fecha")+"\t");
			System.out.print("\n");
		}
		
				
	}
	
	public void ModificarProducto() throws SQLException {
		
		
		String stock = null,precio = null;
		int decision;
		String sql;
		
		System.out.println("Productos");
		sql="select Nombre,CodigoBarras,Stock,idCategoria,Precio from Productos inner join Categorias using(idCategoria);";
		
		ResultSet r=conn.devolverConsulta(sql);
		System.out.println("Nombre|\t CodigoBarras|\t Stock|\t idCategoria| \tPrecio");
		while(r.next()) {
			
			System.out.print(r.getString("Nombre")+"\t");
			System.out.print(r.getString("CodigoBarras")+"\t");
			System.out.print(r.getString("Stock")+"\t");
			System.out.print(r.getString("idCategoria")+"\t");
			System.out.print(r.getString("Precio")+"\t");
			System.out.print("\n");
		}
		System.out.println("Ingrese el codigo del producto a modificar");
		String codigo=t.next();
		
		System.out.println("Desea modificar el stock 1-SI 0-NO");
		decision=t.nextInt();
		if(decision ==1) {
			System.out.println("Ingrese el nuevo stock");
			stock=t.next();
		}
		System.out.println("Desea modificar el precio 1-SI 0-NO");
		
		decision=t.nextInt();
		if(decision ==1) {
			System.out.println("Ingrese el nuevo precio");
			precio=t.next();
		}
		// tenga en cuenta que si no quiere modificar nada no tendria que hacer el update
		sql="UPDATE `maximercado2`.`Productos` SET `Stock` =" +"'"+stock+"'"+","+" `Precio` = "+"'"+precio+"'"+" WHERE (`CodigoBarras` = "+"'"+codigo+"');";
		conn.EjecutarConsulta(sql);
		System.out.println(" Producto Actualizado");
		
		Usuario u = null;
		PanelAdmin p = new PanelAdmin(u);
	}
	
	public void addProducto() throws SQLException {
		
		Conexion conn=new Conexion();
		System.out.println("Esta por agregar un producto");
		System.out.println();
		System.out.println("Ingrese el nombre del producto");
		String n=t.next();
		System.out.println("Ingrese el codigo de barras");
		String c=t.next();
		System.out.println("Ingrese el Stock");
		String s=t.next();
		System.out.println("Ingrese la categoria :");
		ResultSet r= conn.devolverConsulta("select * from Categorias;");
		while(r.next()) {
			System.out.println(r.getInt("idCategoria")+": "+r.getString("categoria"));
		}
		
		String cat=t.next();
		System.out.println("Ingrese el precio");
		
		String d=t.next();
		
		ArrayList<String >e=new ArrayList<>();
		e.add(n);
		e.add(c);
		e.add(s);
		e.add(cat);
		e.add(d);
		
		conn.AgregarProducto(e);
		System.out.println("Producto agregado con exito!");
		
		
		Usuario u = null;
		PanelAdmin p = new PanelAdmin(u );
	}
	
	
	
	public void VerProductos() throws SQLException {
		
		String sql="select * from Productos;";
		ResultSet r=conn.devolverConsulta(sql);
		
		r.last();//se posiciona en la ultima
		
		fila=r.getRow()+1;
		columna=6;
		this.matrizResultado=new String[fila][columna];
		
		this.matrizResultado[0][0]="idProducto";
		this.matrizResultado[0][1]="Nombre";
		this.matrizResultado[0][2]="Codigo";
		this.matrizResultado[0][3]="Stock";
		this.matrizResultado[0][4]="categoria";
		this.matrizResultado[0][5]="Precio";
		
		r.beforeFirst();
		//int fila=1;
		System.out.println("\t============= PRODUCTOS ============== ");
		System.out.println("\t~~idProducto - Nombre - CodigoProducto - Stock - Precio~~");
		System.out.println("\t====================================== ");
		
		while(r.next()) {
			
		System.out.println("\t" + r.getInt("idProducto")+ " - " +r.getString("Nombre")+ " - " + r.getString("codigoBarras") + " - " + r.getString("Stock")+" - "+ "$" +r.getString("Precio"));
		
			/*this.matrizResultado[fila][0]=""+r.getInt("idProducto");
			this.matrizResultado[fila][1]=r.getString("Nombre");
			this.matrizResultado[fila][2]=r.getString("CodigoBarras");
			this.matrizResultado[fila][3]=r.getString("Stock");
			this.matrizResultado[fila][4]=r.getString("idcategoria");
			this.matrizResultado[fila][5]="$"+r.getString("Precio");
			fila++;*/
			
		}
		
		System.out.println();
		System.out.println();
		
		Usuario u = null;
		PanelAdmin p = new PanelAdmin(u );
		//this.Mostrar_matriz(matrizResultado, this.fila, columna);
	
	
	}
	
	public void Mostrar_matriz(String[][] m, int f, int c) {
		
		for(int i=0;i<f;i++) {
			System.out.print("\n");
			for(int j=0;j<c;j++) {
				System.out.print("\t"+m[i][j]);
			}
		}
		
		
	}
	
}
