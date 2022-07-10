import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {

	
	public Connection conn;
	public Statement stmt;
	
	public Conexion() {
		 final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
		 final String DB_URL="jdbc:mysql://localhost:3306/maximercado2";
		 
		 info f=new info();
		 final String USER= f.getUser();//usuario
		 final String PASS=f.getPass();//pass
		 
		 	conn=null;
			stmt =null;
			try {
				//paso 2
				Class.forName(JDBC_DRIVER);
				
				//paso3 
				System.out.println("Conectando a la base de Datos...");
				conn= DriverManager.getConnection(DB_URL,USER,PASS);
				System.out.println("Conexion exitosa!");
				
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			//System.out.print("LIsto");
		}

		public ResultSet devolverConsulta(String query) throws SQLException {
			//System.out.println("creando declaracion");
			stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			sql=query;
			
			ResultSet rs =stmt.executeQuery(sql);
			 return rs;
		}
		
		
		public void EjecutarConsulta(String sql) throws SQLException {
			stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(sql);
		}
		
		public void AgregarUsuario(ArrayList<String> elementos) throws SQLException {
			System.out.println("Creando Statement");
			stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			sql="insert into Usuario (Nombre,Apellido,dni,correo,pass,idRol) "+
			" values (?,?,?,?,?,?)";
			
			  PreparedStatement preparedStmt = conn.prepareStatement(sql);
		    
		      preparedStmt.setString (1,elementos.get(0) );
		      preparedStmt.setString (2,elementos.get(1) );
		      preparedStmt.setString (3,elementos.get(2) );
		      preparedStmt.setString (4,elementos.get(3) );
		      preparedStmt.setString (5,elementos.get(4) );
		      preparedStmt.setString (6,elementos.get(5) );
		      preparedStmt.setInt (7,Integer.parseInt(elementos.get(6)) );
		      preparedStmt.setInt (8,Integer.parseInt(elementos.get(7)));
		      
		      preparedStmt.execute();
		      
		}
		public void AgregarProducto(ArrayList<String>elementos) throws SQLException {
			System.out.println("Creando Statement");
			stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			sql="insert into Productos (Nombre,CodigoBarras,Stock,idCategoria,Precio) "+
			" values (?,?,?,?,?)";
			
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
			    
		      preparedStmt.setString (1,elementos.get(0) );
		      preparedStmt.setString (2,elementos.get(1) );
		      preparedStmt.setString (3,elementos.get(2) );
		      preparedStmt.setInt (4,Integer.parseInt(elementos.get(3) ));
		      preparedStmt.setString (5,elementos.get(4) );

		      
		      preparedStmt.execute();
		      
		}
		
		public void ProductoCarrito(ArrayList<String>elementos) throws SQLException {
			//System.out.println("Creando Statement");
			stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			sql="insert into carrito (idCarrito, nombre, precio) "+
			" values (?,?,?)";
			
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
			    
			  preparedStmt.setInt (1,Integer.parseInt(elementos.get(0) ));
		      preparedStmt.setString (2,elementos.get(1) );
		      preparedStmt.setInt (3,Integer.parseInt(elementos.get(2) ));
		      
		      
		      preparedStmt.execute();
		      
		}
		

	public static void main(String[] args) {

	}
}