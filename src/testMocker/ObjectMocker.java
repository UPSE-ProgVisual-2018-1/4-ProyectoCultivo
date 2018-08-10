package testMocker;

import java.util.ArrayList;
import java.util.List;

import model.Agricultor;
import model.Especie;

public class ObjectMocker {

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
	
	public List<Agricultor> listaAgricultoresMocker()
	{
		List<Agricultor> listaAgricultores = new ArrayList<Agricultor>();
		
		Agricultor a1 = new Agricultor("1111111111", "Bolillo Gomez");
//		Agricultor.GrupoFamiliar gfBolillos = a1.new GrupoFamiliar();
//		gfBolillos.setNumeroHijos(3);
//		
		Agricultor a2 = new Agricultor("2222222222", "Bob Esponja");
//		Agricultor.GrupoFamiliar gf = a2.new GrupoFamiliar();
//		gf.setNumeroHijos(2);
//		gf.setPareja(true);
//		
		listaAgricultores.add(a1);
		listaAgricultores.add(a2);
		
		return listaAgricultores;
		
	}
}
