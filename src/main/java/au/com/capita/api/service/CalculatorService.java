package au.com.capita.api.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import au.com.capita.api.models.ResponseStatus;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


@Service
public class CalculatorService implements ICalculatorService {

	@Override
	public ResponseEntity<ResponseStatus> calculationOp(String inputstring) {
		ResponseStatus responseStatus = new ResponseStatus();
		// Need to check the regular expression. For now it is passing (()) also
		String regex = "^[\\d\\(]+[\\d\\+\\-\\*\\/\\(\\)]+[\\d\\)]+$";
		Expression exp = null;
		Pattern p = Pattern.compile(regex);
		try {
			Matcher matcher = p.matcher(inputstring);
		
		exp = new ExpressionBuilder(inputstring).build();
		} catch (Exception ex) {
			//Logger Severe
						responseStatus.setStatus("INVALID EXPRESSION");//Need to create Constant String Enum type
						return new ResponseEntity<ResponseStatus>(responseStatus, HttpStatus.BAD_REQUEST);
					}
		double val = exp.evaluate();
		String resultVal = Double.toString(val);
		responseStatus.setNumber(resultVal);
		return new ResponseEntity<ResponseStatus>(responseStatus, HttpStatus.OK);
	}

}