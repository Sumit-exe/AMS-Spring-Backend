package com.project.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.attendance.model.Attendance;
import com.project.attendance.model.Employee;
import com.project.attendance.model.WorkDetails;
import com.project.attendance.service.AttendanceService;

@RestController
@RequestMapping("att")
@CrossOrigin("*")
public class AttendanceController {
	@Autowired
	AttendanceService attendanceService;
	
	@GetMapping(path = "get-all-att", produces = "application/json")
	public ResponseEntity<List<Attendance>> getAllAtt() {
		List<Attendance> attList = attendanceService.getAllEmployeeAttendance();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All attendances data fetched successfully!");
		ResponseEntity<List<Attendance>> response = new ResponseEntity<List<Attendance>>(attList, headers, status);
		return response;
	}

	@GetMapping("get-att-by-id/{eid}")
	public ResponseEntity<Attendance> getAttById(@PathVariable(name = "eid") String attendanceId){
		Attendance attendance = attendanceService.getEmployeeAttendanceById(attendanceId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Attendance data fetched successfully!");
		ResponseEntity<Attendance> response = new ResponseEntity<Attendance>(attendance, headers, status);
		return response;
		}
	
  
//    @GetMapping(path = "get-all-dates", produces = "application/json")
//	public ResponseEntity<List<WorkDetails>> getAllEmployeesByDates() {
//		List<WorkDetails> attList = attendanceService.getAllEmployeesByDates();
//		HttpStatus status = HttpStatus.OK;
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "All attendances data fetched successfully!");
//		ResponseEntity<List<WorkDetails>> response = new ResponseEntity<List<WorkDetails>>(attList, headers, status);
//		return response;
//		
//    }		
//		
	@PostMapping(path = "add-att", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Attendance> addAtt(@RequestBody Attendance attendance){
		Attendance attToBeAdded = attendanceService.addAttendance(attendance);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Attendance> response = new ResponseEntity<Attendance>(attToBeAdded, headers,  HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping(path = "update-att/{eid}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Attendance> updateAtt(@PathVariable(name = "eid") String employeeId,@RequestBody Attendance attendance) {
		Attendance existingAttendance = attendanceService.getEmployeeAttendanceById(employeeId);
<<<<<<< HEAD
		existingAttendance.setEmployeeId(attendance.getEmployeeId());
=======
		existingAttendance.setId(attendance.getId());
		existingAttendance.setEmployeeId(attendance.getEmployeeId());
		existingAttendance.setCounted(attendance.getCounted());
>>>>>>> 9df2e4db3c60c4ca8bd599f36c253d7be0f961fd
		existingAttendance.setWorkDetails(attendance.getWorkDetails());
		Attendance updatedAttendance = attendanceService.updateAttendance(existingAttendance);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee updated successfully!");
		ResponseEntity<Attendance> response = new ResponseEntity<Attendance>(updatedAttendance, headers, status);
		return response;
	}
<<<<<<< HEAD
     
=======
    
>>>>>>> 9df2e4db3c60c4ca8bd599f36c253d7be0f961fd
	@DeleteMapping("delete-att/{eid}")
	public ResponseEntity<Attendance> deleteAtt(@PathVariable(name = "eid") String employeeId) {
		Attendance attendanceToBeDeleted = attendanceService.deleteAttendance(employeeId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee attendnace Deleted successfully!");
		ResponseEntity<Attendance> response = new ResponseEntity<Attendance>(attendanceToBeDeleted, headers, status);
		return response;
	}
    
}