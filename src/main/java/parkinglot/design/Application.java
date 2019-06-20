package parkinglot.design;

import com.google.inject.Guice;
import com.google.inject.Injector;
import parkinglot.design.command.*;
import parkinglot.design.module.ParkingLotModule;
import parkinglot.design.service.Actions;

import static parkinglot.design.util.InputActionCommands.*;

/**
 * Created by hareesh.pammi on 6/19/19.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Starting Main Application");
        new Application().run();

    }

    public void run() {
        Injector injector = Guice.createInjector(new ParkingLotModule());
        initiateCommandsMap(injector);
        Actions actions = injector.getInstance(Actions.class);
        actions.performAction("create_parking_lot 6");
        actions.performAction("park KA-01-HH-1234 White");
        actions.performAction("park KA-01-HH-9999 White");
        actions.performAction("park KA-01-BB-0001 Black");
        actions.performAction("park KA-01-HH-7777 Red");
        actions.performAction("park KA-01-HH-2701 Blue");
        actions.performAction("park KA-01-HH-3141 Black");
        actions.performAction("leave 4");
        actions.performAction("status");
        actions.performAction("park KA-01-P-333 White");
        actions.performAction("park DL-12-AA-9999 White");
        actions.performAction("registration_numbers_for_cars_with_colour White");
        actions.performAction("slot_numbers_for_cars_with_colour White");
        actions.performAction("slot_number_for_registration_number KA-01-HH-3141");
        actions.performAction("slot_number_for_registration_number MH-04-AY-1111");
    }

    private void initiateCommandsMap(Injector injector) {
        CommandsCollection commandsCollection = injector.getInstance(CommandsCollection.class);
        commandsCollection.put(CREATE_PARKING_LOT, injector.getInstance(CreateParkingLotCommand.class));
        commandsCollection.put(PARK, injector.getInstance(ParkCommand.class));
        commandsCollection.put(LEAVE, injector.getInstance(LeaveCommand.class));
        commandsCollection.put(STATUS, injector.getInstance(StatusCommand.class));
        commandsCollection.put(CAR_REG_NUMS_BY_COLOR, injector.getInstance(CarRegNumbersByColorCommand.class));
        commandsCollection.put(SLOT_FOR_REG_NUM, injector.getInstance(SlotForRegNumberCommand.class));
        commandsCollection.put(SLOTS_BY_COLOR, injector.getInstance(SlotsByColorCommand.class));

    }
}
