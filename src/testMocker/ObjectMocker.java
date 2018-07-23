package testMocker;

import java.util.ArrayList;
import java.util.List;

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
}