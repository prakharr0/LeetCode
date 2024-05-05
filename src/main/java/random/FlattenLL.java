package random;

/**
 * LeetCode 430: Flatten a multilevel Doubly LL

 * You are given a doubly linked list, which contains nodes that have
 * a next pointer, a previous pointer, and an additional child pointer.
 * This child pointer may or may not point to a separate doubly linked list,
 * also containing these special nodes. These child lists may have one or
 * more children of their own, and so on, to produce a multilevel data structure
 * as shown in the example below.

 * Given the head of the first level of the list, flatten the list so that all
 * the nodes appear in a single-level, doubly linked list. Let curr be a node
 * with a child list. The nodes in the child list should appear after curr and
 * before curr.next in the flattened list.

 * Return the head of the flattened list. The nodes in the list must have all
 * of their child pointers set to null.
 *
 * @author rathi.prakhar@outlook.com
 */
public class FlattenLL {

    static class Node {
        private int val;
        private Node prev;
        private Node next;
        private Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node1.next = node2;
        node2.prev = node1;

        node2.next = node3;
        node3.prev = node2;
        node3.child = node7;

        node7.next = node8;
        node8.prev = node7;
        node8.child = node11;

        node11.next = node12;
        node12.prev = node11;

        node8.next = node9;
        node9.prev = node8;

        node9.next = node10;
        node10.prev = node9;

        node3.next = node4;
        node4.prev = node3;

        node4.next = node5;
        node5.prev = node4;

        node5.next = node6;
        node6.prev = node5;

        new FlattenLL().flatten(node1);
    }

    public Node flatten(Node head) {
        return dfs(head);
    }

    private Node dfs(Node node) {
        if (node == null) return node;
        Node temp = node;
        Node next = node.next;
        Node child = node.child;

        if (child != null) {
            node.next = dfs(child);
            node.next.prev = node;
            node.child = null;

            while (node.next != null) node = node.next;
        }

        if (next != null){
            node.next = dfs(next);
            node.next.prev = node;
        }

        return temp;
    }
}
