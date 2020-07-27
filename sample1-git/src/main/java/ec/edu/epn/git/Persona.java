package ec.edu.epn.git;
//Clase persona
public class Persona {
	
	private String usuario;
	private String contrasenia;
	//Constructor
	public Persona(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	//constructor vacío
	public Persona() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	//metodo para validar el nombre de usuario
	public boolean VerificarUsuario(String usuario) {
		if(usuario.compareTo(getUsuario())==0)
			return true;
	return false;		
	}
	
	//metodo para validar la contraseña del usuario
	public boolean VerificarContrasenia(String contrasenia) {
		if(contrasenia.compareTo(getContrasenia())==0)
			return true;
	return false;				
	}
 
	@Override
	public String toString() {
		return "Persona [usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}
	
}
