package com.project.attendance.exception;

public class AttendanceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AttendanceNotFoundException(String message) {
        super(message);
    }

    public AttendanceNotFoundException() {
        super("Attendance not found");
    }
}
