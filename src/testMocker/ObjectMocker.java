package testMocker;

import java.util.ArrayList;
import java.util.List;

import model.Agricultor;
import model.Especie;
import model.Genero;

public class ObjectMocker {

	public static List<Agricultor> listaAgricultoresMockeados = new ArrayList<Agricultor>();
	
	public static List<Especie> listaEspecieMocker()
	{
		List<Especie> listaEspeciesMockeadas =  new ArrayList<Especie>();
		
		Especie especie1 = new Especie(1, "Hordeum vulgare");
		especie1.setNombreComun("Cebada");
		
		Especie especie2 = new Especie(2, "Cannabis sativa");
		especie2.setNombreComun("Maracachafa");
		
		Especie especie3 = new Especie(3, "Zea mays");
		especie3.setNombreComun("Maiz");
		
		listaEspeciesMockeadas.add(especie1);
		listaEspeciesMockeadas.add(especie2);
		listaEspeciesMockeadas.add(especie3);
		
		return listaEspeciesMockeadas;
		
	}
	
	public static void mockearListaAgricultores()
	{
		
		Agricultor a1 = new Agricultor("1111111111", "Bolillo Gomez");
//		Agricultor.GrupoFamiliar gfBolillos = a1.new GrupoFamiliar();
//		gfBolillos.setNumeroHijos(3);
//		
		Agricultor a2 = new Agricultor("2222222222", "Bob Esponja");
//		Agricultor.GrupoFamiliar gf = a2.new GrupoFamiliar();
//		gf.setNumeroHijos(2);
//		gf.setPareja(true);
//		
		Agricultor a3 = new Agricultor("3333333333", "Carmen San Diego");
		a3.setGenero(Genero.FEMENINO);
		
		Agricultor a4 = new Agricultor("4444444444", "Hector Steam");
		a4.setGenero(Genero.MASCULINO);
		
		Agricultor a5 = new Agricultor("5555555555", "Bob Toronja");
		a5.setGenero(Genero.PREFIERO_NO_DECIR);
		
		Agricultor a6 = new Agricultor("6666666666", "Angelica Pickles");
		a6.setGenero(Genero.FEMENINO);
		
		Agricultor a7 = new Agricultor("7777777777", "Don Windows");
		a7.setGenero(Genero.MASCULINO);
		
		Agricultor a8 = new Agricultor("8888888888", "La Tuka Murillo");
		a8.setGenero(Genero.OTRO);
		a8.setTelefono("0999999999");
		
		Agricultor a9 = new Agricultor("9999999999", "Joe Black");
		
		Agricultor a10 = new Agricultor("0000000000", "Juan Pueblo");
		
		//Agregamos Agricultores a la lista
		listaAgricultoresMockeados.add(a1);
		listaAgricultoresMockeados.add(a2);
		listaAgricultoresMockeados.add(a3);
		listaAgricultoresMockeados.add(a4);
		listaAgricultoresMockeados.add(a5);
		listaAgricultoresMockeados.add(a6);
		listaAgricultoresMockeados.add(a7);
		listaAgricultoresMockeados.add(a8);
		listaAgricultoresMockeados.add(a9);
		listaAgricultoresMockeados.add(a10);
		
	}
	
	
}
