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
public class DroneClientExtended {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<SolutionArray> move(@RequestBody Drone drone) {

        SolutionArray solution = new SolutionArray();
        int rows = 3;
        int columns = 4;
        int startRow = 3;
        int startColumn = 4;
        Integer[] parcelOrder = new Integer[rows * columns];
        int index = 0;
        //up-left
        if (startColumn == 1 && startRow == 1) {
            for (int i = 1; i <= rows; i++) {
                int val = i * columns;
                if (i % 2 != 0) {
                    for (int j = index + 1; j <= val; j++) {
                        parcelOrder[index] = j;
                        index++;
                    }
                } else if (i % 2 == 0) {
                    for (int j = val; j > (index - columns); j--) {
                        parcelOrder[index] = j;
                        index++;
                    }
                }
            }
        }
        //down-left
        if (startColumn == 1 && startRow == rows) {
            for (int i = rows; i >= 1; i--) {
                if (i % 2 != 0) {
                    int val = (i * columns)-columns+1;
                    for (int j = val; j < val+columns; j++) {
                        parcelOrder[index] = j;
                        index++;
                    }
                } else if (i % 2 == 0) {
                    int val = (i * columns);
                    for (int j = val; j > (index - columns); j--) {
                        parcelOrder[index] = j;
                        index++;
                    }
                }
            }
        }
        //up-right
        if (startColumn == columns && startRow == 1) {
            for (int i = 1; i <= rows; i++) {
                int val = i * columns;
                if (i % 2 == 0) {
                    for (int j = index + 1; j <= val; j++) {
                        parcelOrder[index] = j;
                        index++;
                    }
                } else if (i % 2 != 0) {
                    for (int j = val; j > (index - columns); j--) {
                        parcelOrder[index] = j;
                        index++;
                    }
                }
            }
        }
        //down-right
        if (startColumn == columns && startRow == rows) {
            for (int i = rows; i >= 1; i--) {
                if (i % 2 == 0) {
                    int val = (i * columns)-columns+1;
                    for (int j = val; j < val+columns; j++) {
                        parcelOrder[index] = j;
                        index++;
                    }
                } else if (i % 2 != 0) {
                    int val = (i * columns);
                    for (int j = val; j > (val-columns); j--) {
                        parcelOrder[index] = j;
                        index++;
                    }
                }
            }
        }

        solution.setSolution(parcelOrder);

        return new ResponseEntity<SolutionArray>(solution, HttpStatus.OK);
    }
}
