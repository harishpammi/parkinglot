package parkinglot.design.module;

import com.google.inject.AbstractModule;
import parkinglot.design.command.CommandsCollection;
import parkinglot.design.command.CreateParkingLotCommand;
import parkinglot.design.service.Actions;
import parkinglot.design.service.ParkingLot;
import parkinglot.design.service.impl.ActionsImpl;
import parkinglot.design.service.impl.ParkingLotImpl;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class ParkingLotModule extends AbstractModule {
    @Override
    protected void configure() {
        CommandsCollection commandsCollection = CommandsCollection.getInstance();
        bind(CommandsCollection.class).toInstance(commandsCollection);
        bindCommands();
        bind(ParkingLot.class).to(ParkingLotImpl.class);
        bind(Actions.class).to(ActionsImpl.class);

    }

    private void bindCommands() {
        bind(CreateParkingLotCommand.class);
    }
}
