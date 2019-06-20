package parkinglot.design.command;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import parkinglot.design.mapstore.ColorSlotsMap;
import parkinglot.design.mapstore.RegNumberSlotMap;
import parkinglot.design.mapstore.SlotVehicleMap;
import parkinglot.design.service.ParkingLot;

import java.util.Collections;
import java.util.List;

import static parkinglot.design.util.PrintStrings.INVALID_INPUT;

/**
 * Created by hareesh.pammi on 6/21/19.
 */
public class CarRegNumbersByColorCommand implements BaseCommand {
    @Inject
    SlotVehicleMap slotVehicleMap;

    @Inject
    ColorSlotsMap colorSlotsMap;

    @Override
    public void execute(String[] values) {
        if (values.length < 2) {
            System.out.println(INVALID_INPUT);
        }

        List<Integer> slotNumbers = colorSlotsMap.get(values[1]);
        Collections.sort(slotNumbers);
        List<String> regNums = Lists.newLinkedList();
        slotNumbers.forEach(a -> {
            String regNum = slotVehicleMap.get(a).getRegistrationNumber();
            regNums.add(regNum);
        });

        System.out.println(String.join(", ", regNums));
    }
}
