package parkinglot.design.command;

/**
 * Created by hareesh.pammi on 6/19/19.
 */
public interface BaseCommand<T> {
    void execute(T value);
}
