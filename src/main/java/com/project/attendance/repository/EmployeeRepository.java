package com.project.attendance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.attendance.model.Attendance;
import com.project.attendance.model.Employee;
	


	@Repository
	public interface EmployeeRepository extends MongoRepository<Employee, String> {

	
<<<<<<< HEAD
//		public abstract List<Employee> findByFirstName(String empName);
=======
>>>>>>> 9df2e4db3c60c4ca8bd599f36c253d7be0f961fd
		public abstract Optional<Employee> findByEmployeeId(String employeeId);
		public abstract Optional<Employee> deleteByEmployeeId(String employeeId);
		public abstract List<Employee> findByEmployeeFullName(String employeeName);
		public abstract List<Employee> findByEmployeeManagerId(String employeeManagerId);
		public abstract List<Employee> findByEmployeeTeamId(String employeeTeamId);
		public abstract List<Employee> findByEmployeeTeamName(String employeeTeamName);
		
		


}
