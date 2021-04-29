package clases;

public class Resultado {
	private int idPartido;
	private Equipo ganador;
	public Resultado(int idPartido, Equipo ganador) {
		super();
		this.idPartido = idPartido;
		this.ganador = ganador;
	}
	public Resultado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	public Equipo getGanador() {
		return ganador;
	}
	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resultado [idPartido=");
		builder.append(idPartido);
		builder.append(", ganador=");
		builder.append(ganador);
		builder.append("]");
		return builder.toString();
	}


	
	
}
