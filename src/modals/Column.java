package modals;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Column {
    //Each column contains cells, where col : same, row: changes
    private Map<Integer, Cell> cells;
    private final String colId;

    public Column(String colId) {
        this.colId = colId;
    }

    public String getColId() {
        return colId;
    }

    public Map<Integer, Cell> getCells() {
        return cells;
    }

    public void setCells(Map<Integer, Cell> cells) {
        this.cells = cells;
    }

    public void setCell(int rowIdx, Cell cell) {
        cells.put(rowIdx, cell);
    }

    public Cell getCell(int rowIdx) {
        return cells.get(rowIdx);
    }

}
