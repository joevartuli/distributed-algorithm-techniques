package au.com.ngage.data.store.inter;

/**
 * User: Joseph Vartuli
 * Date: 20/04/13
 *
 * @since:
 */
public interface DataStore<K, V> {

    V get(K key);

    void put(K key, V data);

    void delete(K key);

}
