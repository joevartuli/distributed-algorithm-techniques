package au.com.ngage.data.store.persistence;

/**
 * User: Joseph Vartuli
 * Date: 20/04/13
 *
 * @since:
 */
public interface DataPersistence<K, D> {

    D get(K key);

    void put(K key, D data);

    void delete(K key);
}
