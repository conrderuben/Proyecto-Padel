package clases;

public class Direccion {
	private int idDireccion;
	private int codigoPostal;
	private String calle;
	private int numero;
	public Direccion(int idDireccion, int codigoPostal, String calle, int numero) {
		super();
		this.idDireccion = idDireccion;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.numero = numero;
	}
	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Direccion [idDireccion=");
		builder.append(idDireccion);
		builder.append(", codigoPostal=");
		builder.append(codigoPostal);
		builder.append(", calle=");
		builder.append(calle);
		builder.append(", numero=");
		builder.append(numero);
		builder.append("]");
		return builder.toString();
	}


	
	
}
