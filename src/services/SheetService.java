package services;

import modals.*;
import utility.OperationConverter;
import utility.OperationEnum;

import java.util.List;
import java.util.Set;

public class SheetService {
    private Sheet sheet;

    public void createSheet() {
        sheet = new Sheet();
    }


    public void addValue(String address, String value) {
        Cell cell = sheet.getAllCells().get(address);
        cell.setValue(value);
    }

    public String fetchValue(String address) {
        Cell cell = sheet.getAllCells().get(address);
        return cell.getValue();
    }

    public void getColumn(String colIdx) {
        Column col = sheet.getCols().stream().filter(it -> it.getColId().equals(colIdx)).findFirst().get();
        System.out.println("Printing columns");
        for(Cell c : col.getCells().values()) {
            System.out.print(c.getValue() + " ");
        }
    }

    public void displayExcel() {
        System.out.println("Displaying Excel Sheet...");
        List<Row> allRows = sheet.getRows();
        Set<String> colNames = allRows.get(0).getRecord().keySet();
        System.out.print(" ");
        for(String col : colNames) {
            System.out.print(col + "  ");
        }
        System.out.println();
        for(Row row: allRows) {
            System.out.print(row.getRowId() + "  ");
            List<Cell> cells = row.getRecord().values().stream().toList();
            for(Cell cell : cells) {
                System.out.print(cell.getValue() + "  ");
            }
            System.out.println();
        }
    }

    public String operation(String start, String end, String input) {
        //assuming that operation is taking place on a column only.
        String colIdx = String.valueOf(start.charAt(0));
        int startingRow = start.charAt(1) - '0';
        int endingRow = end.charAt(1) - '0';
        Column currentColumn = sheet.getCols().stream().filter(it -> it.getColId().equals(colIdx)).findFirst().get();
        List<Cell> range = currentColumn.getCells().values().stream().filter(it -> it.getRowId() >= startingRow && it.getRowId() <= endingRow).toList();
        Operations operations = new Operations(range);
        if(OperationConverter.stringToEnum(input) == OperationEnum.ADD) {
            return operations.add();
        }
        else{
            return OperationEnum.UNSUPPORTED.name();
        }
    }

    public void doFormatting(String start, String end, String input) {
        Formatting formatting = new Formatting();
        String colIdx = String.valueOf(start.charAt(0));
        int startingRow = start.charAt(1) - '0';
        int endingRow = end.charAt(1) - '0';
        Column currentColumn = sheet.getCols().stream().filter(it -> it.getColId().equals(colIdx)).findFirst().get();
        List<Cell> range = currentColumn.getCells().values().stream().filter(it -> it.getRowId() >= startingRow && it.getRowId() <= endingRow).toList();
        if(input.equalsIgnoreCase("BOLD")) {
            formatting.makeBold(range);
        }
    }
}
