package sk.stuba.fei.uim.vsa.pr1c.ui.commands;

import sk.stuba.fei.uim.vsa.pr1c.ui.UI;

import java.util.HashMap;
import java.util.Map;

public class Help extends Command {

    private final Map<String, String> entitiesMap = new HashMap<>();
    public Help() {
        String carPark =
                "Create CAR_PARK:\n" +
                "create car park;\n" +
                "get CAR_PARK:\n" +
                "Get car park by ID;\n" +
                "Get car park by name;\n" +
                "Get all car parks;\n" +
                "delete CAR_PARK:\n" +
                "Delete car park by ID\n" +
                "update CAR_PARK:\n" +
                "update car park";

        String carParkFloor =
                "create CAR_PARK_FLOOR:\n" +
                "Create park floor;\n" +
                "get CAR_PARK_FLOOR:\n" +
                "Get park floor by car park ID and floor Identifier;\n" +
                "Get park floors of a car park;\n" +
                "delete CAR_PARK_FLOOR:\n" +
                "Delete park floor";

        String parkingSpot =
                "create PARKING_SPOT:\n" +
                "Create parking spot;\n" +
                "get PARKING_SPOT:\n" +
                "Get parking spot by ID;\n" +
                "Get parking spots by its floor and car park;\n" +
                "Get map of floors to parking spots of car park;\n" +
                "Get map of floors to (un)available parking spots (by park name);\n" +
                "delete PARKING_SPOT:\n" +
                "Delete parking spot by its ID";

        String car =
                "create CAR:\n" +
                "Create car;\n" +
                "get CAR:\n" +
                "Get car by car ID;\n" +
                "Get car by vehicle registration plate;\n" +
                "Get user's cars by user ID;\n" +
                "delete CAR:\n" +
                "Delete car by car ID\n" +
                "update CAR:\n" +
                "update car";

        String user =
                "create USER:\n" +
                "Create user;\n" +
                "get USER:\n" +
                "Get user by ID;\n" +
                "Get user by email;\n" +
                "Get users;\n" +
                "delete USER:\n" +
                "Delete user by ID;\n" +
                "update USER:\n" +
                "update user";

        String reservation =
                "create RESERVATION:\n" +
                "Create reservation;\n" +
                "end RESERVATION:\n" +
                "End reservation;\n" +
                "get RESERVATION:\n" +
                "Get reservations of parking spot on date;\n" +
                "Get user's active reservations";

        String holiday =
                "create HOLIDAY:\n" +
                "Create holiday;\n" +
                "get HOLIDAY:\n" +
                "Get holiday by date;\n" +
                "Get holidays;\n" +
                "delete HOLIDAY:\n" +
                "Delete holiday by ID;";

        entitiesMap.put("CAR_PARK", carPark);
        entitiesMap.put("CAR_PARK_FLOOR", carParkFloor);
        entitiesMap.put("PARKING_SPOT", parkingSpot);
        entitiesMap.put("CAR", car);
        entitiesMap.put("USER", user);
        entitiesMap.put("RESERVATION", reservation);
        entitiesMap.put("HOLIDAY", holiday);
    }

    public int execute(String entity) {
        if(entity == null) {
            System.out.println(UI.EXPLANATION);
            return 1;
        }
        String helpString = entitiesMap.getOrDefault(entity, "Entity '" + entity + "' doesn't exist. Type 'help' for more information");
        System.out.println(helpString);
        return 1;
    }
}