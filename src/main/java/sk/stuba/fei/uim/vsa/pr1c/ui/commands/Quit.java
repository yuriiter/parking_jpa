package sk.stuba.fei.uim.vsa.pr1c.ui.commands;

import java.util.List;

public class Quit extends Command {
    public int execute(String entity) {
        if(entity != null) {
            System.out.println(WRONG_NUMBER_OF_ARGUMENTS_ERROR);
            return 1;
        }
        if(confirm()) {
            return 0;
        }
        return 1;
    }
}
