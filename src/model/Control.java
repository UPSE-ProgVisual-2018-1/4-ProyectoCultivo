package model;

import java.time.LocalDate;

public class Control {
	private final int id;
	private int numero;
	private LocalDate fecha;
	private int hectarea;
	private String descripccion;
	private int fertilizacionFoliarHectarea;
	
	public Control(int id, int numero, LocalDate fecha, int hectarea) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha = fecha;
		this.hectarea = hectarea;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getHectarea() {
		return hectarea;
	}
	public void setHectarea(int hectarea) {
		this.hectarea = hectarea;
	}
	public String getDescripccion() {
		return descripccion;
	}
	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}
	public int getFertilizacionFoliarHectarea() {
		return fertilizacionFoliarHectarea;
	}
	public void setFertilizacionFoliarHectarea(int fertilizacionFoliarHectarea) {
		this.fertilizacionFoliarHectarea = fertilizacionFoliarHectarea;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Control [numero=" + numero + ", fecha=" + fecha + ", hectarea=" + hectarea + "]";
	}
}
