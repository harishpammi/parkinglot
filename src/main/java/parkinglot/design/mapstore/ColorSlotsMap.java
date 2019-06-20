package parkinglot.design.mapstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hareesh.pammi on 6/19/19.
 */
public class ColorSlotsMap extends BaseMapStore<String, List<Integer>> {
    public ColorSlotsMap() {
        super();
    }

    public void append(String key, Integer value) {
        List<Integer> existingValues = get(key);
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add(value);
        store(key, existingValues);
    }

    public void removeValueFromKey(String key, Integer value) {
        List<Integer> existingValues = get(key);
        if (existingValues != null) {
            existingValues.remove(value);
            store(key, existingValues);
        }
    }
}
