package org.git.spring4.samples;

import java.io.PrintStream;

public class JavaCertification implements Certification{
	private PrintStream stream;
	
	public JavaCertification(PrintStream stream){
		this.stream =  stream;
	}
	@Override
	public String certificationName() {
		return "Java 1.8";
	}

	@Override
	public int certificationPrice() {
		return 150;
	}

	@Override
	public String certificationVendor() {
		return "Oracle Corporation";
	}
	@Override
	public void getCertificationDetails(){
		stream.println(certificationName()+"|"+certificationPrice()+"|"+certificationVendor());
	}

}
