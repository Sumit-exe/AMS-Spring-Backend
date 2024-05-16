package com.project.attendance.service;
import com.project.attendance.model.Attendance;
import com.project.attendance.model.WorkDetails;

import java.util.List;



public interface AttendanceService {
	
	public abstract List<Attendance> getAllEmployeeAttendance();
	public abstract Attendance getEmployeeAttendanceById(String attendanceId);
	public abstract List<WorkDetails> getAllEmployeesByDates(String date);
//	public abstract List<Attendance> getAllAttendances();
//	public abstract Attendance getAttendanceById(String attendanceId);
//	

}
