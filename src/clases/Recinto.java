package clases;

public class Recinto {
	private int idRecinto;
	private String nombre;
	private Direccion dRecinto;
	private float precioHora;
	public Recinto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recinto(int idRecinto, String nombre, Direccion dRecinto, float precioHora) {
		super();
		this.idRecinto = idRecinto;
		this.nombre = nombre;
		this.dRecinto = dRecinto;
		this.precioHora = precioHora;
	}
	public int getIdRecinto() {
		return idRecinto;
	}
	public void setIdRecinto(int idRecinto) {
		this.idRecinto = idRecinto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getdRecinto() {
		return dRecinto;
	}
	public void setdRecinto(Direccion dRecinto) {
		this.dRecinto = dRecinto;
	}
	public float getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recinto [idRecinto=");
		builder.append(idRecinto);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", dRecinto=");
		builder.append(dRecinto);
		builder.append(", precioHora=");
		builder.append(precioHora);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
