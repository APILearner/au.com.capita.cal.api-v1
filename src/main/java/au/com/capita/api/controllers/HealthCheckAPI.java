package au.com.capita.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.capita.api.models.ResponseStatus;

@RestController
public class HealthCheckAPI {

  @GetMapping("/healthCheck")
  public ResponseEntity<ResponseStatus> getStatus() {
	  ResponseStatus respone = new ResponseStatus();
	  respone.setStatus("SUCCESS");
      return new ResponseEntity<>(respone, HttpStatus.OK);
  }

}
