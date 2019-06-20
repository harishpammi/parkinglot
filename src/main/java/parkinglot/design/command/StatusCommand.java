package parkinglot.design.command;

import com.google.inject.Inject;
import parkinglot.design.mapstore.SlotVehicleMap;

/**
 * Created by hareesh.pammi on 6/21/19.
 */
public class StatusCommand implements BaseCommand {
    @Inject
    SlotVehicleMap slotVehicleMap;

    @Override
    public void execute(String[] values) {
        System.out.println(String.format("%-10s\t%-17s\t%-8s", "Slot No.", "Registration No", "Colour"));

        slotVehicleMap.getEntrySet().forEach(key -> {
            System.out.println(String.format("%-10d\t%-17s\t%-8s", key.getKey(), key.getValue().getRegistrationNumber(), key.getValue().getColour()));
        });
    }
}
