package org.git.spring4.samples;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {

	@Before("execution(public void org.git.spring4.samples.Employee.takeCertification())")
	public void logBefore(){
		System.out.println("Before Aspect");
	}
	/*
	@After("execution(* org.git.spring4.samples.Employee.takeCertification(..))")
	public void afterBefore(){
		System.out.println("After Aspect");
	}
*/
}
