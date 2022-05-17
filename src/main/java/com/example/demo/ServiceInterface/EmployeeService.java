package com.example.demo.ServiceInterface;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeByEmail(String id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(String email);
    List<Employee> findEmployeeGTSalary(int salary);
}
