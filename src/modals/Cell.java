package modals;

public class Cell {
    int rowId;
    String colId;
    String value;

    public Cell(int rowId, String colId) {
        this.rowId = rowId;
        this.colId = colId;
        this.value = "null";
    }

    public String getColId() {
        return colId;
    }

    public int getRowId() {
        return rowId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setColId(String colId) {
        this.colId = colId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public Cell getCell() {
        return this;
    }
}
