package ase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by SYNYO on 13.10.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drone {

    private Integer rows;
    private Integer columns;

    public Drone() {
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "rows=" + rows +
                ", columns=" + columns +
                '}';
    }
}
