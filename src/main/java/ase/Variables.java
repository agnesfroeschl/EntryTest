package ase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Agnes on 12/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variables {

    private Integer a;
    private Integer b;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Variables() {

    }

    @Override
    public String toString() {
        return "Variables{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
