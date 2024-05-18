package com.project.attendance.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "attendances")
public class Attendance {
    
	@Id
	private String Id;
    private String employeeId;
    private String counted;
    private List<WorkDetails> workDetails;
    

    
    
		

	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public List<WorkDetails> getWorkDetails() {
		return workDetails;
	}
	public void setWorkDetails(List<WorkDetails> workDetails) {
		this.workDetails = workDetails;
	}
	public String getCounted() {
		return counted;
	}
	public void setCounted(String counted) {
		this.counted = counted;
	}

	

    

}
