package com.project.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.attendance.exception.EmployeeNotFoundException;
import com.project.attendance.model.Attendance;
import com.project.attendance.model.Employee;
import com.project.attendance.model.WorkDetails;
import com.project.attendance.repository.AttendanceRepository;

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
		Optional<Attendance> AttOptional = attendanceRepository.findById(attendanceId);
		if (AttOptional.isEmpty()) {
            String errorMessage = "Employee with the id " + attendanceId + " is not found!";
            throw new EmployeeNotFoundException(errorMessage);
        } else {
            return AttOptional.get();
        }
    }


	@Override
	public List<WorkDetails> getAllEmployeesByDates(String date) {
		 WorkDetails attList = attendanceRepository.findByWorkDetailsDate(date);
		 return attList;
}
	
}



































//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AttendanceServiceImpl {
//
//    @Autowired
//    private AttendanceRepository attendanceRepository;
//
//    public List<Attendance> getAllAttendances() {
//        return attendanceRepository.findAll();
//    }
//
//    public Attendance getAttendanceById(String id) {
//        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
//        return optionalAttendance.orElse(null);
//    }
//
//    public Attendance addAttendance(Attendance attendance) {
//        return AttendanceRepository.save(attendance);
//    }
//
//    public Attendance updateAttendance(String id, Attendance updatedAttendance) {
//        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
//        if (optionalAttendance.isPresent()) {
//            updatedAttendance.setId(id); // Ensure the ID remains the same
//            return attendanceRepository.save(updatedAttendance);
//        }
//        return null; // Attendance with the given ID not found
//    }
//
//    public boolean deleteAttendance(String id) {
//        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
//        if (optionalAttendance.isPresent()) {
//            attendanceRepository.deleteById(id);
//            return true;
//        }
//        return false; // Attendance with the given ID not found
//    }
//
//    public WorkDetail addWorkDetail(String id, WorkDetail workDetail) {
//        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
//        if (optionalAttendance.isPresent()) {
//            Attendance attendance = optionalAttendance.get();
//            attendance.getWorkDetails().add(workDetail);
//            attendanceRepository.save(attendance);
//            return workDetail;
//        }
//        return null; // Attendance with the given ID not found
//    }
//
//    public WorkDetail updateWorkDetail(String empId, String workDetailId, WorkDetail updatedWorkDetail) {
//        Optional<Attendance> optionalAttendance = attendanceRepository.findById(empId);
//        if (optionalAttendance.isPresent()) {
//            Attendance attendance = optionalAttendance.get();
//            List<WorkDetail> workDetails = attendance.getWorkDetails();
//            for (WorkDetail wd : workDetails) {
//                if (wd.getId().equals(workDetailId)) {
//                    // Update the existing work detail
//                    updatedWorkDetail.setId(workDetailId); // Ensure the ID remains the same
//                    workDetails.remove(wd);
//                    workDetails.add(updatedWorkDetail);
//                    attendanceRepository.save(attendance);
//                    return updatedWorkDetail;
//                }
//            }
//        }
//        return null; // Either attendance with the given ID or work detail with the given ID not found
//    }
//
//    public boolean deleteWorkDetail(String empId, String workDetailId) {
//        Optional<Attendance> optionalAttendance = attendanceRepository.findById(empId);
//        if (optionalAttendance.isPresent()) {
//            Attendance attendance = optionalAttendance.get();
//            List<WorkDetail> workDetails = attendance.getWorkDetails();
//            for (WorkDetail wd : workDetails) {
//                if (wd.getId().equals(workDetailId)) {
//                    workDetails.remove(wd);
//                    attendanceRepository.save(attendance);
//                    return true;
//                }
//            }
//        }
//        return false; // Either attendance with the given ID or work detail with the given ID not found
//    }
//}
