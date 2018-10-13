package au.com.capita.api.service;

import org.springframework.http.ResponseEntity;

import au.com.capita.api.models.ResponseStatus;

public interface ICalculatorService {

	ResponseEntity<ResponseStatus> calculationOp(String value);
}
