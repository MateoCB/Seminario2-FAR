package ar.edu.uccor.seminario1.far.implement;

import java.io.File;
import java.io.FilenameFilter;

import ar.edu.uccor.seminario1.far.interfaces.IParameters;

public class FiltroFileName implements FilenameFilter {

	private String fileText;
	private String COMODIN = "*";
	
	@Override
	public boolean accept(File dir, String name) {
		if (fileText.equals(COMODIN)) 
			return true;
		else 
			return (name.contains(fileText)) ? true : false;
	}

	public void setParamAnalyzerReference(IParameters paramAnalyzer) {
		fileText = paramAnalyzer.getNameFileTextSearch();
	}
}
