package modals;

import java.util.Map;

public class Row {
    private Map<String, Cell> record;
    private final int rowId;

    public Row(int rowId) {
        this.rowId = rowId;
    }

    public int getRowId() {
        return rowId;
    }

    public Map<String, Cell> getRecord() {
        return record;
    }

    public void setRecord(Map<String, Cell> record) {
        this.record = record;
    }

    public void setCell(String colIdx, Cell cell) {
        record.put(colIdx, cell);
    }

    public Cell getCell(String colIdx) {
        return record.get(colIdx);
    }
}
