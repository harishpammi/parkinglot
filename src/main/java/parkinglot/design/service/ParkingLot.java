package parkinglot.design.service;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public interface ParkingLot {
    void addSlot(Integer slotNumber);

    Integer getNearByAvailableSlot();

    Integer occupyNearByAvailableSlot();

    int getTotalNoOfSlotsAvailable();
}
