package clases;

public class Equipo {

	private int idEquipo;
	private String nombreEquipo;
	private Usuario j1;
	private Usuario j2;
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Equipo(int idEquipo, String nombreEquipo, Usuario j1, Usuario j2) {
		super();
		this.idEquipo = idEquipo;
		this.nombreEquipo = nombreEquipo;
		this.j1 = j1;
		this.j2 = j2;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public Usuario getJ1() {
		return j1;
	}
	public void setJ1(Usuario j1) {
		this.j1 = j1;
	}
	public Usuario getJ2() {
		return j2;
	}
	public void setJ2(Usuario j2) {
		this.j2 = j2;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipo [idEquipo=");
		builder.append(idEquipo);
		builder.append(", nombreEquipo=");
		builder.append(nombreEquipo);
		builder.append(", j1=");
		builder.append(j1);
		builder.append(", j2=");
		builder.append(j2);
		builder.append("]");
		return builder.toString();
	}
	
	
}
