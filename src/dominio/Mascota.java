package dominio;

public abstract class Mascota {

	private String nombre;
	private String sexo;
	private int edad;
	public boolean esterilizado;
	
	public Mascota(String nombre, String sexo, int edad, boolean esterilizado) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.esterilizado = esterilizado;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public boolean isEsterilizado() {
		return esterilizado;
	}


	public void setEsterilizado(boolean esterilizado) {
		this.esterilizado = esterilizado;
	}
	
	
}
