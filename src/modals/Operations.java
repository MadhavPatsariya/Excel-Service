package modals;

import java.util.List;

public class Operations {
    List<Cell> cellList;

    public Operations(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public String add() {
        int total = 0;
        boolean error = false;
        for(int i = 0; i < cellList.size(); i++) {
            try{
                total += Integer.parseInt(cellList.get(i).value);
            }
            catch(Exception e) {
                error = true;
            }
        }
        return error ? "NOT POSSIBLE" : String.valueOf(total);
    }
}
