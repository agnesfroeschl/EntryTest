package ase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Agnes on 12/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Operations {

    private BigInteger[] numbers;
    private String operator;


    public BigInteger[] getNumbers() {
        return numbers;
    }

    public void setNumbers(BigInteger[] numbers) {
        this.numbers = numbers;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Operations() {

    }

    @Override
    public String toString() {
        return "Operations{" +
                "numbers=" + Arrays.toString(numbers) +
                ", operator='" + operator + '\'' +
                '}';
    }
}
