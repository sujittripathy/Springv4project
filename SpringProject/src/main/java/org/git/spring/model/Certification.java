package org.git.spring.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Certification {
	@Id
	@GeneratedValue
	private String certID;
	private String certName;
	private String version;
	private String module;
	private Date availableSice;
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
	public Date getAvailableSice() {
		return availableSice;
	}
	public void setAvailableSice(Date availableSice) {
		this.availableSice = availableSice;
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
