package modals;

import java.util.List;
import static utility.FormattingOptions.*;

public class Formatting {

    public void makeBold(List<Cell> cells) {
        cells.forEach(it -> it.value = BOLD + it.value + BOLD);
    }

    public void makeItalics(List<Cell> cells) {
        cells.forEach(it -> it.value = ITALICS + it.value + ITALICS);
    }

    public void makeUnderlined(List<Cell> cells) {
        cells.forEach(it -> it.value = UNDERLINE + it.value + UNDERLINE);
    }

    public void changeFont(List<Cell> cells) {
        cells.forEach(it -> it.value = FONT + it.value + FONT);
    }
}
