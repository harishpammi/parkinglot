package parkinglot.design.service.impl;

import com.google.inject.Inject;
import parkinglot.design.command.CommandsCollection;
import parkinglot.design.service.Actions;

import static parkinglot.design.util.InputActionCommands.*;
import static parkinglot.design.util.PrintStrings.INVALID_INPUT;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class ActionsImpl implements Actions {
    @Inject
    CommandsCollection commandsCollection;

    public void performAction(String input) {
        String[] inputArray = input.split(" ");
        if (inputArray.length == 0) {
            System.out.println(INVALID_INPUT);
        }

        switch (inputArray[0]) {
            case CREATE_PARKING_LOT:
                commandsCollection.get(CREATE_PARKING_LOT).execute(inputArray);
                break;

            case PARK:
                commandsCollection.get(PARK).execute(inputArray);
                break;

            case LEAVE:
                commandsCollection.get(LEAVE).execute(inputArray);
                break;

            case STATUS:
                commandsCollection.get(STATUS).execute(inputArray);
                break;

            case CAR_REG_NUMS_BY_COLOR:
                commandsCollection.get(CAR_REG_NUMS_BY_COLOR).execute(inputArray);
                break;

            case SLOT_FOR_REG_NUM:
                commandsCollection.get(SLOT_FOR_REG_NUM).execute(inputArray);
                break;

            case SLOTS_BY_COLOR:
                commandsCollection.get(SLOTS_BY_COLOR).execute(inputArray);
                break;

            case "exit":
                System.exit(0);
                break;

            case "default":
                System.out.println(INVALID_INPUT);
                break;
        }
    }
}
