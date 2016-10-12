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
    public ResponseEntity<Variables> invert(@RequestBody Variables variables
    ) {

        Variables vars = new Variables();
        int newA = variables.getB();
        int newB = variables.getA();
        vars.setA(newA);
        vars.setB(newB);

        return new ResponseEntity<Variables>(vars, HttpStatus.OK);
    }
}
