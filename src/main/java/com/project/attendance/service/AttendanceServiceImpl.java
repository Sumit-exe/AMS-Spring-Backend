package com.project.attendance.service;

import com.project.attendance.exception.EmployeeNotFoundException;
import com.project.attendance.model.Attendance;
import com.project.attendance.model.Employee;
import com.project.attendance.model.WorkDetails;
import com.project.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAllEmployeeAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getEmployeeAttendanceById(String attendanceId) {
        Optional<Attendance> attendanceOptional = attendanceRepository.findByEmpId(attendanceId);
        if (attendanceOptional.isEmpty()) {
            String errorMessage = "Employee with the id " + attendanceId + " is not found!";
            throw new EmployeeNotFoundException(errorMessage);
        } else {
            return attendanceOptional.get();
        }
    }

//    @Override
//    public List<WorkDetails> getAllEmployeesByDates() {
//        return (List<WorkDetails>) attendanceRepository.findByWorkDetailsDate();
//    }

	@Override
	public Attendance addAttendance(Attendance attendance) {
		 return attendanceRepository.save(attendance);
	}

	

	@Override
	public Attendance updateAttendance(Attendance attendance) {
		this.getEmployeeAttendanceById(attendance.getEmpId());
        return attendanceRepository.save(attendance);
        
       
	}

	@Override
	public Attendance deleteAttendance(String attendanceId) {
		Attendance attendanceToBeDeleted = this.getEmployeeAttendanceById(attendanceId);
        attendanceRepository.deleteById(attendanceId);
        return attendanceToBeDeleted;
	}

    
}
