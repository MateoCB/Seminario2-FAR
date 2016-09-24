/**
 * 
 */
package ar.edu.uccor.seminario1.far.start;

import ar.edu.uccor.seminario1.far.FindAndReplace;
import ar.edu.uccor.seminario1.far.exceptions.ParameterException;
import ar.edu.uccor.seminario1.far.implement.FilesUtils;
import ar.edu.uccor.seminario1.far.implement.Parameters;

public class Start {
	public static void main(String[] args) {
		try {	
			new FindAndReplace(args, new Parameters(), new FilesUtils(),null).doFindAndReplace();
		} catch (ParameterException e) {
		}
	}
}
