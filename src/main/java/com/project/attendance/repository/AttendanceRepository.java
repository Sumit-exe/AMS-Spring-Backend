package com.project.attendance.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.attendance.model.Attendance;

	


	@Repository
	public interface AttendanceRepository extends MongoRepository<Attendance, String> {
//		public abstract WorkDetails findByWorkDetailsDate();
		public abstract Optional<Attendance> findByEmployeeId(String empId);
		public abstract Attendance deleteByEmployeeId(String empId);
		


}
