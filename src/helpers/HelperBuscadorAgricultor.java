package helpers;

import java.util.ArrayList;
import java.util.List;

import model.Agricultor;

public class HelperBuscadorAgricultor {

	public static List<Agricultor> buscarAgricultorPorCriterio(List<Agricultor> miembros,  Criterio criterio)
	{
		List<Agricultor> listaAgricultoresEncontrados = new ArrayList<Agricultor>();
		System.out.println("Los agricultores seleccionados segun el criterio " 
				+ criterio.toString() + " son:");
		for(Agricultor a: miembros)
		{
			if(criterio.verificar(a))
			{
				listaAgricultoresEncontrados.add(a);
				System.out.println(a);
			}
		}
		return listaAgricultoresEncontrados;
	}
}
