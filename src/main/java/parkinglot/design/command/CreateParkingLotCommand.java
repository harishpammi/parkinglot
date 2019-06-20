package parkinglot.design.command;

import com.google.inject.Inject;
import parkinglot.design.service.ParkingLot;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class CreateParkingLotCommand implements BaseCommand {
    @Inject
    private ParkingLot parkingLot;

    public void execute(String[] values) {
        if (parkingLot.getTotalNoOfSlotsAvailable() > 0) {
            System.out.println("Parking lot is already created");
            return;
        }

        for (int i = 1; i <= Integer.parseInt(values[1]); i++) {
            parkingLot.addSlot(i);
        }

        System.out.println("Created a parking lot with " + values[1] + " slots");
        System.out.println(parkingLot.getTotalNoOfSlotsAvailable());
    }
}
