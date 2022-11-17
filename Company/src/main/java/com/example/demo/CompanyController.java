package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/company")
public class CompanyController{


	@GetMapping("/{companyId}")
	public ResponseEntity<Company> getCompanyDetails(@PathVariable("companyId") Long companyid){
		
		Company c1 = new Company();
		c1.setCompanyid(1l);
		c1.setCompanyname("abc");
		
		Long collegeId = c1.getCompanyid();
	
		return new ResponseEntity<Company>(c1,HttpStatus.OK);
		
		
		
	}
}