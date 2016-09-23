package ar.edu.uccor.seminario1.far.interfaces;

import java.io.File;
import java.io.IOException;

import ar.edu.uccor.seminario1.far.RespuestaEngine;

/**
 * Servicio que debe prestar el motor de búsqueda y reemplazo de contenido de
 * archivo.
 * 
 * @author mariano
 *
 */
public interface IEngineFaR {

	/**
	 * Ejecuta la operación de búsqueda y reemplazo. El archivo no debe ser
	 * escrito si no se encontraron coincidencias.
	 * 
	 * @param paramAnalyzer
	 * @param file
	 * @return la cantidad de veces que se reemplazó el texto y el nomnre del
	 *         archivo que contiene las modificaciones.
	 */
	public RespuestaEngine findAndReplace(IParameters paramAnalyzer, File file) throws IOException;

}
