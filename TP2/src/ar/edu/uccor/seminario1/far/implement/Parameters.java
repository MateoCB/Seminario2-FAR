package ar.edu.uccor.seminario1.far.implement;

import ar.edu.uccor.seminario1.far.interfaces.IParameters;

public class Parameters implements IParameters {
	
	private String[] args;

	@Override
	public void setArgs(String[] args) {
		this.args = args;
	}

	@Override
	public boolean isFindText() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReplaceText() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOverwrite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNameFileTextSearch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFindPath() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasParamsError() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFindText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReplaceText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameFileTextSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFindPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
