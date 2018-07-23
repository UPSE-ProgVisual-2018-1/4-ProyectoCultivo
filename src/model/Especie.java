package model;

public class Especie {
	private final int id;
	private String nombreComun;
	private String nombreCientifico;
	private String rutaImagen;

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public Especie(int id, String nombreCientifico) {
		super();
		this.id = id;
		this.nombreCientifico = nombreCientifico;
	}
	
	public String getNombreComun() {
		return nombreComun;
	}
	public void setNombreComun(String nombreComunn) {
		this.nombreComun = nombreComunn;
	}
	public String getNombreCientifico() {
		return nombreCientifico;
	}
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Especie [nombreCientifico=" + nombreCientifico + ", nombreComun=" + nombreComun + "]";
	}
	
	
	
}
