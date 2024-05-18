package com.project.attendance.service;

import com.project.attendance.exception.EmployeeNotFoundException;
import com.project.attendance.model.Employee;
import com.project.attendance.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        LOG.info("getAllEmployees");
        List<Employee> empList = employeeRepository.findAll();
        if (empList.isEmpty()) {
            String errorMessage = "The Employee List is empty";
            LOG.warn(errorMessage);
            throw new EmployeeNotFoundException(errorMessage);
        } else {
            return empList;
        }
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }

        Optional<Employee> empOptional = employeeRepository.findByEmployeeId(employeeId);
        if (empOptional.isEmpty()) {
            String errorMessage = "Employee with the ID " + employeeId + " is not found!";
            LOG.warn(errorMessage);
            throw new EmployeeNotFoundException(errorMessage);
        } else {
            return empOptional.get();
        }
    }

    @Override
    public List<Employee> getEmployeeByFullName(String employeeName) {
        LOG.info(employeeName);
        List<Employee> empList = employeeRepository.findByEmployeeFullName(employeeName);
        if (empList.isEmpty()) {
            String errorMessage = "Employee with name " + employeeName + " is not found!";
            LOG.warn(errorMessage);
            throw new EmployeeNotFoundException(errorMessage);
        }
        return empList;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee object cannot be null");
        }

        LOG.info(employee.toString());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee object cannot be null");
        }

        LOG.info(employee.toString());
        String employeeId = employee.getEmployeeId();
        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }

        // Check if the employee exists
        getEmployeeById(employeeId);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee deleteEmployee(String employeeId) {
        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }

        LOG.info(employeeId);
        Employee employeeToBeDeleted = getEmployeeById(employeeId);
        employeeRepository.deleteByEmployeeId(employeeId);
        return employeeToBeDeleted;
    }

    @Override
    public List<Employee> getEmployeesByManagerId(String employeeManagerId) {
        if (employeeManagerId == null || employeeManagerId.isEmpty()) {
            throw new IllegalArgumentException("Manager ID cannot be null or empty");
        }

        List<Employee> employeeList = employeeRepository.findByEmployeeManagerId(employeeManagerId);
        if (employeeList.isEmpty()) {
            String errorMessage = "Employee with manager ID " + employeeManagerId + " is not found!";
            LOG.warn(errorMessage);
            throw new EmployeeNotFoundException(errorMessage);
        }
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByTeamId(String employeeTeamId) {
        if (employeeTeamId == null || employeeTeamId.isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
        }

        List<Employee> employeeList = employeeRepository.findByEmployeeTeamId(employeeTeamId);
        if (employeeList.isEmpty()) {
            String errorMessage = "Employee with team ID " + employeeTeamId + " is not found!";
            LOG.warn(errorMessage);
            throw new EmployeeNotFoundException(errorMessage);
        }
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByTeamName(String employeeTeamName) {
        if (employeeTeamName == null || employeeTeamName.isEmpty()) {
            throw new IllegalArgumentException("Team Name cannot be null or empty");
        }

        LOG.info(employeeTeamName);
        List<Employee> empList = employeeRepository.findByEmployeeTeamName(employeeTeamName);
        if (empList.isEmpty()) {
            String errorMessage = "Employee with team name " + employeeTeamName + " is not found!";
            LOG.warn(errorMessage);
            throw new EmployeeNotFoundException(errorMessage);
        }
        return empList;
    }
}
