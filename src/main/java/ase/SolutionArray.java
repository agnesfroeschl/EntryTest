package ase;

import java.util.Arrays;

/**
 * Created by SYNYO on 13.10.2016.
 */
public class SolutionArray {

    private Integer[] solution;

    public SolutionArray() {
    }

    public Integer[] getSolution() {
        return solution;
    }

    public void setSolution(Integer[] solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "SolutionArray{" +
                "solution=" + Arrays.toString(solution) +
                '}';
    }
}
