package org.git.spring.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
=======
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
>>>>>>> branch 'master' of https://github.com/sujittripathy/spring-projects.git

import org.springframework.stereotype.Component;

@Entity
@Component
//@Table(name="CERTIFICATION_INFO")
public class Certification {
	@Id
	@GeneratedValue
	private int certID;
	private String certName;
	private String version;
	private String module;
	private Date availableSince;
	//@Transient
	private String gwCenter;
	@OneToOne(cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	@JoinColumn//(name="testCenterLocation_FK")
	private TestCenterLocation testCenterLocation;
	
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
	public void setAvailableSince(Date availableSince) {
		this.availableSince = availableSince;
	}
	public String getGwCenter() {
		return gwCenter;
	}
	public void setGwCenter(String gwCenter) {
		this.gwCenter = gwCenter;
	}
	public int getCertID() {
		return certID;
	}
	public void setCertID(int certID) {
		this.certID = certID;
	}
	
	@Override
	public String toString(){
		return "["+getCertID()+","+getCertName()+","
					+getVersion()+","+getModule()+","+getAvailableSince()+"]";
	}
	public TestCenterLocation getTestCenterLocation() {
		return testCenterLocation;
	}
	public void setTestCenterLocation(TestCenterLocation testCenterLocation) {
		this.testCenterLocation = testCenterLocation;
	}
	
}
