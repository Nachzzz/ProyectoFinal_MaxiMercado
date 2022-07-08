import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	private String correo;
	
	private String pass;

	private Conexion conn;
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Login() {
		
	}
	public Login(String correo, String pass) {
		super();
		this.correo = correo;
		this.pass = pass;
		this.conn=new Conexion();
	}
	
	public ResultSet Ingresar() throws SQLException {
		
		String sql="select * from Usuario where correo="+"'"+this.correo+"'"+" and pass="+"'"+this.pass+"'"+";";
		
		ResultSet r=this.conn.devolverConsulta(sql);
		
		return r;
		
	}
	
	
}
