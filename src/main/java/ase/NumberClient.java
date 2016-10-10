package ase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Agnes on 10/10/16.
 */
@RestController
public class NumberClient {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Solution> invert(@RequestBody Number number
    ) {
        int newNumber = number.getNumber() * -1;
        Solution solution = new Solution();
        solution.setSolution(newNumber);
        return new ResponseEntity<Solution>(solution, HttpStatus.OK);
    }

}
