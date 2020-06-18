package LinkedList.BasicImplementations;

public class ReverseLinkedList {

    /*
    Method to reverse a linked list.
     */
    static Node reverseList(Node headNode) {
        // currentNode will be the headNode
        Node currentNode = headNode;

        // previousNode will be null initially, i.e. the node before headNode
        Node previousNode = null;

        // start looping,
        while (currentNode != null) {

            // First save the next node of current
            Node nextNode = currentNode.nextNode;

            // point the next of current to previous node, this is the reversing step
            currentNode.nextNode = previousNode;

            // set the previous node to current node
            previousNode = currentNode;

            // Move the current node to next node and continue with loop if not null
            currentNode = nextNode;

        }

        // return the previous node, which will be new head
        return previousNode;

    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        SinglyLinkedListDataStructure singlyLinkedListDataStructure = new SinglyLinkedListDataStructure();

        singlyLinkedListDataStructure.addNodeAtStart(node1);
        singlyLinkedListDataStructure.addNodeAtStart(node2);
        singlyLinkedListDataStructure.addNodeAtStart(node3);
        singlyLinkedListDataStructure.addNodeAtStart(node4);
        singlyLinkedListDataStructure.addNodeAtStart(node5);

        System.out.println("SinglyLinkedList.main : Print after adding 5 nodes at Start");
        singlyLinkedListDataStructure.printList();

        System.out.println("Reverse the list");
        Node newHeadNode = reverseList(node5);
        singlyLinkedListDataStructure.headNode = newHeadNode;

        System.out.println("SinglyLinkedList.main : Print after adding 5 nodes at Start");
        singlyLinkedListDataStructure.printList();
    }
}

