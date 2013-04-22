package au.com.ngage.data.store.node;

import au.com.ngage.node.inter.Node;
import au.com.ngage.data.store.persistence.DataPersistence;
import au.com.ngage.node.management.selector.KeyNodeSelector;

import java.util.UUID;

/**
 * User: Joseph Vartuli
 * Date: 20/04/13
 *
 * @since:
 */
public class LocalNode<K, V> implements Node<K, V> {

    private final UUID id;
    private final KeyNodeSelector<K, V> keyNodeSelector;
    private final DataPersistence<K, V> persistor;

    public LocalNode(final UUID id,
                     KeyNodeSelector<K, V> keyNodeSelector, final DataPersistence<K, V> dataPersistence) {
        this.id = id;
        this.keyNodeSelector = keyNodeSelector;
        this.persistor = dataPersistence;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public V get(final K key) {
        Node<K, V> owner = keyNodeSelector.getKeyNode(key);
        if (owner.getId().equals(id)) {
            System.out.println("Retrieved from " + id);
            return persistor.get(key);
        }
        return owner.get(key);
    }

    @Override
    public void put(final K key, final V data) {
        Node<K, V> owner = keyNodeSelector.getKeyNode(key);
        if (owner.getId().equals(id)) {
            System.out.println("Pushed to " + id);
            persistor.put(key, data);
            return;
        }
        owner.put(key, data);
    }

    @Override
    public void delete(final K key) {

    }
}
