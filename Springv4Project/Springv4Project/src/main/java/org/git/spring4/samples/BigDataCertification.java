package org.git.spring4.samples;

import java.io.PrintStream;

public class BigDataCertification implements Certification {

	private PrintStream stream;

	public BigDataCertification(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public String certificationName() {
		return "Apache Spark";
	}

	@Override
	public int certificationPrice() {
		return 500;

	}

	@Override
	public String certificationVendor() {
		return "Apache";
	}
	@Override
	public void getCertificationDetails(){
		stream.println(certificationName()+"|"+certificationPrice()+"|"+certificationVendor());
	}
}
