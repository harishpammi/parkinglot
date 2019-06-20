package parkinglot.design;

import com.google.inject.Guice;
import com.google.inject.Injector;
import parkinglot.design.command.CommandsCollection;
import parkinglot.design.command.CreateParkingLotCommand;
import parkinglot.design.module.ParkingLotModule;
import parkinglot.design.service.Actions;

import static parkinglot.design.util.InputActionCommands.CREATE_PARKING_LOT;

/**
 * Created by hareesh.pammi on 6/19/19.
 */
public class Application {
    public static void main(String[] args) {
        System.out.printf("Starting Main Application");
        new Application().run();

    }

    public void run() {
        Injector injector = Guice.createInjector(new ParkingLotModule());
        initiateCommandsMap(injector);
        Actions actions = injector.getInstance(Actions.class);
        actions.performAction("create_parking_lot 6");
    }

    private void initiateCommandsMap(Injector injector) {
        CommandsCollection commandsCollection = injector.getInstance(CommandsCollection.class);
        commandsCollection.put(CREATE_PARKING_LOT, injector.getInstance(CreateParkingLotCommand.class));
    }
}
