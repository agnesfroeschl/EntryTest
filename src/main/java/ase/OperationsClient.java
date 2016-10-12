package ase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Agnes on 12/10/16.
 */
@RestController
public class OperationsClient {

    private int[] values;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Solution> calc(@RequestBody Operations var
    ) {
        Solution solution = new Solution();

        values = var.getNumbers();
        String operator = var.getOperator();
        Integer result = 0;
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
        return new ResponseEntity<Solution>(solution, HttpStatus.OK);
    }

    private Integer sub() {
        Integer result = 0;
        for (int number : values) {
            result -= number;
        }
        return result;
    }

    private Integer sum() {
        Integer result = 0;
        for (int number : values) {
            result += number;
        }
        return result;
    }

    private Integer multi() {
        Integer result = 0;
        for (int number : values) {
            result *= number;
        }
        return result;
    }
}
