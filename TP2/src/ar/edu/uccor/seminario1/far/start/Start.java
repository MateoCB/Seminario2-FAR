/**
 * 
 */
package ar.edu.uccor.seminario1.far.start;

import ar.edu.uccor.seminario1.far.FindAndReplace;
import ar.edu.uccor.seminario1.far.exceptions.ParameterException;

public class Start {
	public static void main(String[] args) {
		try {
			new FindAndReplace(args,null,null,null).doFindAndReplace();
		} catch (ParameterException e) {
		}
	}
}
