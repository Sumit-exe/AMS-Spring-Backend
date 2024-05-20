package com.project.attendance.service;

import com.project.attendance.exception.EmployeeNotFoundException;
import com.project.attendance.model.Attendance;
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
        Optional<Attendance> attendanceOptional = attendanceRepository.findByEmployeeId(attendanceId);
        if (attendanceOptional.isEmpty()) {
            String errorMessage = "Employee with the id " + attendanceId + " is not found!";
            throw new EmployeeNotFoundException(errorMessage);
        } else {
            return attendanceOptional.get();
        }
    }
    

    @Override
    public Attendance addAttendance(Attendance attendance) {
        if (attendance == null) {
            throw new IllegalArgumentException("Attendance object cannot be null");
        }

        return attendanceRepository.save(attendance);
    }
    
//    @Override
//    public Attendance addWorkDetails(String employeeId, WorkDetails workDetails) {
//        Optional<Attendance> attendance = attendanceRepository.findByEmployeeId(employeeId);
//        if (attendance != null) {
//            attendance.getWorkDetails().add(workDetails);
//            return attendanceRepository.save(attendance);
//        }
//        return null;
//    }
//    

    @Override
    public Attendance updateAttendance(Attendance attendance) {
        if (attendance == null) {
            throw new IllegalArgumentException("Attendance object cannot be null");
        }

        if (attendance.getEmployeeId() == null || attendance.getEmployeeId().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
        getEmployeeAttendanceById(attendance.getEmployeeId());

        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance deleteAttendance(String attendanceId) {
        if (attendanceId == null || attendanceId.isEmpty()) {
            throw new IllegalArgumentException("Attendance ID cannot be null or empty");
        }

        Attendance attendanceToBeDeleted = getEmployeeAttendanceById(attendanceId);
        attendanceRepository.deleteByEmployeeId(attendanceId);
        return attendanceToBeDeleted;
    }

	@Override
	 public Attendance addWorkDetails(String employeeId, WorkDetails workDetails) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findByEmployeeId(employeeId);
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            attendance.getWorkDetails().add(workDetails);
            return attendanceRepository.save(attendance);
        } else {
            // Handle the case where the attendance record is not found
            throw new RuntimeException("Attendance record not found for employee ID: " + employeeId);
        }
    }
}
