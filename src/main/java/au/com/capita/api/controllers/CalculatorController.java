package au.com.capita.api.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.capita.api.models.RequestInput;
import au.com.capita.api.models.ResponseStatus;

@RestController
//@RequestMapping(value="/user")
public class CalculatorController {

  
  @PostMapping(value="/calculate",consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE )
  public ResponseEntity<ResponseStatus> doCalculation(@RequestBody RequestInput input) {
	 String value =  input.getValue();
	  ResponseStatus respone = new ResponseStatus();
    try {
    	respone.setNumber("1263636");
    }
    catch(Exception ex) {
     System.out.println();
    }
  //return new User(101, "name");
  
    return new ResponseEntity(respone, HttpStatus.OK);
  }
  

} // class UserController
