package com.project.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.attendance.model.Employee;
import com.project.attendance.service.EmployeeService;
import com.project.attendance.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("emp")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping(path = "get-all-emps", produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmps() {
        List<Employee> empList = employeeService.getAllEmployees();
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "All employees data fetched successfully!");
        logger.info("Fetched all employees data");
        return new ResponseEntity<>(empList, headers, HttpStatus.OK);
    }

    @GetMapping("get-emp-by-id/{eid}")
    public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") String employeeId) {
        try {
            Employee employee = employeeService.getEmployeeById(employeeId);
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", "Employee data fetched successfully!");
            logger.info("Fetched employee data for ID: {}", employeeId);
            return new ResponseEntity<>(employee, headers, HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            logger.error("Employee not found for ID: {}", employeeId, e);
            HttpHeaders headers = new HttpHeaders();
            headers.add("error", "Employee not found");
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get-emp-by-name/{fname}")
    public ResponseEntity<List<Employee>> getEmpByName(@PathVariable(name = "fname") String employeeName) {
        List<Employee> empList = employeeService.getEmployeeByFullName(employeeName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Employees data fetched successfully!");
        logger.info("Fetched employees data for name: {}", employeeName);
        return new ResponseEntity<>(empList, headers, HttpStatus.OK);
    }

    @PostMapping(path = "add-emp", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
        Employee empToBeAdded = employeeService.addEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Employee added successfully!");
        logger.info("Added new employee with ID: {}", empToBeAdded.getEmployeeId());
        return new ResponseEntity<>(empToBeAdded, headers, HttpStatus.CREATED);
    }

    @PutMapping(path = "update-emp/{eid}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Employee> updateEmp(@PathVariable(name = "eid") String employeeId, @RequestBody Employee employee) {
        try {
            Employee existingEmployee = employeeService.getEmployeeById(employeeId);
            existingEmployee.setEmployeeFullName(employee.getEmployeeFullName());
            existingEmployee.setEmployeeEmail(employee.getEmployeeEmail());
            existingEmployee.setEmployeePhoneNo(employee.getEmployeePhoneNo());
            existingEmployee.setEmployeeAadhar(employee.getEmployeeAadhar());
            existingEmployee.setEmployeeAvatar(employee.getEmployeeAvatar());
            existingEmployee.setEmployeeTeamId(employee.getEmployeeTeamId());
            existingEmployee.setEmployeeTeamName(employee.getEmployeeTeamName());
            existingEmployee.setEmployeeIsManager(employee.getEmployeeIsManager());
            existingEmployee.setEmployeeManagerId(employee.getEmployeeManagerId());
            existingEmployee.setEmployeeManagerName(employee.getEmployeeManagerName());
            existingEmployee.setEmployeeRole(employee.getEmployeeRole());
            existingEmployee.setEmployeeIsAdmin(employee.getEmployeeIsAdmin());
            Employee updatedEmployee = employeeService.updateEmployee(existingEmployee);
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", "Employee updated successfully!");
            logger.info("Updated employee data for ID: {}", employeeId);
            return new ResponseEntity<>(updatedEmployee, headers, HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            logger.error("Employee not found for ID: {}", employeeId, e);
            HttpHeaders headers = new HttpHeaders();
            headers.add("error", "Employee not found");
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete-emp/{eid}")
    public ResponseEntity<Employee> deleteEmp(@PathVariable(name = "eid") String employeeId) {
        try {
            Employee employeeToBeDeleted = employeeService.deleteEmployee(employeeId);
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", "Employee deleted successfully!");
            logger.info("Deleted employee data for ID: {}", employeeId);
            return new ResponseEntity<>(employeeToBeDeleted, headers, HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            logger.error("Employee not found for ID: {}", employeeId, e);
            HttpHeaders headers = new HttpHeaders();
            headers.add("error", "Employee not found");
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get-emp-by-managerId/{eid}")
    public ResponseEntity<List<Employee>> getEmpByManagerId(@PathVariable(name = "eid") String employeeManagerId) {
        List<Employee> empList = employeeService.getEmployeesByManagerId(employeeManagerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Employees data fetched successfully!");
        logger.info("Fetched employees data for manager ID: {}", employeeManagerId);
        return new ResponseEntity<>(empList, headers, HttpStatus.OK);
    }

    @GetMapping("get-emp-by-teamId/{eid}")
    public ResponseEntity<List<Employee>> getEmpByTeamId(@PathVariable(name = "eid") String employeeTeamId) {
        List<Employee> empList = employeeService.getEmployeesByTeamId(employeeTeamId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Employees data fetched successfully!");
        logger.info("Fetched employees data for team ID: {}", employeeTeamId);
        return new ResponseEntity<>(empList, headers, HttpStatus.OK);
    }

    @GetMapping("get-emp-by-teamname/{tname}")
    public ResponseEntity<List<Employee>> getEmpByTeamName(@PathVariable(name = "tname") String employeeTeamName) {
        List<Employee> empList = employeeService.getEmployeesByTeamName(employeeTeamName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Employees data fetched successfully!");
        logger.info("Fetched employees data for team name: {}", employeeTeamName);
        return new ResponseEntity<>(empList, headers, HttpStatus.OK);
    }
}
