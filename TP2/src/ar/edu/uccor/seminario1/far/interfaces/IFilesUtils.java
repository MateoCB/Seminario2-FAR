package ar.edu.uccor.seminario1.far.interfaces;

import java.io.File;
import java.io.IOException;

public interface IFilesUtils {

	/**
	 * 
	 * @param paramAnalyzer
	 * @return lista de los archivos que coincidan con el criterio de búsqueda y
	 *         camino, en el caso que haya sido establecido.
	 * @throws IOException
	 */
	public File[] getFiles(IParameters paramAnalyzer) throws IOException;
}
