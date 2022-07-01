package sk.stuba.fei.uim.vsa.pr1c.ui.commands;

import sk.stuba.fei.uim.vsa.pr1c.ui.UI;

public class End extends Command {
    public int execute(String entity) {
        Long reservationId;

        Object result;
        switch(entity) {
            case "RESERVATION":
                reservationId = inputLong("Reservation ID: ");
                if(!confirm()) {
                    return 1;
                }
                result = UI.carParkService.endReservation(reservationId);
                break;
            default:
                System.out.println(BAD_ARGUMENTS);
                return 1;
        }
        if(result == null) {
            System.out.println("Error finding an item");
        }
        else {
            System.out.println("Ended:");
            System.out.println(result);
        }
        return 1;
    }
}