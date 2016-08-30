package org.git.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Certification {
	@Id
	@GeneratedValue
	private String certID;
	private String certName;
	private String version;
	private String module;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date availableSince;
	private String gwCenter;
	
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public Date getAvailableSince() {
		return availableSince;
	}
	public void setAvailableSice(Date availableSince) {
		this.availableSince = availableSince;
	}
	public String getGwCenter() {
		return gwCenter;
	}
	public void setGwCenter(String gwCenter) {
		this.gwCenter = gwCenter;
	}
	public String getCertID() {
		return certID;
	}
	public void setCertID(String certID) {
		this.certID = certID;
	}
	
}
