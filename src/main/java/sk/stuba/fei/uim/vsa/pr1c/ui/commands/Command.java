package sk.stuba.fei.uim.vsa.pr1c.ui.commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Command {
    protected final String WRONG_NUMBER_OF_ARGUMENTS_ERROR = "Error: Wrong number of arguments";
    protected final String BAD_ARGUMENTS = "Error: Bad parameters. Type 'help' for more information";

    protected boolean confirm() {
        System.out.print("Are you sure? (yes|y, no|n, default is no) ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equals("y") || input.equals("yes")) {
            System.out.println("Confirmed.");
            return true;
        }
        else {
            System.out.println("Cancelled.");
            return false;
        }
    }
    protected int choose(String options, int optionsNumber) {
        System.out.println("Choose an option.");
        System.out.println(options);
        Scanner scanner = new Scanner(System.in);
        int optionNumber;
        try {
            optionNumber = scanner.nextInt();
            if(optionNumber < 1 || optionNumber > optionsNumber) {
                System.out.println("Bad input. Only integers in range 1 - " + optionsNumber);
                return choose(options, optionsNumber);
            }
            return optionNumber;
        }
        catch(Exception e) {
            System.out.println("Bad input. Only integers in range 1 - " + optionsNumber);
            return choose(options, optionsNumber);
        }
    }

    protected Long inputLong(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        long input;
        try {
            input = scanner.nextLong();
        }
        catch(Exception e) {
            System.out.println("Error: Input must be of type long, try again.");
            return inputLong(text);
        }
        return input;
    }
    protected Integer inputInteger(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        int input;
        try {
            input = scanner.nextInt();
        }
        catch(Exception e) {
            System.out.println("Error: Input must be of type long, try again.");
            return inputInteger(text);
        }
        return input;
    }
    protected String inputString(String text, int minLength, int maxLength) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        if(input.length() < minLength || input.length() > maxLength) {
            System.out.printf("Error: Input length must be in range %d - %d, try again.", minLength, maxLength);
            return inputString(text, minLength, maxLength);
        }
        return input;
    }
    protected Date inputDate(String text) {
        System.out.print("(Input format dd/MM/yyyy) ");
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
        }
        catch(Exception e) {
            System.out.println("Error: input format should be 'dd/MM/yyyy'");
            return inputDate(text);
        }
        return date;
    }

    public abstract int execute(String entity);

}
