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

    /*
    Method to add a node to the start of linked list
     */
    void addNodeAtStart(Node node) {

        //If headNode is null, the list is empty, assign the new node to headNode
        if (headNode == null) {
            headNode = node;
        }
        // Else put the new node as headNode and point its nextNode pointer to the old headNode
        else {
            Node tempNode = headNode;
            headNode = node;
            headNode.nextNode = tempNode;
        }
        // Increment the size of linked list
        lenOfList++;
    }

    /*
    Method to add a node to the end of linked list
     */
    void addNodeAtEnd(Node node) {
        //If headNode is null, the list is empty, assign the new node to headNode
        if (headNode == null) {
            headNode = node;
        }
        // Else, traverse to the end of list and point next of last node to the new node
        else {
            //Traverse to the end of the node
            Node currentNode = headNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = node;
        }
        // Increment the size of linked list
        lenOfList++;
    }


    // Method to add a node to desired position/index
    void addNodeAtPosition(Node node, int position) {

        //If headNode is null, the list is empty, assign the new node to headNode
        if (headNode == null) {
            headNode = node;
            lenOfList++;
            return;
        }

        // Else if the linked list is not empty
        else {

            // If node is to be added at 0th position, call addNodeAtStart method
            if (position == 0) {
                addNodeAtStart(node);
            }

            // Else, for positions other than 0th
            else {
                Node currentNode = headNode;

                // For other cases, loop through list until you reach the desired position
                int index = 0;
                while (currentNode.nextNode != null) {

                    Node previousNode = currentNode;
                    currentNode = currentNode.nextNode;
                    index++;

                    // If desired position, point previous node to new node, and point next of new node to current.
                    if (index == position) {
                        previousNode.nextNode = node;
                        node.nextNode = currentNode;
                        lenOfList++;
                        return;
                    }
                }
                // Finally if no positions match, then add it at the end;
                currentNode.nextNode = node;
                lenOfList++;
                return;
            }

        }
    }


    // Method to delete node at the start of the list
    void deleteNodeAtStart(){
        if (headNode != null){
            headNode = headNode.nextNode;
            lenOfList--;
        }
    }

    // Method to delete node at the end of list
    void deleteNodeAtEnd(){

        // If no elements, then return
        if (headNode == null){
            return;
        }

        // If only one element, i.e. headNode present, set headNode to null and return
        if (headNode.nextNode == null){
            headNode = null;
            lenOfList--;
            return;
        }

        // For other case, Reach the end of linked list, point the node one behind last node to null, thus deleting last node.
        Node current = headNode;
        Node previous = headNode;
        while (current.nextNode != null){
            previous = current;
            current = current.nextNode;
        }
        previous.nextNode = null;
        lenOfList--;
        return;
    }


    // Method to delete a node at particular position
    void deleteNodeAtPosition(int position){

        // If list is empty
        if (headNode == null){
            return;
        }

        // If only one element i.e. headNode present, set it to null
        if (headNode.nextNode == null){
            headNode = null;
            lenOfList--;
            return;
        }

        // Else loop through the list to reach the expected position
        Node currentNode = headNode;
        Node previousNode = headNode;
        int index = 0;
        while (currentNode.nextNode != null){
            index++;
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
            if (index == position){
                previousNode.nextNode = currentNode.nextNode;
            }
        }
    }

    void printList() {
        // Get hold of the headNode to start with
        Node currentNode = headNode;
        System.out.println("The Linked List : ");
        // Keep looping and printing till the next node does not point to a null value
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        }
        System.out.println("\n");
    }

}

/*
This is the main class, used to demonstrate all the methods of linked list
 */
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

        System.out.println("SinglyLinkedList.main : Print after adding 5 nodes at Start");
        singlyLinkedListDataStructure.printList();

        Node node6 = new Node(6);
        Node node7 = new Node(7);

        singlyLinkedListDataStructure.addNodeAtEnd(node6);
        singlyLinkedListDataStructure.addNodeAtEnd(node7);

        System.out.println("SinglyLinkedList.main : Print after adding 2 nodes at End");
        singlyLinkedListDataStructure.printList();

        Node node8 = new Node(8);

        singlyLinkedListDataStructure.addNodeAtPosition(node8, 3);

        System.out.println("SinglyLinkedList.main : Print after adding node at index 3");
        singlyLinkedListDataStructure.printList();

        singlyLinkedListDataStructure.deleteNodeAtStart();

        System.out.println("SinglyLinkedList.main : Print after deleting node at the start");
        singlyLinkedListDataStructure.printList();

        singlyLinkedListDataStructure.deleteNodeAtEnd();

        System.out.println("SinglyLinkedList.main : Print after deleting node at the end");
        singlyLinkedListDataStructure.printList();

        singlyLinkedListDataStructure.deleteNodeAtPosition(3);

        System.out.println("SinglyLinkedList.main : Print after deleting node at the position 3");
        singlyLinkedListDataStructure.printList();


    }

}
