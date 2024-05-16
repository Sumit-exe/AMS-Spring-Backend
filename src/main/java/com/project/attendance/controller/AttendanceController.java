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
}