package parkinglot.design.service.impl;

import com.google.inject.Inject;
import parkinglot.design.command.BaseCommand;
import parkinglot.design.command.CommandsCollection;
import parkinglot.design.service.Actions;
import parkinglot.design.util.ErrorStrings;

import java.util.Map;

import static parkinglot.design.util.InputActionCommands.CREATE_PARKING_LOT;
import static parkinglot.design.util.InputActionCommands.PARK;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class ActionsImpl implements Actions {
    @Inject
    CommandsCollection commandsCollection;

    public void performAction(String input) {
        String[] inputArray = input.split(" ");
        if (inputArray.length == 0) {
            System.out.println(ErrorStrings.INVALID_INPUT);
        }

        switch (inputArray[0]) {
            case CREATE_PARKING_LOT:
                System.out.println("Creating parking lot");
                commandsCollection.get(CREATE_PARKING_LOT).execute(inputArray);
                break;

            case PARK:
                System.out.println("Park");
        }
    }
}
