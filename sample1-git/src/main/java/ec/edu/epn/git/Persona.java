package ec.edu.epn.git;

public class Persona {
	
	private String usuario;
	private String contrasenia;
	
	public Persona(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
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
	
	public boolean VerificarUsuario(String usuario) {
		if(usuario.compareTo(getUsuario())==0)
			return true;
	return false;
		
		
	}
	
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
