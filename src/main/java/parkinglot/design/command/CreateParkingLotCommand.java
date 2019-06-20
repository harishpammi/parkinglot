package parkinglot.design.command;

import com.google.inject.Inject;
import parkinglot.design.service.ParkingLot;

import static parkinglot.design.util.PrintStrings.PARKING_LOT_CREATED;
import static parkinglot.design.util.PrintStrings.PARKING_LOT_EXISTS;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class CreateParkingLotCommand implements BaseCommand {
    @Inject
    private ParkingLot parkingLot;

    public void execute(String[] values) {
        if (parkingLot.getTotalNoOfSlotsAvailable() > 0) {
            System.out.println(PARKING_LOT_EXISTS);
            return;
        }

        for (int i = 1; i <= Integer.parseInt(values[1]); i++) {
            parkingLot.addSlot(i);
        }

        System.out.println(PARKING_LOT_CREATED.replace("{}", Integer.toString(parkingLot.getTotalNoOfSlotsAvailable())));
    }
}
