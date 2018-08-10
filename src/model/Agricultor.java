package model;

public class Agricultor {
	private final String cedula;
	private String nombre;
	private String telefono;
	private Genero genero;
	
	public Agricultor(String cedula, String nombre)
	{
		this.cedula = cedula;
		this.nombre = nombre;
		this.genero = Genero.PREFIERO_NO_DECIR;
		this.telefono = "";
	}
	
	public Agricultor(String cedula, String nombre, Genero genero)
	{
		this.cedula = cedula;
		this.nombre = nombre;
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getCedula() {
		return cedula;
	}

	@Override
	public String toString() {
		return cedula + " - " + nombre;
	}
	
	public String imprimirCompleto()
	{
		return "nombre: " + this.nombre + ", genero:" + this.getGenero();
	}
	
//	public class GrupoFamiliar
//	{
//		private int numeroHijos;
//		private boolean pareja;
//		public int getNumeroHijos() {
//			return numeroHijos;
//		}
//		public void setNumeroHijos(int numeroHijos) {
//			this.numeroHijos = numeroHijos;
//		}
//		public boolean isPareja() {
//			return pareja;
//		}
//		public void setPareja(boolean pareja) {
//			this.pareja = pareja;
//		}
//	}
}
