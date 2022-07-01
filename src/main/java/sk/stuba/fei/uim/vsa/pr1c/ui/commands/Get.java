package sk.stuba.fei.uim.vsa.pr1c.ui.commands;


import sk.stuba.fei.uim.vsa.pr1c.ui.UI;
import java.util.Date;

public class Get extends Command {
    public int execute(String entity) {
        int option;
        Long carParkId;
        String floorIdentifier;
        Long parkingSpotId;
        String carParkName;
        Long carId;
        String carRegPlate;
        Long userId;
        String email;
        Date date;

        Object result = null;

        switch(entity) {
            case "CAR_PARK":
                option = choose(
                        "[1] Get car park by ID\n" +
                        "[2] Get car park by name\n" +
                        "[3] Get all car parks\n",
                        3
                );

                if(option == 1) {
                    carParkId = inputLong("Car park ID: ");
                    result = UI.carParkService.getCarPark(carParkId);
                }
                else if(option == 2) {
                    carParkName = inputString("Car park name: ", 0, 200);
                    result = UI.carParkService.getCarPark(carParkName);
                }
                else if(option == 3) {
                    result = UI.carParkService.getCarParks();
                }
                break;
            case "CAR_PARK_FLOOR":
                option = choose(
                        "[1] Get park floor by car park id and floor identifier\n" +
                                "[2] Get park floors of a car park\n",
                        2
                );
                if(option == 1) {
                    carParkId = inputLong("Car park ID: ");
                    floorIdentifier = inputString("Floor identifier: ", 0, 200);
                    result = UI.carParkService.getCarParkFloor(carParkId, floorIdentifier);
                }
                else if(option == 2) {
                    carParkName = inputString("Car park name: ", 0, 200);
                    result = UI.carParkService.getCarPark(carParkName);
                }
                break;
            case "PARKING_SPOT":
                option = choose(
                        "[1] Get parking spot by its id\n" +
                                "[2] Get map of floors to parking spots by car park id\n" +
                                "[3] Get map of floors to available parking spots (by car park name)\n" +
                                "[4] Get map of floors to unavailable parking spots (by car park name)\n" +
                                "[5] Get parking spots by its floor and car park\n",
                        5
                );
                if(option == 1) {
                    parkingSpotId = inputLong("Parking spot ID: ");
                    result = UI.carParkService.getParkingSpot(parkingSpotId);
                }
                else if(option == 2) {
                    carParkId = inputLong("Car park ID: ");
                    result = UI.carParkService.getParkingSpots(carParkId);
                }
                else if(option == 3) {
                    carParkName = inputString("Car park name: ", 0, 200);
                    result = UI.carParkService.getAvailableParkingSpots(carParkName);
                }
                else if(option == 4) {
                    carParkName = inputString("Car park name: ", 0, 200);
                    result = UI.carParkService.getOccupiedParkingSpots(carParkName);
                }
                else if(option == 5) {
                    carParkId = inputLong("Car park ID: ");
                    floorIdentifier = inputString("Floor identifier: ", 0, 200);
                    result = UI.carParkService.getParkingSpots(carParkId, floorIdentifier);
                }
                break;
            case "CAR":
                option = choose(
                        "[1] Get car by car id\n" +
                                "[2] Get car by reg. plate\n" +
                                "[3] Get user's cars by user id\n",
                        3
                );
                if(option == 1) {
                    carId = inputLong("Car ID: ");
                    result = UI.carParkService.getCar(carId);
                }
                else if(option == 2) {
                    carRegPlate = inputString("Car registration plate: ", 0, 200);
                    result = UI.carParkService.getAvailableParkingSpots(carRegPlate);
                }
                else if(option == 3) {
                    userId = inputLong("User ID: ");
                    result = UI.carParkService.getCars(userId);
                }
                break;
            case "USER":
                option = choose(
                        "[1] Get user by their ID\n" +
                                "[2] Get user by their email\n" +
                                "[3] Get all users\n",
                        3
                );
                if(option == 1) {
                    userId = inputLong("User ID: ");
                    result = UI.carParkService.getUser(userId);
                }
                else if(option == 2) {
                    email = inputString("User email: ", 0, 200);
                    result = UI.carParkService.getUser(email);
                }
                else if(option == 3) {
                    result = UI.carParkService.getUsers();
                }
                break;
            case "RESERVATION":
                option = choose(
                        "[1] Get reservations of parking spot on definite date\n" +
                                "[2] Get user's active reservations\n",
                        2
                );
                if(option == 1) {
                    parkingSpotId = inputLong("Parking spot ID: ");
                    date = inputDate("Date: ");
                    result = UI.carParkService.getReservations(parkingSpotId, date);
                }
                else if(option == 2) {
                    userId = inputLong("User ID: ");
                    result = UI.carParkService.getMyReservations(userId);
                }
                break;
            case "HOLIDAY":
                option = choose(
                        "[1] Get holidays on definite date\n" +
                                "[2] Get all holidays\n",
                        2
                );
                if(option == 1) {
                    date = inputDate("Holidays date: ");
                    result = UI.carParkService.getHoliday(date);
                }
                else if(option == 2) {
                    result = UI.carParkService.getHolidays();
                }
                break;
            default:
                System.out.println(BAD_ARGUMENTS);
                return 1;
        }
        System.out.println(result);
        return 1;
    }
}