
package com.project.attendance.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("employees")
public class Employee {
		
		@Id
		private String id;
		private String employeeId;
		private String employeeFullName;
		private String employeeEmail;
		private String employeePhoneNo;
		private String employeeAadhar;
		private String employeeAvatar;
		private String employeeTeamId;
		private String employeeTeamName;
		private Boolean employeeIsManager;
		private String employeeManagerId;
		private String employeeManagerName;		
		private String employeeRole;
		private Boolean employeeIsAdmin;
		
		
		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
				
		public String getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeFullName() {
			return employeeFullName;
		}
		public void setEmployeeFullName(String employeeName) {
			this.employeeFullName = employeeName;
		}
		
		public String getEmployeeEmail() {
			return employeeEmail;
		}
		public void setEmployeeEmail(String employeeEmail) {
			this.employeeEmail = employeeEmail;
		}
		public String getEmployeePhoneNo() {
			return employeePhoneNo;
		}
		public void setEmployeePhoneNo(String employeePhoneNo) {
			this.employeePhoneNo = employeePhoneNo;
		}
		public String getEmployeeAadhar() {
			return employeeAadhar;
		}
		public void setEmployeeAadhar(String employeeAadhar) {
			this.employeeAadhar = employeeAadhar;
		}
		public String getEmployeeAvatar() {
			return employeeAvatar;
		}
		public void setEmployeeAvatar(String employeeAvatar) {
			this.employeeAvatar = employeeAvatar;
		}
		public Boolean getEmployeeIsManager() {
			return employeeIsManager;
		}
		public void setEmployeeIsManager(Boolean employeeIsManager) {
			this.employeeIsManager = employeeIsManager;
		}
		
		
		public String getEmployeeTeamId() {
			return employeeTeamId;
		}
		public void setEmployeeTeamId(String employeeTeamId) {
			this.employeeTeamId = employeeTeamId;
		}
		
		public String getEmployeeManagerName() {
			return employeeManagerName;
		}
		public void setEmployeeManagerName(String employeeManagerName) {
			this.employeeManagerName = employeeManagerName;
		}
		
		public String getEmployeeManagerId() {
			return employeeManagerId;
		}
		public void setEmployeeManagerId(String employeeManagerId) {
			this.employeeManagerId = employeeManagerId;
		}
		public String getEmployeeRole() {
			return employeeRole;
		}
		public void setEmployeeRole(String employeeRole) {
			this.employeeRole = employeeRole;
		}
		public String getEmployeeTeamName() {
			return employeeTeamName;
		}
		public void setEmployeeTeamName(String employeeTeamName) {
			this.employeeTeamName = employeeTeamName;
		}
		public Boolean getEmployeeIsAdmin() {
			return employeeIsAdmin;
		}
		public void setEmployeeIsAdmin(Boolean employeeIsAdmin) {
			this.employeeIsAdmin = employeeIsAdmin;
		}
		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", employeeFullName=" + employeeFullName + ", employeeEmail="
					+ employeeEmail + ", employeePhoneNo=" + employeePhoneNo + ", employeeAdhar=" + employeeAadhar
					+ ", employeeAvatar=" + employeeAvatar + ", employeeTeamId=" + employeeTeamId
					+ ", employeeTeamName=" + employeeTeamName + ", employeeIsManager=" + employeeIsManager
					+ ", employeeManagerId=" + employeeManagerId + ", employeeManagerName=" + employeeManagerName
					+ ", employeeRole=" + employeeRole + ", employeeIsAdmin=" + employeeIsAdmin + "]";
		}
		
		
	
}


































//package com.project.attendance.model;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//@Document("employeeData")
//public class Employee {
//		
//		@Id
//		private String employeeId;
//		private String employeeFullName;
//		private String employeeEmail;
//		private String employeePhoneNo;
//		private String employeeAdhar;
//		private String employeeAvatar;
//		private String employeeTeamId;
//		private String employeeTeamName;
//		private Boolean employeeIsManager;
//		private String employeeManagerId;
//		private String employeeManagerName;		
//		private String employeeRole;
//		private Boolean employeeIsAdmin;
//		
//		
//		
//		public Employee() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//				
//		public String getEmployeeId() {
//			return employeeId;
//		}
//		public void setEmployeeId(String employeeId) {
//			this.employeeId = employeeId;
//		}
//		public String getEmployeeFullName() {
//			return employeeFullName;
//		}
//		public void setEmployeeFullName(String employeeName) {
//			this.employeeFullName = employeeName;
//		}
//		
//		public String getEmployeeEmail() {
//			return employeeEmail;
//		}
//		public void setEmployeeEmail(String employeeEmail) {
//			this.employeeEmail = employeeEmail;
//		}
//		public String getEmployeePhoneNo() {
//			return employeePhoneNo;
//		}
//		public void setEmployeePhoneNo(String employeePhoneNo) {
//			this.employeePhoneNo = employeePhoneNo;
//		}
//		public String getEmployeeAdhar() {
//			return employeeAdhar;
//		}
//		public void setEmployeeAdhar(String employeeAdhar) {
//			this.employeeAdhar = employeeAdhar;
//		}
//		public String getEmployeeAvatar() {
//			return employeeAvatar;
//		}
//		public void setEmployeeAvatar(String employeeAvatar) {
//			this.employeeAvatar = employeeAvatar;
//		}
//		public Boolean getEmployeeIsManager() {
//			return employeeIsManager;
//		}
//		public void setEmployeeIsManager(Boolean employeeIsManager) {
//			this.employeeIsManager = employeeIsManager;
//		}
//		
//		
//		
//		public String getEmployeeTeamId() {
//			return employeeTeamId;
//		}
//		public void setEmployeeTeamId(String employeeTeamId) {
//			this.employeeTeamId = employeeTeamId;
//		}
//		
//		public String getEmployeeManagerName() {
//			return employeeManagerName;
//		}
//		public void setEmployeeManagerName(String employeeManagerName) {
//			this.employeeManagerName = employeeManagerName;
//		}
//		
//		public String getEmployeeManagerId() {
//			return employeeManagerId;
//		}
//		public void setEmployeeManagerId(String employeeManagerId) {
//			this.employeeManagerId = employeeManagerId;
//		}
//		public String getEmployeeRole() {
//			return employeeRole;
//		}
//		public void setEmployeeRole(String employeeRole) {
//			this.employeeRole = employeeRole;
//		}
//		public String getEmployeeTeamName() {
//			return employeeTeamName;
//		}
//		public void setEmployeeTeamName(String employeeTeamName) {
//			this.employeeTeamName = employeeTeamName;
//		}
//		public Boolean getEmployeeIsAdmin() {
//			return employeeIsAdmin;
//		}
//		public void setEmployeeIsAdmin(Boolean employeeIsAdmin) {
//			this.employeeIsAdmin = employeeIsAdmin;
//		}
//		@Override
//		public String toString() {
//			return "Employee [employeeId=" + employeeId + ", employeeFullName=" + employeeFullName + ", employeeEmail="
//					+ employeeEmail + ", employeePhoneNo=" + employeePhoneNo + ", employeeAdhar=" + employeeAdhar
//					+ ", employeeAvatar=" + employeeAvatar + ", employeeTeamId=" + employeeTeamId
//					+ ", employeeTeamName=" + employeeTeamName + ", employeeIsManager=" + employeeIsManager
//					+ ", employeeManagerId=" + employeeManagerId + ", employeeManagerName=" + employeeManagerName
//					+ ", employeeRole=" + employeeRole + ", employeeIsAdmin=" + employeeIsAdmin + "]";
//		}
//		
//		
//	
//}