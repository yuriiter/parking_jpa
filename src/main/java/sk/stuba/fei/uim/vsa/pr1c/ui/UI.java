package sk.stuba.fei.uim.vsa.pr1c.ui;

import sk.stuba.fei.uim.vsa.pr1c.CarParkService;

import java.util.Scanner;

public class UI {
    public static CarParkService carParkService = new CarParkService();
    private final Scanner scanner = new Scanner(System.in);
    private final CommandProcessor commandProcessor = new CommandProcessor();

    private final String WELCOME_LINE = ">> Car park service application";
    public static final String EXPLANATION =
            "This application has several commands:\n" +
                    "create|c \t [entity]\n" +
                    "get|g \t\t [entity]\n" +
                    "delete|d \t [entity]\n" +
                    "end|e \t\t [entity]\n" +
                    "update|u \t [entity]\n" +
                    "help|h \t\t [entity]\n" +
                    "quit|q\n" +
                    "\n\nAfter which you follow prompts\n" +
                    "Entities are: CAR_PARK, CAR_PARK_FLOOR, PARKING_SPOT, CAR, USER, RESERVATION, HOLIDAY\n" +
                    "To find what parameters an entity needs, type 'help [entity]'\n" +
                    "To display this message, type 'help'\n";

    private boolean getInput() {
        System.out.print("> ");
        String input = scanner.nextLine();
        return commandProcessor.processInput(input);
    }

    public UI() {
        System.out.println(WELCOME_LINE);
        System.out.println(EXPLANATION);
        while(getInput());
    }

}
