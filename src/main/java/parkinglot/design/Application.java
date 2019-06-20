package parkinglot.design;

import com.google.inject.Guice;
import com.google.inject.Injector;
import parkinglot.design.module.ParkingLotModule;

/**
 * Created by hareesh.pammi on 6/19/19.
 */
public class Application {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ParkingLotModule());
        System.out.printf("Starting Main Application");


    }
}
