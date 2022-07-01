package sk.stuba.fei.uim.vsa.pr1c.ui;

import sk.stuba.fei.uim.vsa.pr1c.ui.commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandProcessor {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProcessor() {
        Create createCommand = new Create();
        Delete deleteCommand = new Delete();
        End endCommand = new End();
        Get getCommand = new Get();
        Help helpCommand = new Help();
        Quit quitCommand = new Quit();
        Update updateCommand = new Update();

        commands.put("create", createCommand);
        commands.put("c", createCommand);

        commands.put("delete", deleteCommand);
        commands.put("d", deleteCommand);

        commands.put("end", endCommand);
        commands.put("e", endCommand);

        commands.put("get", getCommand);
        commands.put("g", getCommand);

        commands.put("help", helpCommand);
        commands.put("h", helpCommand);

        commands.put("quit", quitCommand);
        commands.put("q", quitCommand);

        commands.put("update", updateCommand);
        commands.put("u", updateCommand);
    }

    public boolean processInput(String input) {
        String trimmed = input.trim();
        if(trimmed.length() == 0) {
            return true;
        }
        String command;
        List<String> parameters = new ArrayList<>();
        if(trimmed.contains(" ")) {
             command = trimmed.substring(0, trimmed.indexOf(" "));
             trimmed = trimmed.replace(command, "").trim();
        }
        else {
            command = trimmed;
            trimmed = "";
        }
        while(trimmed.length() > 0) {
            String parameter;
            if(trimmed.contains(" ")) {
                parameter = trimmed.substring(0, trimmed.indexOf(" "));
                trimmed = trimmed.replace(parameter, "").trim();
            }
            else {
                parameter = trimmed;
                trimmed = "";
            }
            parameters.add(parameter);
        }
        if(parameters.size() > 1) {
            System.out.println("Error: Bad number of parameters. Type 'help' for more info");
            return true;
        }

        Command mappedCommand = commands.getOrDefault(command, null);
        if(mappedCommand == null) {
            System.out.println("Command '" + command + "' doesn't exist.");
            commands.get("help").execute(null);
            return true;
        }
        String arg = parameters.size() == 0 ? null : parameters.get(0);
        return mappedCommand.execute(arg) == 1;
    }
}







