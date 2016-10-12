package ase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Agnes on 10/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Solution {

    private Integer solution;

    public Solution() {
    }

    public Integer getSolution() {
        return solution;
    }

    public void setSolution(Integer solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "solution=" + solution +
                '}';
    }
}
