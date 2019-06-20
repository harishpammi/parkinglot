package parkinglot.design.service.impl;

import parkinglot.design.service.Actions;
import parkinglot.design.util.ErrorStrings;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class ActionsImpl implements Actions {
    public void performAction(String input) {
        String[] inputArray = input.split(" ");
        if (inputArray.length == 0) {
            System.out.println(ErrorStrings.INVALID_INPUT);
        }
    }
}
