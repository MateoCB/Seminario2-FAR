package ar.edu.uccor.seminario1.far.interfaces;

/**
 * Servicios que debe prestar el analizador de parametros de Find And Replace
 * 
 * @author mariano
 *
 */
public interface IParameters {
	/**
	 * Establecer los argumentos a analizar
	 * 
	 * @param args
	 */
	public void setArgs(String[] args);

	/**
	 * @return si esta presente el parametro que indica el texto a buscar
	 */
	public boolean isFindText();

	/**
	 * @return verdadero si esta presente el parametro que indica el texto
	 *         reemplazo
	 */
	public boolean isReplaceText();

	/**
	 * @return si los archivos en los que se encuentra y reemplaza un texto
	 *         deben ser reescritos o copiados.
	 */
	public boolean isOverwrite();

	/**
	 * @return si esta establecido el texto que se utilizara para buscar
	 *         archivos.
	 */
	public boolean isNameFileTextSearch();

	/**
	 * @return si esta establecido el camino en donde deben buscarse los
	 *         archivos
	 */
	public boolean isFindPath();

	/**
	 * @return verdadero si falta alguno de los parametros no opcionales
	 */
	public boolean hasParamsError();

	/**
	 * Este metodo explica como usar el comando, cuales son los nombres de los
	 * parametros, cuales de ellos son opcionales y cuales no.<br/>
	 * Ejemplo:<br/>
	 * far -find=texto_a_buscar -replace=texto_reemplazo
	 * -fileText=comodin_a_buscar [-overwrite] [-path=path_en_el_cual_buscar]
	 * <br/>
	 * Opciones:<br/>
	 * -find: indica el texto a buscar, es obligatorio.<br/>
	 * -overwrite: si esta presente se reemplazara el archivo en que se
	 * encuentren coincidencias, de lo contrario se creara un archivo con el
	 * mismo nombre agregando _replaced<br/>
	 * , etc
	 * 
	 * @return La ayuda en diversas lineas que le indican al usuario cuales son
	 *         los parametros y como usarlos.
	 */
	public String getHelp();

	/**
	 * @return el texto a buscar
	 */
	public String getFindText();

	/**
	 * @return el texto reemplazo
	 */
	public String getReplaceText();

	/**
	 * @return el texto que se utilizara para buscar archivos.
	 */
	public String getNameFileTextSearch();

	/**
	 * @return el camino en donde deben buscarse los archivos
	 */
	public String getFindPath();

}
