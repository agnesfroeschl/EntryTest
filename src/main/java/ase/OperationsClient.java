package ase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * Created by Agnes on 12/10/16.
 */
@RestController
public class OperationsClient {

    private BigInteger[] values;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<SolutionBigInteger> calc(@RequestBody Operations var
    ) {
        SolutionBigInteger solution = new SolutionBigInteger();

        values = var.getNumbers();
        String operator = var.getOperator();
        BigInteger result = null;
        if(operator.equals("+")){
            result = sum();
        }
        if(operator.equals("-")){
            result = sub();
        }
        if(operator.equals("*")){
            result = multi();
        }

        solution.setSolution(result);
        return new ResponseEntity<SolutionBigInteger>(solution, HttpStatus.OK);
    }

    private BigInteger sub() {
        BigInteger result = values[0];
        for(int i = 1; i < values.length; i++){
           result = result.subtract(values[i]);
        }
        return result;
    }

    private BigInteger sum() {
        BigInteger result = values[0];
        for(int i = 1; i < values.length; i++){
            result = result.add(values[i]);
        }
        return result;
    }

    private BigInteger multi() {
        BigInteger result = values[0];
        for(int i = 1; i < values.length; i++){
            result = result.multiply(values[i]);
        }
        return result;
    }
}
