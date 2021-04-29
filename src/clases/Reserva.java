package clases;

import java.util.Calendar;

public class Reserva {
	private String codReserva;
	private Pista pistaR;
	private Calendar fecha;
	
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reserva(String codReserva, Pista pistaR, Calendar fecha) {
		super();
		this.codReserva = codReserva;
		this.pistaR = pistaR;
		this.fecha = fecha;
		
	}
	public String getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}
	public Pista getPistaR() {
		return pistaR;
	}
	public void setPistaR(Pista pistaR) {
		this.pistaR = pistaR;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reserva [codReserva=");
		builder.append(codReserva);
		builder.append(", pistaR=");
		builder.append(pistaR);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append("]");
		return builder.toString();
	}
	
	}
