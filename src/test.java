import java.io.IOException;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class test {

	
	static Scanner t = new Scanner(System.in);
	static Conexion connn = new Conexion();
	public static void main(String[] args) throws SQLException, InterruptedException, IOException {
		
		
		System.out.println();
		System.out.println();
		System.out.println("\t\t============================================");
		System.out.println("\t\t======== BIENVENIDO A MAXIMERCADO! =========");
		System.out.println("\t\t============================================");
		System.out.println();
		System.out.println("\t\t\t~~~~~~~~ MENU PRINCIPAL ~~~~~~~~");
		System.out.println("\t\t\t~~~~ 1 - INGRESAR ");
		//System.out.println("\t----2 REGISTRARSE---");
		
		
		int opElegida=t.nextInt();

		switch(opElegida) {
		
		case 1:
			System.out.println("\t\t~~~ Ingrese correo electronico ~~~");
			String correo= t.next();
			System.out.println("\t\t~~~ Ingrese su clave");
			String pass=t.next();
			
			Ingresar(correo,pass);
			System.out.print(""); 
			break;
		
		default:


			System.out.println("BIENVENIDO REGISTRO. COMPLETE CON SUS DATOS");
			System.out.println("INGRESE SU NOMBRE COMPLETO");
			String n=t.next();
			System.out.println("INGRESE SU APELLIDO");
			String ap=t.next();
			System.out.println("INGRESE SU DNI");
			String d=t.next();
			System.out.println("INGRESE SU CORREO");
			String c=t.next();
			System.out.println("INGRESE SU CONTRASEÑA");
			String pas=t.next();
			System.out.println("REPITA SU CONTRASEÑA");
			String pass2=t.next();
			ArrayList<String > listaadd=new ArrayList<String>();
			
			if(pas.equals(pass2) && n.isEmpty()==false) {
				//insert into Usuario values(null,"facund0","lopez","554","facu@gmail","1234",false,"2","1");
				listaadd.add(n);
				listaadd.add(ap);
				listaadd.add(d);
				listaadd.add(c);
				listaadd.add(pas);
				listaadd.add("0");
				listaadd.add("2");
				listaadd.add("1");	
				connn.AgregarUsuario(listaadd);
			
				ResultSet r=connn.devolverConsulta("select idUsuario from Usuario where correo="+"'"+c+"'"+";");
				if(r.next()) {
					
					connn.EjecutarConsulta("insert into Carrito values (null,"+r.getInt("idUsuario")+");");
					
				}
				
			}else {
				System.out.print("Contraseñas incorrectas");
			}
			
			
			break;
		}
		

	}
	
	public static void Ingresar( String c,String pass) throws SQLException {
		
		
		Login login = new Login(c,pass);
		ResultSet r = login.Ingresar();
		if (r.next()) {

			if (r.getInt("idRol") == 1) {
				System.out.println();
				System.out.println("Bienvenido Administrador");
				Usuario u = new Usuario(r.getInt("idUsuario"), r.getString("Nombre"), r.getString("Apellido"),
						r.getString("dni"), r.getString("correo"),r.getString("pass"), r.getInt("EsFrecuente"),
						r.getInt("idRol"), r.getInt("idDomicilio"));
				
				PanelAdmin p = new PanelAdmin(u);
				

			} else {
				System.out.println();
				System.out.print("Bienvenido cliente" + " " + r.getString("Nombre") + " " + r.getString("Apellido"));
				System.out.println();
				Usuario u = new Usuario(r.getInt("idUsuario"), r.getString("Nombre"), r.getString("Apellido"),
						r.getString("dni"), r.getNString("correo"), r.getString("pass"), r.getInt("EsFrecuente"),
						r.getInt("idRol"), r.getInt("idDomicilio"));
				PanelUsuario p = new PanelUsuario(u);
			}
		} else {
			System.out.println("Usuario o contraseña incorrecto");
		}
	}
}



