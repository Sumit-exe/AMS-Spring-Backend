package com.project.attendance.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "attendances")
public class Attendance {
    
	@Id
	private String id;
    private String employeeId;
    private List<WorkDetails> workDetails;
    
    
	public Attendance() {
		super();

	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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



	@Override
	public String toString() {
		return "Attendance [id=" + id + ", employeeId=" + employeeId + ", workDetails=" + workDetails + "]";
	}

	

    

}
