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
public class VariablesClient {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Solution> sum(@RequestBody Variables variables
    ) {

        Solution solution = new Solution();
        int sum = variables.getA() + variables.getB();
        solution.setSolution(sum);

        return new ResponseEntity<Solution>(solution, HttpStatus.OK);
    }
}
