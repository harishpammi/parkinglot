package parkinglot.design.service.impl;

import parkinglot.design.service.ParkingLot;

import java.util.PriorityQueue;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class ParkingLotImpl implements ParkingLot {
    private final PriorityQueue<Integer> parkingSlotsQueue = new PriorityQueue<Integer>();

    public void addSlot(Integer slotNumber) {
        parkingSlotsQueue.add(slotNumber);
    }

    public Integer getNearByAvailableSlot() {
        return parkingSlotsQueue.peek();
    }

    public Integer occupyNearByAvailableSlot() {
        return parkingSlotsQueue.poll();
    }

    public int getTotalNoOfSlotsAvailable() {
        return parkingSlotsQueue.size();
    }
}
