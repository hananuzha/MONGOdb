package com.example.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document
public class Employee {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    @DocumentReference
    public Address Address;
    @Indexed(name = "email_index", direction = IndexDirection.DESCENDING,unique = true)
    public String email;
    public String  password;
    public String mobile;
    public int salary;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date hireDate;


    public Employee(String firstName, String lastName, com.example.demo.Entity.Address address, String email, String password, String mobile, int salary, Date hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = address;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Employee() {
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getId() {
        return id;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address address) {
        this.Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Address=" + Address +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}