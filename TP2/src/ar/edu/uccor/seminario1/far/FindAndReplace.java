package ar.edu.uccor.seminario1.far;

import java.io.File;
import java.io.IOException;

import ar.edu.uccor.seminario1.far.exceptions.ParameterException;
import ar.edu.uccor.seminario1.far.interfaces.IEngineFaR;
import ar.edu.uccor.seminario1.far.interfaces.IFilesUtils;
import ar.edu.uccor.seminario1.far.interfaces.IParameters;

public class FindAndReplace {

	private IParameters paramAnalyzer;
	private IFilesUtils filesUtils;
	private IEngineFaR engine;

	public FindAndReplace(String[] args, IParameters paramAnalyzer, IFilesUtils filesUtils, IEngineFaR engine) throws ParameterException {
		this.paramAnalyzer = paramAnalyzer;
		this.filesUtils = filesUtils;
		this.engine = engine;
		
		paramAnalyzer.setArgs(args);

		if (paramAnalyzer.hasParamsError()) {
			System.out.println(paramAnalyzer.getHelp());
			throw new ParameterException();
		}
	}

	public boolean paramAnalysis() {
		if (!paramAnalyzer.hasParamsError()) {
			return true;
		} else {
			System.out.println(paramAnalyzer.getHelp());
			return false;
		}
	}

	public void doFindAndReplace() {
		File[] listToProcess = null;
		try {
			listToProcess = filesUtils.getFiles(paramAnalyzer);
		} catch (IOException e) {
			System.err.println("ERROR: " + e.getMessage());
			System.exit(-1);
		}
		if (listToProcess.length == 0) {
			System.out.println("No se encontraron archivos a procesar");
			System.exit(0);
		}
		int procesados = 0;
		System.out.println("Inicia el proceso.");
		for (File f : listToProcess) {
			System.out.printf("Abriendo %s%n", f.getAbsolutePath());
			RespuestaEngine respuesta = null;
			try {
				respuesta = engine.findAndReplace(paramAnalyzer, f);
			} catch (IOException e) {
				System.err.printf("ERROR: procesando %s [%s]%n", f.getAbsolutePath(), e.getMessage());
			}
			System.out.printf("Se encontraron y reemplazaron %d cadena(s).",
					(respuesta != null ? respuesta.getCantidadReemplazos() : 0));
			if (respuesta != null && respuesta.getCantidadReemplazos() > 0)
				procesados++;
		}
		System.out.printf("Se procesaron %d archivo(s).", procesados);
	}
}
