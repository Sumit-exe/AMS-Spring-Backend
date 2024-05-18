package com.project.attendance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.attendance.model.Attendance;
import com.project.attendance.model.Employee;
import com.project.attendance.model.WorkDetails;
	


	@Repository
	public interface AttendanceRepository extends MongoRepository<Attendance, String> {
//		public abstract WorkDetails findByWorkDetailsDate();
		public abstract Optional<Attendance> findByEmployeeId(String employeeId);
		public abstract Optional<Attendance> deleteByEmployeeId(String employeeId);
		


}
