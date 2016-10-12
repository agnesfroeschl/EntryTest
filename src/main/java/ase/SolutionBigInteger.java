package ase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;

/**
 * Created by Agnes on 12/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SolutionBigInteger {

    private BigInteger solution;

    public SolutionBigInteger() {
    }

    public BigInteger getSolution() {
        return solution;
    }

    public void setSolution(BigInteger solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "SolutionBigInteger{" +
                "solution=" + solution +
                '}';
    }
}
