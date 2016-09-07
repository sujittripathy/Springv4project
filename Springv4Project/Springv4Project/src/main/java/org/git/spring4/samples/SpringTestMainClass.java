package org.git.spring4.samples;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTestMainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(CertificationConfig.class);
		Employee employee = context.getBean(Employee.class);
		employee.takeCertification();
		context.close();
	}

}
