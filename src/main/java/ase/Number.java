package ase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Agnes on 10/10/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Number {

    private Integer number;

    public Number() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
