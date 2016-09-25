package ar.edu.uccor.seminario1.far.implement;

import ar.edu.uccor.seminario1.far.interfaces.IParameters;

public class Parameters implements IParameters {
	
	private String[] args;
	private int index;
	private String findText;
	private String replaceText;
	private String fileText;
	private String pathText;
	
	enum PARAMETERS {
		FIND("-find="), REPLACE("-replace="), FILETEXT("-fileText="), OVERWRITE("-overwrite"), PATH("-path="), DEFAULT_PATH("src/");
		private String s;
		PARAMETERS(String s) {
			this.s = s;
		}
		String getParameter() {
			return s;
		}
		int getIndex() {
			return s.length();
		}
	}

	@Override
	public void setArgs(String[] args) {
		this.args = args;
	}
	
	@Override
	public boolean isFindText() {
		for (String a : args) {			
			index = a.indexOf(PARAMETERS.FIND.getParameter());
			if (index != -1) {
				findText = a.substring(PARAMETERS.FIND.getIndex());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isReplaceText() {
		for (String a : args) {			
			index = a.indexOf(PARAMETERS.REPLACE.getParameter());
			if (index != -1) {
				replaceText = a.substring(PARAMETERS.REPLACE.getIndex());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isNameFileTextSearch() {
		for (String a : args) {			
			index = a.indexOf(PARAMETERS.FILETEXT.getParameter());
			if (index != -1) {
				fileText = a.substring(PARAMETERS.FILETEXT.getIndex());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isFindPath() {
		for (String a : args) {			
			index = a.indexOf(PARAMETERS.PATH.getParameter());
			if (index != -1) {
				pathText = a.substring(PARAMETERS.PATH.getIndex());
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean isOverwrite() {
		for (String a : args) {
			if (a.contains("-overwrite")) return true;
		}
		return false;
	}

	@Override
	public boolean hasParamsError() {
		return !(isFindText() & isReplaceText() & isNameFileTextSearch());
	}

	@Override
	public String getHelp() {
		return "\nUSO: \n "
				+ "\tfar -find=texto_a_buscar & -replace=texto_remplazo & -fileText=filtro \n"
				+ "\tcomandos opcionales -overwrite | -path=directorio_a_usar \n"
				+ "DONDE: \n"
				+ "\ttexto_a_buscar = texto que se reemplazara \n"
				+ "\ttexto_reemplazo = texto por el cual se reemplazara \n"
				+ "\tfiltro = filtro de archivos, se permite comodin * para seleccionar todos \n"
				+ "\t-overwrite = si esta presente se sobreescribe el archivo original, de otro modo se crea uno nuevo con el agregado _replaced al final \n"
				+ "\tdirectorio_a_usar = directorio donde realizar el far, en caso ausente es /src por defecto \n\n";
	}

	@Override
	public String getFindText() {
		return findText;
	}

	@Override
	public String getReplaceText() {
		return replaceText;
	}

	@Override
	public String getNameFileTextSearch() {
		return fileText;
	}

	@Override
	public String getFindPath() {
		return (isFindPath()) ? pathText : PARAMETERS.DEFAULT_PATH.getParameter();
	}

}
