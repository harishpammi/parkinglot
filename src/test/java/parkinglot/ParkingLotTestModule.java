package parkinglot;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import parkinglot.design.command.*;
import parkinglot.design.mapstore.ColorSlotsMap;
import parkinglot.design.mapstore.RegNumberSlotMap;
import parkinglot.design.mapstore.SlotVehicleMap;
import parkinglot.design.service.Actions;
import parkinglot.design.service.ParkingLot;
import parkinglot.design.service.impl.ActionsImpl;
import parkinglot.design.service.impl.ParkingLotImpl;

/**
 * Created by hareesh.pammi on 6/24/19.
 */
public class ParkingLotTestModule extends AbstractModule {
    @Override
    protected void configure() {
        CommandsCollection commandsCollection = CommandsCollection.getInstance();
        bind(CommandsCollection.class).toInstance(commandsCollection);
        bindCommands();
        bind(ParkingLot.class).to(ParkingLotImpl.class).in(Scopes.SINGLETON);
        bind(Actions.class).to(ActionsImpl.class);
        bindMapStores();
    }

    private void bindMapStores() {
        bind(ColorSlotsMap.class).in(Scopes.SINGLETON);
        bind(RegNumberSlotMap.class).in(Scopes.SINGLETON);
        bind(SlotVehicleMap.class).in(Scopes.SINGLETON);
    }

    private void bindCommands() {
        bind(CreateParkingLotCommand.class);
        bind(ParkCommand.class);
        bind(CarRegNumbersByColorCommand.class);
        bind(LeaveCommand.class);
        bind(SlotForRegNumberCommand.class);
        bind(SlotsByColorCommand.class);
        bind(StatusCommand.class);
    }
}
