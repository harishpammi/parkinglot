package parkinglot.design.command;

import com.google.inject.Inject;
import parkinglot.design.dto.VehicleDTO;
import parkinglot.design.mapstore.ColorSlotsMap;
import parkinglot.design.mapstore.RegNumberSlotMap;
import parkinglot.design.mapstore.SlotVehicleMap;
import parkinglot.design.service.ParkingLot;

import static parkinglot.design.util.PrintStrings.INVALID_INPUT;
import static parkinglot.design.util.PrintStrings.PARKING_LOT_IS_FULL;
import static parkinglot.design.util.PrintStrings.PARK_SUCCESS;

/**
 * Created by hareesh.pammi on 6/21/19.
 */
public class ParkCommand implements BaseCommand {
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
        if (values.length<3) {
            System.out.println(INVALID_INPUT);
        }

        VehicleDTO vehicleDTO = new VehicleDTO(values[1], values[2]);
        Integer slotNumberAllotted = parkingLot.occupyNearByAvailableSlot();
        if (slotNumberAllotted == null) {
            System.out.println(PARKING_LOT_IS_FULL);
            return;
        }

        slotVehicleMap.store(slotNumberAllotted, vehicleDTO);
        regNumberSlotMap.store(vehicleDTO.getRegistrationNumber(), slotNumberAllotted);
        colorSlotsMap.append(vehicleDTO.getColour(), slotNumberAllotted);

        System.out.println(PARK_SUCCESS.replace("{}",Integer.toString(slotNumberAllotted)));
    }
}
