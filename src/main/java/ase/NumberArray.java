package ase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by Agnes on 11/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NumberArray {

    private int[] numbers;

    public NumberArray() {
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "NumberArray{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}
