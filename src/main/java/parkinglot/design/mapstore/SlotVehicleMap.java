package parkinglot.design.mapstore;

import parkinglot.design.dto.VehicleDTO;

import java.util.Map;
import java.util.Set;

/**
 * Created by hareesh.pammi on 6/21/19.
 */
public class SlotVehicleMap extends BaseMapStore<Integer, VehicleDTO> {
    public SlotVehicleMap() {
        super();
    }

    public Set<Map.Entry<Integer, VehicleDTO>> getEntrySet() {
        return baseMap.entrySet();
    }
}
