package com.example.demo;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Employee;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;


@SpringBootApplication
public class DemoApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private AddressRepository addressRepository;




	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();
		addressRepository.deleteAll();

		// save a couple of customers
//		repository.save(new Employee("Alice", "Smith"));
//		repository.save(new Employee("Bob", "Smith"));
		Address address=new Address("Upper Street","carmel","indiana","46032");
		addressRepository.save(address);
		Employee employee=new Employee("hana","alnuzhah",address,"hanaalnuzha@gmail.com","1234","123321",600,new Date());
		repository.save(employee);
		// fetch all customers
		System.out.println("Employees found with findAll():");
		System.out.println("------------------------"+repository.findByEmail(employee.email));
		for (Employee employee1 : repository.findAll()) {
			System.out.println(employee1);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Employee customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}

}
