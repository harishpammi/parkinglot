package parkinglot.design.command;

import com.google.inject.Inject;
import parkinglot.design.service.ParkingLot;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class CreateParkingLotCommand implements BaseCommand<Integer> {
    @Inject
    private ParkingLot parkingLot;

    public void execute(Integer value) {
        if (parkingLot.getTotalNoOfSlotsAvailable() > 0) {
            System.out.println("Parking lot is already created");
            return;
        }

        for (int i = 1; i <= value; i++) {
            parkingLot.addSlot(i);
        }

        System.out.println("Created a parking lot with " + value + " slots");
    }
}
