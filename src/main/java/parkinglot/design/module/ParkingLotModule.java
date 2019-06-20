package parkinglot.design.module;

import com.google.inject.AbstractModule;
import parkinglot.design.service.ParkingLot;
import parkinglot.design.service.impl.ParkingLotImpl;

/**
 * Created by hareesh.pammi on 6/20/19.
 */
public class ParkingLotModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ParkingLot.class).to(ParkingLotImpl.class);
    }
}
