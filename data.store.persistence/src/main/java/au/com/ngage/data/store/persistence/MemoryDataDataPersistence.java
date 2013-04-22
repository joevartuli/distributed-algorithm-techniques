package au.com.ngage.data.store.persistence;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Joseph Vartuli
 * Date: 20/04/13
 *
 * @since:
 */
public class MemoryDataDataPersistence<K, V> implements DataPersistence<K, V> {

    private final Map<K, V> dataStore;

    public MemoryDataDataPersistence() {
        this.dataStore = new HashMap<>();
    }

    @Override
    public V get(K key) {
        return dataStore.get(key);
    }

    @Override
    public void put(K key, V data) {
        dataStore.put(key, data);
    }

    @Override
    public void delete(K key) {
        dataStore.remove(key);
    }
}
