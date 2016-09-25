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
		
		prepareFAR(paramAnalyzer, file);
		
		if (respuesta.getCantidadReemplazos() != 0) {
			if (paramAnalyzer.isOverwrite()) {
				fileAux = new File(paramAnalyzer.getFindPath() + "/" + newFileName + fileExtencion);
				file.renameTo(fileAux);
			} else {
				fileAux = new File(paramAnalyzer.getFindPath() + "/" + newFileName + "_replaced" + fileExtencion);
				fileAux.createNewFile();
			}
		}
		return respuesta;
	}
	
	private void prepareFAR(IParameters paramAnalyzer, File file) {
		oldFileName = file.getName();
		int index = oldFileName.indexOf(".");
		fileExtencion = oldFileName.substring(index);
		oldFileName = oldFileName.substring(0, index);
		newFileName = oldFileName.replaceAll(paramAnalyzer.getFindText(), paramAnalyzer.getReplaceText());
		
		int count = 0;
		while(!oldFileName.equals(newFileName)) {
			oldFileName = oldFileName.replaceFirst(paramAnalyzer.getFindText(), paramAnalyzer.getReplaceText());
			count++;
		}
		respuesta.setCantidadReemplazos(count);
	}

}
