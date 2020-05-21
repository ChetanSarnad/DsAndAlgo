/*
So what are we doing here?

We are demonstrating on how to construct a linked list from scratch in java.

Capabilities provided :

1. Add node at the start

2. Add node at the end

3. Add node in the middle, i.e. after a particular node

4. Delete node at the start

5. Delete node at the end

6. Delete node in the middle, i.e. after a particular node

7. Print the list of all nodes in the linked list
 */

package LinkedList;

// This is the node which will be added to linked list.
class Node {

    int data;

    Node nextNode;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class SinglyLinkedListDataStructure {

    int lenOfList;

    Node headNode;

    void addNodeAtStart(Node node) {

        if (headNode == null) {
            headNode = node;
        } else {
            Node tempNode = headNode;
            headNode = node;
            headNode.nextNode = tempNode;
        }
        lenOfList++;
    }

    void addNodeAtEnd(Node node) {
        if (headNode == null) {
            headNode = node;
        } else {
            //Traverse to the end of the node
            Node currentNode = headNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = node;
        }
    }

    void printList() {
        Node currentNode = headNode;
        System.out.println("The Linked List : ");
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        }
    }

}

public class SinglyLinkedList {

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

        Node node6 = new Node(6);
        Node node7 = new Node(7);

        singlyLinkedListDataStructure.addNodeAtEnd(node6);
        singlyLinkedListDataStructure.addNodeAtEnd(node7);

        singlyLinkedListDataStructure.printList();


    }

}
