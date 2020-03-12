package com.gmail.docfordja.exception;

public class IllegalNameException extends Exception {
	
	public String getMessge() {
		return "Illegal name"+ "; " + super.getMessage();
	}

}
