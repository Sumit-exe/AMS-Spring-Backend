package com.project.attendance.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "attendances")
public class Attendance {
    
    private String id;
    private String empId;
    private List<WorkDetails> workDetails;
    
    
		

	
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public List<WorkDetails> getWorkDetails() {
		return workDetails;
	}
	public void setWorkDetails(List<WorkDetails> workDetails) {
		this.workDetails = workDetails;
	}

    @Override
	public String toString() {
		return "Attendance [id=" + id + ", empId=" + empId + ", workDetails=" + workDetails + "]";
    
}

}
