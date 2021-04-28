package clases;

public class Usuario {
	private int idUsuario;
	private String nombre;
	private String clave;
	private Direccion dUsuario;
	private char nivel;
	private int metodoPago;
	private int puntuacion;
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(int idUsuario, String nombre, String clave, Direccion dUsuario, char nivel, int metodoPago, int puntuacion) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.clave = clave;
		this.dUsuario = dUsuario;
		this.nivel = nivel;
		this.metodoPago = metodoPago;
		this.puntuacion = puntuacion;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Direccion getdUsuario() {
		return dUsuario;
	}
	public void setdUsuario(Direccion dUsuario) {
		this.dUsuario = dUsuario;
	}
	public char getNivel() {
		return nivel;
	}
	public void setNivel(char nivel) {
		this.nivel = nivel;
	}
	public int getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(int metodoPago) {
		this.metodoPago = metodoPago;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [idUsuario=");
		builder.append(idUsuario);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", clave=");
		builder.append(clave);
		builder.append(", dUsuario=");
		builder.append(dUsuario);
		builder.append(", nivel=");
		builder.append(nivel);
		builder.append(", metodoPago=");
		builder.append(metodoPago);
		builder.append(", puntuacion=");
		builder.append(puntuacion);
		builder.append("]");
		return builder.toString();
		
		
	}
	
	
}
