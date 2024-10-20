package modals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sheet {
    private List<Row> rows;
    private List<Column> cols;
    private int currentRow;
    private char currentCol;
    private HashMap<String, Cell> allCells;
    private HashMap<Integer, List<Cell>> cellByRow;
    private HashMap<String, List<Cell>> cellByCol;

    public Sheet() {
        this.rows = new ArrayList<>();
        this.cols = new ArrayList<>();
        currentRow = 0;
        currentCol = 'A';
        createRows();
        createCols();
        allCells = createCells();
        cellByRow = new HashMap<>();
        cellByCol = new HashMap<>();
        createCellMapByRowAndCol();
        for(Row row : rows) {
            int rowIdx = row.getRowId();
            Map<String, Cell> records = cellByRow.get(rowIdx).stream().collect(Collectors.toMap(it -> it.colId, Cell::getCell));
            row.setRecord(records);
        }
        for(Column col : cols) {
            String colIdx = col.getColId();
            Map<Integer, Cell> records = cellByCol.get(colIdx).stream().collect(Collectors.toMap(it -> it.getRowId(), Cell::getCell));
            col.setCells(records);
        }
    }

    //Assuming on creating sheet, we will have 10 rows, 26 cols.
    public void createRows() {
        int maxRows = 10;
        while(currentRow < maxRows) {
            rows.add(new Row(currentRow));
            currentRow++;
        }
    }

    public void createCols() {
        int maxCols = 25;
        while(currentCol < ('A' + maxCols)) {
            cols.add(new Column(String.valueOf(currentCol)));
            currentCol = (char) ((char) currentCol + 1);
        }
    }

    public HashMap<String, Cell> createCells() {
        HashMap<String, Cell> cells = new HashMap<>();
        for (Row row : rows) {
            for (Column col : cols) {
                String colIdx = col.getColId();
                int rowIdx = row.getRowId();
                cells.put(colIdx.concat(String.valueOf(rowIdx)), new Cell(rowIdx, colIdx));
            }
        }
        return cells;
    }

    public void createCellMapByRowAndCol(
    ) {
        allCells.forEach((key, value) -> {
            int rowIdx = key.charAt(1) - '0';
            String colIdx = String.valueOf(key.charAt(0));
            List<Cell> cellByRowIdx = cellByRow.getOrDefault(rowIdx, new ArrayList<>());
            cellByRowIdx.add(value);
            cellByRow.put(rowIdx, cellByRowIdx);
            List<Cell> cellByColIdx = cellByCol.getOrDefault(colIdx, new ArrayList<>());
            cellByColIdx.add(value);
            cellByCol.put(colIdx, cellByColIdx);
        });
    }

    public HashMap<String, Cell> getAllCells() {
        return allCells;
    }

    public List<Column> getCols() {
        return cols;
    }

    public List<Row> getRows() {
        return rows;
    }
}
