package parkinglot.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import parkinglot.ParkingLotTestModule;
import parkinglot.design.command.*;

import static parkinglot.design.util.InputActionCommands.*;

/**
 * Created by hareesh.pammi on 6/24/19.
 */
public class BaseServiceImplTest {
    protected static Injector injector;

    public static void setup() {
        injector = Guice.createInjector(new ParkingLotTestModule());
        initiateCommandsMap(injector);
    }

    private static void initiateCommandsMap(Injector injector) {
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
