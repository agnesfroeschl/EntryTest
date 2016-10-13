package ase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SYNYO on 13.10.2016.
 */
@RestController
public class DroneClient {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<SolutionArray> move(@RequestBody Drone drone) {

        SolutionArray solution = new SolutionArray();
        int rows = 15;
        int columns = 19;
        Integer[] parcelOrder = new Integer[rows*columns];
        int index = 0;
        for (int i = 1; i <= rows; i++) {
            int val = i * columns;
            if (i % 2 != 0) {
                for(int j = index+1; j <= val; j++){
                    parcelOrder[index] = j;
                    index++;
                }
            } else if (i % 2 == 0) {
                for(int j = val; j > (index-columns); j--){
                    parcelOrder[index] = j;
                    index++;
                }
            }
        }
        solution.setSolution(parcelOrder);

        return new ResponseEntity<SolutionArray>(solution, HttpStatus.OK);
    }
}
