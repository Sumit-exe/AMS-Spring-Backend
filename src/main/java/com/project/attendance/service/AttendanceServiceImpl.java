package com.project.attendance.service;

import com.project.attendance.exception.EmployeeNotFoundException;
import com.project.attendance.model.Attendance;
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
}
