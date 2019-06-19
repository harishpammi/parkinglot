package parkinglot.design.mapstore;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hareesh.pammi on 6/19/19.
 */
public abstract class BaseMapStore<K, V> {
    private final ConcurrentHashMap<K, V> baseMap = new ConcurrentHashMap<K, V>();

    public void store(K key, V value) {
        if (value == null) {
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
