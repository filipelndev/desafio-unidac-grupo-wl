package br.com.unidac.cafedamanha.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.unidac.cafedamanha.entitie.Employee;
import br.com.unidac.cafedamanha.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee.getName(), employee.getCpf(), employee.getBreakfastOptions(), employee.getBreakfastDate());
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee.getId(), employee.getName(), employee.getCpf(), employee.getBreakfastOptions(), employee.getBreakfastDate());
        return employee;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }
    

}