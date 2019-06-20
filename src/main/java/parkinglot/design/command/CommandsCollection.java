package parkinglot.design.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class CommandsCollection {
    private Map<String, BaseCommand> commandsMap = new HashMap<>();

    private static CommandsCollection commandsCollection = null;

    private CommandsCollection() {
    }

    public static CommandsCollection getInstance() {
        if (commandsCollection == null) {
            commandsCollection = new CommandsCollection();
        }

        return commandsCollection;
    }

    public void put(String key, BaseCommand commandObject) {
        commandsMap.put(key, commandObject);
    }

    public BaseCommand get(String key) {
        return commandsMap.get(key);
    }
}
