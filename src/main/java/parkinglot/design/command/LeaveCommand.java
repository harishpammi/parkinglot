package parkinglot.design.command;

import com.google.inject.Inject;
import parkinglot.design.dto.VehicleDTO;
import parkinglot.design.mapstore.ColorSlotsMap;
import parkinglot.design.mapstore.RegNumberSlotMap;
import parkinglot.design.mapstore.SlotVehicleMap;
import parkinglot.design.service.ParkingLot;

import static parkinglot.design.util.PrintStrings.INVALID_INPUT;
import static parkinglot.design.util.PrintStrings.LEAVE_SUCCESS;

/**
 * Created by hareesh.pammi on 6/21/19.
 */
public class LeaveCommand implements BaseCommand {
    @Inject
    ParkingLot parkingLot;

    @Inject
    SlotVehicleMap slotVehicleMap;

    @Inject
    RegNumberSlotMap regNumberSlotMap;

    @Inject
    ColorSlotsMap colorSlotsMap;

    @Override
    public void execute(String[] values) {
        if (values.length<2) {
            System.out.println(INVALID_INPUT);
        }

        int inputSlot = Integer.parseInt(values[1]);
        VehicleDTO vehicleDTO = slotVehicleMap.get(inputSlot);

        slotVehicleMap.remove(inputSlot);
        regNumberSlotMap.remove(vehicleDTO.getRegistrationNumber());
        colorSlotsMap.removeValueFromKey(vehicleDTO.getColour(), inputSlot);

        parkingLot.addSlot(inputSlot);
        System.out.println(LEAVE_SUCCESS.replace("{}", Integer.toString(inputSlot)));
    }
}
