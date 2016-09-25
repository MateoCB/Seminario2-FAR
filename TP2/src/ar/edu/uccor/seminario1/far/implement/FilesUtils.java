package ar.edu.uccor.seminario1.far.implement;

import java.io.File;
import java.io.IOException;

import ar.edu.uccor.seminario1.far.interfaces.IFilesUtils;
import ar.edu.uccor.seminario1.far.interfaces.IParameters;

public class FilesUtils implements IFilesUtils {
	
	private File[] files;
	private File file; 
	private FiltroFileName fileNameFilter;
	
	@Override
	public File[] getFiles(IParameters paramAnalyzer) throws IOException {
		
		file = new File(paramAnalyzer.getFindPath());
		fileNameFilter = new FiltroFileName();
		fileNameFilter.setParamAnalyzerReference(paramAnalyzer);
		files = file.listFiles(fileNameFilter);
		
		return files;
	}

}
