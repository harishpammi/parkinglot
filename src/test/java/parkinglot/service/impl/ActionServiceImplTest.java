package parkinglot.service.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parkinglot.design.mapstore.ColorSlotsMap;
import parkinglot.design.mapstore.RegNumberSlotMap;
import parkinglot.design.mapstore.SlotVehicleMap;
import parkinglot.design.service.Actions;
import parkinglot.design.service.ParkingLot;
import parkinglot.service.BaseServiceImplTest;

/**
 * Created by hareesh.pammi on 6/24/19.
 */
@FixMethodOrder(MethodSorters.JVM)
public class ActionServiceImplTest extends BaseServiceImplTest {
    private static Actions actionsTestObj;
    private static ParkingLot parkingLot;
    private static SlotVehicleMap slotVehicleMap;
    private static RegNumberSlotMap regNumberSlotMap;
    private static ColorSlotsMap colorSlotsMap;

    @BeforeClass
    public static void setup() {
        BaseServiceImplTest.setup();
        actionsTestObj = injector.getInstance(Actions.class);
        parkingLot = injector.getInstance(ParkingLot.class);
        slotVehicleMap = injector.getInstance(SlotVehicleMap.class);
        regNumberSlotMap = injector.getInstance(RegNumberSlotMap.class);
        colorSlotsMap = injector.getInstance(ColorSlotsMap.class);
    }

    @Test
    public void createParkingLotTest() {
        actionsTestObj.performAction("create_parking_lot 3");
        int totalParkingSlots = parkingLot.getTotalNoOfSlotsAvailable();
        Assert.assertEquals(3, totalParkingSlots);
    }

    @Test
    public void parkVehicleTest() {
        int nearBySlot = parkingLot.getNearByAvailableSlot();
        actionsTestObj.performAction("park KA-01-HH-1234 White");
        int assignedSlot = regNumberSlotMap.get("KA-01-HH-1234");

        Assert.assertEquals(nearBySlot, assignedSlot);
    }

    @Test
    public void parkingLotFullTest() {
        actionsTestObj.performAction("park KA-01-HH-9999 White");
        actionsTestObj.performAction("park KA-01-BB-0001 Black");

        actionsTestObj.performAction("park KA-01-BB-0002 Black");
        Integer slotNumber = regNumberSlotMap.get("KA-01-BB-0002");

        Assert.assertNull(slotNumber);
    }

    @Test
    public void vehicleLeaveTest() {
        Integer slotNum1 = regNumberSlotMap.get("KA-01-HH-9999");
        actionsTestObj.performAction("leave " + slotNum1);
        Integer slotNumber = regNumberSlotMap.get("KA-01-HH-9999");

        Assert.assertNull(slotNumber);
        Assert.assertEquals(1, parkingLot.getTotalNoOfSlotsAvailable());
    }
}
