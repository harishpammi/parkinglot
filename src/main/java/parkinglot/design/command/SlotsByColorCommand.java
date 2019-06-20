package parkinglot.design.command;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import parkinglot.design.mapstore.ColorSlotsMap;
import parkinglot.design.mapstore.SlotVehicleMap;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static parkinglot.design.util.PrintStrings.INVALID_INPUT;

/**
 * Created by hareesh.pammi on 6/21/19.
 */
public class SlotsByColorCommand implements BaseCommand {
    @Inject
    ColorSlotsMap colorSlotsMap;

    @Override
    public void execute(String[] values) {
        if (values.length < 2) {
            System.out.println(INVALID_INPUT);
        }

        List<Integer> slotNumbers = colorSlotsMap.get(values[1]);
        Collections.sort(slotNumbers);

        System.out.println(slotNumbers.stream().map(a -> Integer.toString(a)).collect(Collectors.joining(", ")));
    }
}
