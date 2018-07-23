package model;

import java.time.LocalDate;
import java.util.List;

public class Cultivo {
	private final int id;
	private double hectareasCultivadas;
	private Especie especie;
	private TipoSemilla semilla;
	private TipoPaquete tipoPaquete;
	private LocalDate fechaSiembra;
	private List<Control> laboresControl;
	private boolean aplicacionUrea;
	private LocalDate fecha30dias;
	private LocalDate fecha45dias;
	private LocalDate fecha60dias;
	private CostoProduccion costoProduccion;
	
	public Cultivo(int id, double hectareasCultivadas, Especie especie, TipoSemilla semilla, LocalDate fechaSiembra) {
		super();
		this.id = id;
		this.hectareasCultivadas = hectareasCultivadas;
		this.especie = especie;
		this.semilla = semilla;
		this.fechaSiembra = fechaSiembra;
	}
	
	public double getHectareasCultivadas() {
		return hectareasCultivadas;
	}
	
	public void setHectareasCultivadas(double hectareasCultivadas) {
		this.hectareasCultivadas = hectareasCultivadas;
	}
	
	public Especie getEspecie() {
		return especie;
	}
	
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	public TipoSemilla getSemilla() {
		return semilla;
	}
	
	public void setSemilla(TipoSemilla semilla) {
		this.semilla = semilla;
	}
	
	public TipoPaquete getTipoPaquete() {
		return tipoPaquete;
	}
	
	public void setTipoPaquete(TipoPaquete tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}
	
	public LocalDate getFechaSiembra() {
		return fechaSiembra;
	}
	
	public void setFechaSiembra(LocalDate fechaSiembra) {
		this.fechaSiembra = fechaSiembra;
	}
	
	public List<Control> getLaboresControl() {
		return laboresControl;
	}
	
	public void setLaboresControl(List<Control> laboresControl) {
		this.laboresControl = laboresControl;
	}
	
	public boolean isAplicacionUrea() {
		return aplicacionUrea;
	}
	
	public void setAplicacionUrea(boolean aplicacionUrea) {
		this.aplicacionUrea = aplicacionUrea;
	}
	
	public LocalDate getFecha30dias() {
		return fecha30dias;
	}
	
	public void setFecha30dias(LocalDate fecha30dias) {
		this.fecha30dias = fecha30dias;
	}
	
	public LocalDate getFecha45dias() {
		return fecha45dias;
	}
	
	public void setFecha45dias(LocalDate fecha45dias) {
		this.fecha45dias = fecha45dias;
	}
	
	public LocalDate getFecha60dias() {
		return fecha60dias;
	}
	
	public void setFecha60dias(LocalDate fecha60dias) {
		this.fecha60dias = fecha60dias;
	}
	
	public CostoProduccion getCostoProduccion() {
		return costoProduccion;
	}
	
	public void setCostoProduccion(CostoProduccion costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Cultivo [hectareasCultivadas=" + hectareasCultivadas + ", especie=" + especie + ", semilla=" + semilla
				+ ", fechaSiembra=" + fechaSiembra + "]";
	}
	
}
