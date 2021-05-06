package clases;

import java.util.Calendar;

public class Reserva {
	private String codReserva;
	private int id_pista;
	private String fecha;
	private int id_usuario;
	
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reserva(String codReserva, int pistaR, String fecha, int id_usuario) {
		super();
		this.codReserva = codReserva;
		this.id_pista = pistaR;
		this.fecha = fecha;
		this.id_usuario = id_usuario;
	}

	public String getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}

	public int getPistaR() {
		return id_pista;
	}

	public void setPistaR(int pistaR) {
		this.id_pista = pistaR;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reserva [codReserva=");
		builder.append(codReserva);
		builder.append(", pistaR=");
		builder.append(id_pista);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", id_usuario=");
		builder.append(id_usuario);
		builder.append("]");
		return builder.toString();
	}
	
	
}
	
