package com.gmail.docfordja.exception;

public class MyException extends Exception {

	public String getMessge() {
		return "Repeatable value"+ "; " + super.getMessage();
	}
}