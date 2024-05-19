package com.project.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.attendance.model.Attendance;
import com.project.attendance.service.AttendanceService;
import com.project.attendance.exception.AttendanceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("att")
@CrossOrigin("*")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @GetMapping(path = "get-all-att", produces = "application/json")
    public ResponseEntity<List<Attendance>> getAllAtt() {
        List<Attendance> attList = attendanceService.getAllEmployeeAttendance();
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "All attendances data fetched successfully!");
        logger.info("Fetched all attendances data");
        return new ResponseEntity<>(attList, headers, HttpStatus.OK);
    }

    @GetMapping("get-att-by-id/{eid}")
    public ResponseEntity<Attendance> getAttById(@PathVariable(name = "eid") String attendanceId) {
        try {
            Attendance attendance = attendanceService.getEmployeeAttendanceById(attendanceId);
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", "Attendance data fetched successfully!");
            logger.info("Fetched attendance data for ID: {}", attendanceId);
            return new ResponseEntity<>(attendance, headers, HttpStatus.OK);
        } catch (AttendanceNotFoundException e) {
            logger.error("Attendance not found for ID: {}", attendanceId, e);
            HttpHeaders headers = new HttpHeaders();
            headers.add("error", "Attendance not found");
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "add-att", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Attendance> addAtt(@RequestBody Attendance attendance) {
        Attendance attToBeAdded = attendanceService.addAttendance(attendance);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Attendance added successfully!");
        return new ResponseEntity<>(attToBeAdded, headers, HttpStatus.CREATED);
    }

    @PutMapping(path = "update-att/{eid}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Attendance> updateAtt(@PathVariable(name = "eid") String attendanceId, @RequestBody Attendance attendance) {
        try {
            Attendance existingAttendance = attendanceService.getEmployeeAttendanceById(attendanceId);
            existingAttendance.setEmployeeId(attendance.getEmployeeId());
            existingAttendance.setWorkDetails(attendance.getWorkDetails());
            Attendance updatedAttendance = attendanceService.updateAttendance(existingAttendance);
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", "Attendance updated successfully!");
            logger.info("Updated attendance data for ID: {}", attendanceId);
            return new ResponseEntity<>(updatedAttendance, headers, HttpStatus.OK);
        } catch (AttendanceNotFoundException e) {
            logger.error("Attendance not found for ID: {}", attendanceId, e);
            HttpHeaders headers = new HttpHeaders();
            headers.add("error", "Attendance not found");
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete-att/{eid}")
    public ResponseEntity<Attendance> deleteAtt(@PathVariable(name = "eid") String attendanceId) {
        try {
            Attendance attendanceToBeDeleted = attendanceService.deleteAttendance(attendanceId);
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", "Attendance deleted successfully!");
            logger.info("Deleted attendance data for ID: {}", attendanceId);
            return new ResponseEntity<>(attendanceToBeDeleted, headers, HttpStatus.OK);
        } catch (AttendanceNotFoundException e) {
            logger.error("Attendance not found for ID: {}", attendanceId, e);
            HttpHeaders headers = new HttpHeaders();
            headers.add("error", "Attendance not found");
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
    }
}
