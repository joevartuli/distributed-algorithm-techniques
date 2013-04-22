package au.com.ngage;

import au.com.ngage.data.store.node.LocalNode;
import au.com.ngage.data.store.persistence.DataPersistence;
import au.com.ngage.data.store.persistence.MemoryDataDataPersistence;
import au.com.ngage.node.inter.Node;
import au.com.ngage.node.management.selector.KeyNodeSelector;

import static java.util.UUID.randomUUID;

/**
 * User: Joseph Vartuli
 * Date: 20/04/13
 *
 * @since:
 */
public class Main {

    public static void main(final String[] args) {


        final KeyNodeSelector<String, String> keyNodeSelector = new KeyNodeSelector<>();

        final DataPersistence<String, String> dataPersistenceA = new MemoryDataDataPersistence<>();
        final DataPersistence<String, String> dataPersistenceB = new MemoryDataDataPersistence<>();
        final DataPersistence<String, String> dataPersistenceC = new MemoryDataDataPersistence<>();

        final Node<String, String> nodeA = new LocalNode<>(randomUUID(), keyNodeSelector, dataPersistenceA);
        final Node<String, String> nodeB = new LocalNode<>(randomUUID(), keyNodeSelector, dataPersistenceB);
        final Node<String, String> nodeC = new LocalNode<>(randomUUID(), keyNodeSelector, dataPersistenceC);


        keyNodeSelector.add(nodeA);
        keyNodeSelector.add(nodeB);
        keyNodeSelector.add(nodeC);

        System.out.println("node A " + nodeA.getId());
        System.out.println("node B " + nodeB.getId());
        System.out.println("node C " + nodeC.getId());

        nodeA.put("1", "one");
        nodeB.put("2", "two");
        nodeC.put("3", "three");


        System.out.println("1: " + nodeB.get("1"));
        System.out.println("2: " + nodeA.get("2"));
        System.out.println("3: " + nodeC.get("3"));

    }
}
