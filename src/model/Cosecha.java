package model;

import java.time.LocalDate;

public class Cosecha {
	private int id;
	private LocalDate fecha;
	private double hectareasCosechadas;
	private double produccionTotal;
	private double produccionTotalTM;
	private double rendimientoPorHectareaPromedio;
	private int humedadPorCien;
	private int impurezaPorCien;
	private LocalDate fechaComercializacion;
	private DestinoComercializacion destinoComercializacion;
	private double precioVenta;
	private PostCosecha postCosecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getHectareasCosechadas() {
		return hectareasCosechadas;
	}
	public void setHectareasCosechadas(double hectareasCosechadas) {
		this.hectareasCosechadas = hectareasCosechadas;
	}
	public double getProduccionTotal() {
		return produccionTotal;
	}
	public void setProduccionTotal(double produccionTotal) {
		this.produccionTotal = produccionTotal;
	}
	public double getProduccionTotalTM() {
		return produccionTotalTM;
	}
	public void setProduccionTotalTM(double produccionTotalTM) {
		this.produccionTotalTM = produccionTotalTM;
	}
	public double getRendimientoPorHectareaPromedio() {
		return rendimientoPorHectareaPromedio;
	}
	public void setRendimientoPorHectareaPromedio(double rendimientoPorHectareaPromedio) {
		this.rendimientoPorHectareaPromedio = rendimientoPorHectareaPromedio;
	}
	public int getHumedadPorCien() {
		return humedadPorCien;
	}
	public void setHumedadPorCien(int humedadPorCien) {
		this.humedadPorCien = humedadPorCien;
	}
	public int getImpurezaPorCien() {
		return impurezaPorCien;
	}
	public void setImpurezaPorCien(int impurezaPorCien) {
		this.impurezaPorCien = impurezaPorCien;
	}
	public LocalDate getFechaComercializacion() {
		return fechaComercializacion;
	}
	public void setFechaComercializacion(LocalDate fechaComercializacion) {
		this.fechaComercializacion = fechaComercializacion;
	}
	public DestinoComercializacion getDestinoComercializacion() {
		return destinoComercializacion;
	}
	public void setDestinoComercializacion(DestinoComercializacion destinoComercializacion) {
		this.destinoComercializacion = destinoComercializacion;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public PostCosecha getPostCosecha() {
		return postCosecha;
	}
	public void setPostCosecha(PostCosecha postCosecha) {
		this.postCosecha = postCosecha;
	}
	
	
}
