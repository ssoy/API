package org.spring.api.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public void common(Exception e) {
		System.out.println("μμΈλ°μ");
		System.out.println(e.toString());
		e.printStackTrace();  
	}
}
