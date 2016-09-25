package ar.edu.uccor.seminario1.far.implement;

import java.io.File;
import java.io.IOException;

import ar.edu.uccor.seminario1.far.RespuestaEngine;
import ar.edu.uccor.seminario1.far.interfaces.IEngineFaR;
import ar.edu.uccor.seminario1.far.interfaces.IParameters;

public class EngineFAR implements IEngineFaR {

	private RespuestaEngine respuesta = new RespuestaEngine();
	private String oldFileName;
	private String newFileName;
	private File fileAux;
	private String fileExtencion;
	
	@Override
	public RespuestaEngine findAndReplace(IParameters paramAnalyzer, File file) throws IOException {
		
		/*
		oldFileName = file.getName();
		oldFileNameAux = file.getName();
		newFileName = oldFileName.replace(paramAnalyzer.getFindText(), paramAnalyzer.getReplaceText());
		
		count = 0;
		do {
			newFileNameAux = oldFileNameAux.replaceFirst(paramAnalyzer.getFindText(), paramAnalyzer.getReplaceText());
			if (!(newFileName.equals(oldFileName))) {
				count++;
			}
		} while (!(newFileNameAux.equals(newFileName)));
		
		respuesta.setCantidadReemplazos(count);
		*/
		
		if (paramAnalyzer.isOverwrite()) {
			oldFileName = file.getName();
			int index = oldFileName.indexOf(".");
			fileExtencion = oldFileName.substring(index);
			oldFileName = oldFileName.substring(0, index);
				
			newFileName = oldFileName.replaceAll(paramAnalyzer.getFindText(), paramAnalyzer.getReplaceText());	
			fileAux = new File(paramAnalyzer.getFindPath() + "/" + newFileName + fileExtencion);
			file.renameTo(fileAux);
		} else {
			oldFileName = file.getName();
			int index = oldFileName.indexOf(".");
			fileExtencion = oldFileName.substring(index);
			oldFileName = oldFileName.substring(0, index);
				
			newFileName = oldFileName.replaceAll(paramAnalyzer.getFindText(), paramAnalyzer.getReplaceText());	
			fileAux = new File(paramAnalyzer.getFindPath() + "/" + newFileName + "_replaced" + fileExtencion);
			fileAux.createNewFile();
		}
		
		return respuesta;
	}

}
