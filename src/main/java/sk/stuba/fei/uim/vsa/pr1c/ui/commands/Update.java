package sk.stuba.fei.uim.vsa.pr1c.ui.commands;

import sk.stuba.fei.uim.vsa.pr1c.domain.*;
import sk.stuba.fei.uim.vsa.pr1c.ui.UI;

public class Update extends Command {
    public int execute(String entity) {
        Long itemId;

        String brand;
        String model;
        String colour;
        String vehicleRegistrationPlate;
        String firstname;
        String lastname;
        String email;

        Object result;

        switch(entity) {
            case "CAR_PARK":
                itemId = inputLong("ID of the item: ");
                String name = inputString("Name: ", 0, 200);
                String address = inputString("Address: ", 0, 200);
                Integer pricePerHour = inputInteger("Price per hour: ");

                CarPark newObject = new CarPark(name, address, pricePerHour);
                newObject.setCarParkId(itemId);
                result = UI.carParkService.updateCarPark(newObject);
                break;
            case "CAR":
                itemId = inputLong("Car ID: ");
                brand = inputString("Brand: ", 0, 200);
                model = inputString("Model: ", 0, 200);
                colour = inputString("Colour: ", 0, 200);
                vehicleRegistrationPlate = inputString("Vehicle registration plate: ", 0, 200);

                Car newCar = new Car(itemId, brand, model, colour, vehicleRegistrationPlate);
                result = UI.carParkService.updateCar(newCar);
                break;
            case "USER":
                itemId = inputLong("User ID: ");
                firstname = inputString("First name: ", 0, 200);
                lastname = inputString("Last name: ", 0, 200);
                email = inputString("Email: ", 0, 200);

                User newUser = new User(firstname, lastname, email);
                newUser.setUserId(itemId);
                result = UI.carParkService.updateUser(newUser);
                break;
            default:
                System.out.println(BAD_ARGUMENTS);
                return 1;
        }
        if(result == null) {
            System.out.println("Error updating an item");
        }
        else {
            System.out.println(result);
        }
        return 1;
    }
}
