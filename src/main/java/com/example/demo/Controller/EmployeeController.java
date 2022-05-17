package com.example.demo.Controller;


import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Employee;
import com.example.demo.ServiceInterface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employee")
    public List<Employee> getEmployee(){
        return this.employeeService.getAllEmployee();}
    @GetMapping("/employee/{email}")
    public  ResponseEntity<Employee> getEmployee(@PathVariable("email") String email){
        Employee employee1= this.employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(employee1);
    }
    @GetMapping("/employeeGT/{salary}")
    public   List<Employee> getEmployeeGTSalary(@PathVariable("salary") int salary){
        return this.employeeService.findEmployeeGTSalary(salary);
    }
    @PostMapping("/employee")
    public  ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employee1= this.employeeService.addEmployee(employee);
        return ResponseEntity.ok(employee1);

    }
    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employee1= this.employeeService.updateEmployee(employee);
        return ResponseEntity.ok(employee1);

    }
    @DeleteMapping(path="/employee/{email}")
    public String deleteEmployee(@PathVariable("email") String email){
         this.employeeService.deleteEmployee(email);
         return "employee deleted";
    }




}
