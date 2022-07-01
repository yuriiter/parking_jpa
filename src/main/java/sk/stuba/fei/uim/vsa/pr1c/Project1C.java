package sk.stuba.fei.uim.vsa.pr1c;


import sk.stuba.fei.uim.vsa.pr1c.ui.UI;

import java.util.Date;

public class Project1C {
    public static void main(String[] args) {
        CarParkService carParkService = UI.carParkService;
//        Object o;
        carParkService.createCarPark("name", "address", 11);
        carParkService.createCarParkFloor(1L, "SomeID");
        carParkService.createParkingSpot(1L, "SomeID", "SomeID1");
        carParkService.createUser("User", "User", "Mail");
        carParkService.createCar(1L, "Brand", "Model", "Colour", "VRP");
        carParkService.createReservation(1L, 1L);
        carParkService.createHoliday("Name", new Date("04/05/2022"));
//        carParkService.deleteHoliday(1L);
//        System.out.println(carParkService.endReservation(1L));
//
//        System.out.println(carParkService.getReservations(1L, new Date("04/05/2022")));
//        System.out.println(carParkService.getParkingSpots(1L));
//        System.out.println(carParkService.deleteParkingSpot(1L));
//        System.out.println(carParkService.getParkingSpots(1L));
//        carParkService.createCarParkFloor(1L, "SomeID1");
//        System.out.println(carParkService.getCarParks());

        try {
            new UI();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
