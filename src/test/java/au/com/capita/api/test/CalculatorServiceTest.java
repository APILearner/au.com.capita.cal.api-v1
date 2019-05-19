package au.com.capita.api.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import au.com.capita.api.models.ResponseStatus;
import au.com.capita.api.service.CalculatorService;

//Only one test case implemented Need to implement error and exception scenario Test case and cover other classes

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {
	@Mock
	private CalculatorService service;

	@Before
	public void setUp() {
		ResponseEntity<ResponseStatus> response = new ResponseEntity<ResponseStatus>(HttpStatus.OK);
		Mockito.when(service.calculationOp((String) any())).thenReturn(response);
	}
	@Test
	public void testdoCalculation() {
		ResponseEntity<ResponseStatus> respons  = service.calculationOp("2+2");
		
		assertEquals(200, respons.getStatusCodeValue());
		
	}
}
