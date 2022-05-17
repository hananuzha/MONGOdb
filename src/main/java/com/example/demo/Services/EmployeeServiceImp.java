package com.example.demo.Services;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.ServiceInterface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();

    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        Optional<Employee> employee =this.employeeRepository.findByEmail(email);
        if(employee.isPresent())
            return employee.get();
        else {
            throw new IllegalStateException("user with id " + email + "does  not exist");
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return  employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String email) {
         employeeRepository.deleteByEmail(email);
    }

    @Override
    public List<Employee> findEmployeeGTSalary(int salary) {
        return employeeRepository.findWithCondition(salary);
    }
}
