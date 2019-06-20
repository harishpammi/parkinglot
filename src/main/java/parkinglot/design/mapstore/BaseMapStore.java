package parkinglot.design.mapstore;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hareesh.pammi on 6/19/19.
 */
public abstract class BaseMapStore<K, V> {
    protected ConcurrentHashMap<K, V> baseMap;

    public BaseMapStore() {
        this.baseMap = new ConcurrentHashMap<>();
    }

    public void store(K key, V value) {
        if (value != null) {
            baseMap.put(key, value);
        }

    }

    public V get(K key) {
        return baseMap.get(key);
    }

    public void remove(K key) {
        baseMap.remove(key);
    }
}
