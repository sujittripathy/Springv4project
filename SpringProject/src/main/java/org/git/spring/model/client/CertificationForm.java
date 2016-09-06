package org.git.spring.model.client;

import java.util.Date;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement
@Component
public class CertificationForm {
		private int certID;
		@Size(min=5, max=100, message="name is incorrect")
		private String certName;
		private String version;
		private String module;
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
}
