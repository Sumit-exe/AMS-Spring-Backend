package com.project.attendance.service;

import com.project.attendance.model.Attendance;
import com.project.attendance.model.Employee;
import com.project.attendance.model.WorkDetails;

import java.util.List;

public interface AttendanceService {

    public abstract List<Attendance> getAllEmployeeAttendance();
    
    public abstract Attendance getEmployeeAttendanceById(String employeeId);
    
//    public abstract List<WorkDetails> getAllEmployeesByDates();
    
    public abstract Attendance addAttendance(Attendance attendance);

	public abstract Attendance updateAttendance(Attendance attendance);

	public abstract Attendance deleteAttendance(String attendanceId);
    
}
