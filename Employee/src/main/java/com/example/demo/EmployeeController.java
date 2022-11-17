package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private WebClient.Builder webclient;
	
	ResponseData response = new ResponseData();

	@GetMapping("/{employeeId}")
	public ResponseEntity<ResponseData> getEmployeeDetails(@PathVariable("employeeId") Long employeeId){
		
		Employee e1 = new Employee();
		e1.setEmployeeId(1l);
		e1.setEmployeename("ssss");
		e1.setCompanyId(1l);
		
		response.setEmployee(e1);
		
		Company c1  = webclient.build()
		.get()
		.uri("http://localhost:8081/company/1")
		.retrieve()
		.bodyToMono(Company.class)
		.block();
		
		response.setCompany(c1);
		
		return new ResponseEntity<ResponseData>(response,HttpStatus.OK);
		
	}
}
