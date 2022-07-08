
public class Usuario {


	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private String correo;
	private String pass;
	private int Esfrecuente;
	private int idRol;
	private int idDomicilio;
	
	public Usuario() {
		
	}
	public Usuario(int id, String nombre, String apellido, String dni, String correo, String pass, int esfrecuente,
			int idRol, int idDomicilio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.pass = pass;
		Esfrecuente = esfrecuente;
		this.idRol = idRol;
		this.idDomicilio = idDomicilio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
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
	public int getEsfrecuente() {
		return Esfrecuente;
	}
	public void setEsfrecuente(int esfrecuente) {
		Esfrecuente = esfrecuente;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
}
