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
public class NumberArrayClient {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Solution> sum(@RequestBody NumberArray numbers
    ) {

        Solution solution = new Solution();
        int[] values = numbers.getNumbers();
        Integer sum = 0;
        for (int number : values) {
            sum += number;
        }
        solution.setSolution(sum);

        return new ResponseEntity<Solution>(solution, HttpStatus.OK);
    }
}
