package clases;

public class Partido extends Resultado{
	private int idPartido;
	private Usuario j1,j2,j3,j4;
	private Reserva rPartido;
	public Partido(int idPartido, Equipo ganador, int idPartido2, Usuario j1, Usuario j2, Usuario j3, Usuario j4,
			Reserva rPartido) {
		super(idPartido, ganador);
		idPartido = idPartido2;
		this.j1 = j1;
		this.j2 = j2;
		this.j3 = j3;
		this.j4 = j4;
		this.rPartido = rPartido;
	}
	public Partido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Partido(int idPartido, Equipo ganador) {
		super(idPartido, ganador);
		// TODO Auto-generated constructor stub
	}
	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
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
	public Usuario getJ3() {
		return j3;
	}
	public void setJ3(Usuario j3) {
		this.j3 = j3;
	}
	public Usuario getJ4() {
		return j4;
	}
	public void setJ4(Usuario j4) {
		this.j4 = j4;
	}
	public Reserva getrPartido() {
		return rPartido;
	}
	public void setrPartido(Reserva rPartido) {
		this.rPartido = rPartido;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Partido [idPartido=");
		builder.append(idPartido);
		builder.append(", j1=");
		builder.append(j1);
		builder.append(", j2=");
		builder.append(j2);
		builder.append(", j3=");
		builder.append(j3);
		builder.append(", j4=");
		builder.append(j4);
		builder.append(", rPartido=");
		builder.append(rPartido);
		builder.append("]");
		return builder.toString();
	}
	
}