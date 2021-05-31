package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Reserva")
public class Reserva implements Serializable{
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	
	@Column(name = "descripcionReserva", nullable = false, length =30)
	private String descripcionReserva;
	
	private Date fechaReserva;
	
	public Reserva() {
		super();
		
	}

	public Reserva(int idReserva, String descripcionReserva, Date fechaReserva) {
		super();
		this.idReserva = idReserva;
		this.descripcionReserva = descripcionReserva;
		this.fechaReserva = fechaReserva;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getDescripcionReserva() {
		return descripcionReserva;
	}

	public void setDescripcionReserva(String descripcionReserva) {
		this.descripcionReserva = descripcionReserva;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	
}
