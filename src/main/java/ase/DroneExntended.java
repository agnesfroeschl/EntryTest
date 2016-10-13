package ase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by SYNYO on 13.10.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DroneExntended {

    private Integer rows;
    private Integer columns;
    private Integer startRow;
    private Integer startColumn;

    public DroneExntended() {
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

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(Integer startColumn) {
        this.startColumn = startColumn;
    }

    @Override
    public String toString() {
        return "DroneExntended{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", startRow=" + startRow +
                ", startColumn=" + startColumn +
                '}';
    }
}
