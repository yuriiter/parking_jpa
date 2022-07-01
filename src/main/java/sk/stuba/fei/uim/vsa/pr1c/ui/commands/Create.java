package sk.stuba.fei.uim.vsa.pr1c.ui.commands;

import sk.stuba.fei.uim.vsa.pr1c.ui.UI;

import java.util.Date;

public class Create extends Command {
    public int execute(String entity) {
        Long carParkId;
        String floorIdentifier;
        String spotIdentifier;
        Long userId;
        String brand;
        String model;
        String colour;
        String vehicleRegistrationPlate;
        String firstname;
        String lastname;
        String email;
        Long parkingSpotId;
        Long carId;
        Date date;
        String holidayName;

        Object result;

        switch(entity) {
            case "CAR_PARK":
                String name = inputString("Name: ", 0, 200);
                String address = inputString("Address: ", 0, 200);
                Integer pricePerHour = inputInteger("Price per hour: ");
                result = UI.carParkService.createCarPark(name, address, pricePerHour);
                break;
            case "CAR_PARK_FLOOR":
                carParkId = inputLong("Car park ID: ");
                floorIdentifier = inputString("Floor identifier: ", 0, 200);
                result = UI.carParkService.createCarParkFloor(carParkId, floorIdentifier);
                break;
            case "PARKING_SPOT":
                carParkId = inputLong("Car park ID: ");
                floorIdentifier = inputString("Floor identifier: ", 0, 200);
                spotIdentifier = inputString("Parking spot identifier: ", 0, 200);
                result = UI.carParkService.createParkingSpot(carParkId, floorIdentifier, spotIdentifier);
                break;
            case "CAR":
                userId = inputLong("User ID: ");
                brand = inputString("Brand: ", 0, 200);
                model = inputString("Model: ", 0, 200);
                colour = inputString("Colour: ", 0, 200);
                vehicleRegistrationPlate = inputString("Vehicle registration plate: ", 0, 200);
                result = UI.carParkService.createCar(userId, brand, model, colour, vehicleRegistrationPlate);
                break;
            case "USER":
                firstname = inputString("First name: ", 0, 200);
                lastname = inputString("Last name: ", 0, 200);
                email = inputString("Email: ", 0, 200);
                result = UI.carParkService.createUser(firstname, lastname, email);
                break;
            case "RESERVATION":
                parkingSpotId = inputLong("Parking spot ID: ");
                carId = inputLong("Car ID: ");
                result = UI.carParkService.createReservation(parkingSpotId, carId);
                break;
            case "HOLIDAY":
                holidayName = inputString("Holiday name: ", 0, 200);
                date = inputDate("Holiday date: ");
                result = UI.carParkService.createHoliday(holidayName, date);
                break;
            default:
                System.out.println(BAD_ARGUMENTS);
                return 1;
        }
        if(result == null) {
            System.out.println("Error creating an item");
        }
        else {
            System.out.println(result);
        }
        return 1;
    }

}
