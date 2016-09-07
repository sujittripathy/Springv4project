package org.git.spring4.samples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CertificationConfig {
	@Bean(initMethod="init",destroyMethod="clean")
	@Scope("prototype")
	public Employee employee(){
		return new Employee(certification());
	}
	@Bean
	@Scope("prototype")
	public Certification certification(){
		//return new JavaCertification(System.out);
		return new BigDataCertification(System.out);
	}
}
