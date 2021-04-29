package clases;

public class Pista {
	private int idPista;
	private boolean cubierta;
	private boolean disponible;
	private Recinto recinto;
	public Pista(int id, boolean cubierta, boolean disponible, Recinto recinto) {
		super();
		this.idPista = id;
		this.cubierta = cubierta;
		this.disponible = disponible;
		this.recinto = recinto;
	}
	public Pista() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return idPista;
	}
	public void setId(int id) {
		this.idPista = id;
	}
	public boolean isCubierta() {
		return cubierta;
	}
	public void setCubierta(boolean cubierta) {
		this.cubierta = cubierta;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Recinto getRecinto() {
		return recinto;
	}
	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pista [id=");
		builder.append(idPista);
		builder.append(", cubierta=");
		builder.append(cubierta);
		builder.append(", disponible=");
		builder.append(disponible);
		builder.append(", recinto=");
		builder.append(recinto);
		builder.append("]");
		return builder.toString();
	}
	
	
}
