package au.com.capita.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.capita.api.dto.CompanyDto;
import au.com.capita.api.models.RequestInput;
import au.com.capita.api.models.ResponseStatus;
import au.com.capita.api.service.CalculatorService;


//Need to implement Logger and the code can be more generic
@RestController
public class CalculatorController {
	@Autowired
	private CalculatorService service;

	@PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStatus> doCalculation(@RequestBody RequestInput input) {
		String value = input.getValue();
		ResponseEntity<ResponseStatus> respone= null;
		try {
			respone = service.calculationOp(value);
		} catch (Exception ex) {
			//loger impl
		}
		return new ResponseEntity(respone, HttpStatus.OK);
	}

	@PostMapping(value = "/jackson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStatus> doCalculation(@RequestBody CompanyDto companyDto) {
		
		
		System.out.println();
		ResponseEntity<ResponseStatus> respone= null;
		
		System.out.println(companyDto);
		try {
			//respone = service.calculationOp(companyDto);
		} catch (Exception ex) {
			//loger impl
		}
		return new ResponseEntity(respone, HttpStatus.OK);
	}
} 
