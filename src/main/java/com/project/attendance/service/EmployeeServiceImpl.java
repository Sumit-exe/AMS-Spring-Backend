
package com.project.attendance.service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.attendance.exception.EmployeeNotFoundException;
import com.project.attendance.model.Employee;
import com.project.attendance.repository.EmployeeRepository;
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
        Optional<Employee> empOptional = employeeRepository.findByEmployeeId(employeeId);
        if (empOptional.isEmpty()) {
            String errorMessage = "Employee with the id " + employeeId + " is not found!";
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
        LOG.info(employee.toString());
        return employeeRepository.save(employee);
    }
    @Override
    public Employee updateEmployee(Employee employee) {
        LOG.info(employee.toString());
        this.getEmployeeById(employee.getEmployeeId());
        return employeeRepository.save(employee);
    }
    @Override
    public Employee deleteEmployee(String employeeId) {
        LOG.info(employeeId);
        Employee employeeToBeDeleted = this.getEmployeeById(employeeId);
        employeeRepository.deleteByEmployeeId(employeeId);
        return employeeToBeDeleted;
    }
    @Override
    public List<Employee> getEmployeesByManagerId(String employeeManagerId) {
        List<Employee> employeeList = employeeRepository.findByEmployeeManagerId(employeeManagerId);
        if (employeeList.isEmpty()) {
            String errorMessage = "Employee with manager id " + employeeManagerId + " is not found!";
            LOG.warn(errorMessage);
            throw new EmployeeNotFoundException(errorMessage);
        }
        return employeeList;
    }
    @Override
    public List<Employee> getEmployeesByTeamId(String employeeTeamId) {
        List<Employee> employeeList = employeeRepository.findByEmployeeTeamId(employeeTeamId);
        if (employeeList.isEmpty()) {
            String errorMessage = "Employee with team id " + employeeTeamId + " is not found!";
            LOG.warn(errorMessage);
            throw new EmployeeNotFoundException(errorMessage);
        }
        return employeeList;
    }
    @Override
    public List<Employee> getEmployeesByTeamName(String employeeTeamName) {
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








































