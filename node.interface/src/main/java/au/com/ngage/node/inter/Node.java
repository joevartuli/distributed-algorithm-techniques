package au.com.ngage.node.inter;

import au.com.ngage.data.store.inter.DataStore;

import java.util.UUID;

/**
 * User: Joseph Vartuli
 * Date: 20/04/13
 *
 * @since:
 */
public interface Node<K, V> extends DataStore<K, V> {

    UUID getId();

}
