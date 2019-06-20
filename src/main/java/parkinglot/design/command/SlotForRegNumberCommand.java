package parkinglot.design.command;

import com.google.inject.Inject;
import parkinglot.design.mapstore.RegNumberSlotMap;

import static parkinglot.design.util.PrintStrings.INVALID_INPUT;
import static parkinglot.design.util.PrintStrings.NOT_FOUND;

/**
 * Created by hareesh.pammi on 6/21/19.
 */
public class SlotForRegNumberCommand implements BaseCommand {
    @Inject
    RegNumberSlotMap regNumberSlotMap;

    @Override
    public void execute(String[] values) {
        if (values.length < 2) {
            System.out.println(INVALID_INPUT);
        }

        Integer slotNum = regNumberSlotMap.get(values[1]);
        if (slotNum == null) {
            System.out.println(NOT_FOUND);
            return;
        }

        System.out.println(regNumberSlotMap.get(values[1]));
    }
}
