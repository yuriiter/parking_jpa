package sk.stuba.fei.uim.vsa.pr1c.ui.commands;

import sk.stuba.fei.uim.vsa.pr1c.ui.UI;

public class Delete extends Command {
    public int execute(String entity) {
        Long carParkId;
        String floorIdentifier;
        Long parkingSpotId;
        Long carId;
        Long userId;
        Long holidayId;

        Object result;

        switch(entity) {
            case "CAR_PARK":
                carParkId = inputLong("Car park ID: ");
                if(!confirm()) {
                    return 1;
                }
                result = UI.carParkService.deleteCarPark(carParkId);
                break;
            case "CAR_PARK_FLOOR":
                carParkId = inputLong("Car park ID: ");
                floorIdentifier = inputString("Floor identifier: ", 0, 200);
                if(!confirm()) {
                    return 1;
                }
                result = UI.carParkService.deleteCarParkFloor(carParkId, floorIdentifier);
                break;
            case "PARKING_SPOT":
                parkingSpotId = inputLong("Parking spot ID: ");
                if(!confirm()) {
                    return 1;
                }
                result = UI.carParkService.deleteParkingSpot(parkingSpotId);
                break;
            case "CAR":
                carId = inputLong("Car ID: ");
                if(!confirm()) {
                    return 1;
                }
                result = UI.carParkService.deleteCar(carId);
                break;
            case "USER":
                userId = inputLong("User ID: ");
                if(!confirm()) {
                    return 1;
                }
                result = UI.carParkService.deleteUser(userId);
                break;
            case "HOLIDAY":
                holidayId = inputLong("Holiday ID: ");
                if(!confirm()) {
                    return 1;
                }
                result = UI.carParkService.deleteHoliday(holidayId);
                break;
            default:
                System.out.println(BAD_ARGUMENTS);
                return 1;
        }
        if(result == null) {
            System.out.println("Error deleting an item");
        }
        else {
            System.out.println(result);
        }
        return 1;
    }
}