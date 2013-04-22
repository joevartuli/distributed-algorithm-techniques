package au.com.ngage.node.management.selector;

import au.com.ngage.node.inter.Node;
import com.google.common.hash.HashCode;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.hash.Hashing.consistentHash;
import static com.google.common.hash.Hashing.sha256;

/**
 * User: Joseph Vartuli
 * Date: 20/04/13
 *
 * @since:
 */
public class KeyNodeSelector<K, V> {

    private final List<Node<K, V>> nodes;

    public KeyNodeSelector() {
        this.nodes = new ArrayList<>();
    }

    public Node<K, V> getKeyNode(final K key) {
        final HashCode hashCode = sha256().hashInt(key.hashCode());
        int bucket = consistentHash(hashCode, nodes.size());
        return nodes.get(bucket);
    }

    public void add(Node<K, V> node) {
        nodes.add(node);
    }


}
