/*
Class to represent a doubly linked list, i.e. each Node having pointer to next and previous node
 */
package LinkedList;

class DoublyLinkedNode {

    int data;

    DoublyLinkedNode nextNode;

    DoublyLinkedNode previousNode;

    public DoublyLinkedNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLinkedNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyLinkedNode nextNode) {
        this.nextNode = nextNode;
    }

    public DoublyLinkedNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoublyLinkedNode previousNode) {
        this.previousNode = previousNode;
    }
}

class DoublyLinkedListDS {

    DoublyLinkedNode headNode;

    DoublyLinkedNode tailNode;

    int lenOfList;

    /*
    Method to add the node at start
    The existing headNode's previous should now point to new node
    New nodes nextNode to point to existing headNode
    New node should be marked as headNode
     */
    void addNodeAtStart(DoublyLinkedNode node) {
        // If list is empty, set the head and tail nodes to new node, increase the list size and return
        if (headNode == null){
            headNode = node;
            tailNode = node;
            lenOfList++;
            return;
        }

        DoublyLinkedNode tempNode = headNode;
        headNode = node;
        headNode.nextNode = tempNode;
        tempNode.previousNode = headNode;
        lenOfList++;
        return;
    }


    /*
    Method to add a node at the end of list, i.e. set it as the tail node
     */
    void addNodeAtTail(DoublyLinkedNode node){

        // If list is empty, set the head and tail nodes to new node, increase the list size and return
        if (headNode == null){
            headNode = node;
            tailNode = node;
            lenOfList++;
            return;
        }

        DoublyLinkedNode tempNode = tailNode;
        tailNode = node;
        tailNode.previousNode = tempNode;
        tempNode.nextNode = tailNode;
        lenOfList++;
        return;
    }

    void addNodeAtPosition(DoublyLinkedNode node, int position){

        // If to be added at 0th position, call the addNodeAtStart method
        if (position == 0){
            addNodeAtStart(node);
            return;
        }

        DoublyLinkedNode currentNode = headNode;
        int index = 0;
        while (currentNode != null){
            if (index == position){
                DoublyLinkedNode previousNodeForCurrent = currentNode.previousNode;
                previousNodeForCurrent.nextNode = node;
                node.nextNode = currentNode;
                node.previousNode = previousNodeForCurrent;
                currentNode.previousNode = node;
                lenOfList++;
                return;
            }
            currentNode = currentNode.nextNode;
            index++;
        }

        // If the position did not match, add at the end. Happens mostly when position greater than length of list
        addNodeAtTail(node);
    }


    /*
    Method to delete the node at the start, i.e. delete the headNode
     */
    void deleteNodeAtStart(){
        if (lenOfList > 0){
            headNode = headNode.nextNode;
            if (headNode != null){
                headNode.previousNode = null;
            }
        }
    }


    /*
    Method to delete the node at the end, i.e. delete the tail node
     */
    void deleteNodeAtEnd(){
        if (lenOfList > 0){
            tailNode = tailNode.previousNode;
            if (tailNode != null){
                tailNode.nextNode = null;
            }
        }
    }

    /*
    Method to delete a node a particular position in linked list
     */
    void deleteNodeAtPosition(int position){
        if (position == 0){
            deleteNodeAtStart();
            return;
        }
        else if (position >= (lenOfList - 1)){
            deleteNodeAtEnd();
            return;
        }

        DoublyLinkedNode currentNode = headNode;
        int index = 0;
        if (lenOfList > 0){
            while (currentNode != null){
                if (index == position){
                    DoublyLinkedNode previousNodeOfCurrent = currentNode.previousNode;
                    DoublyLinkedNode nextNodeOfCurrent = currentNode.nextNode;
                    previousNodeOfCurrent.nextNode = nextNodeOfCurrent;
                    nextNodeOfCurrent.previousNode = previousNodeOfCurrent;
                }
                index++;
                currentNode = currentNode.nextNode;
            }
        }
    }


    void printList(){
        DoublyLinkedNode currentNode = headNode;
        System.out.println("\n");
        System.out.println("Linked list starting from headNode");
        while (currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        }
        System.out.println("\n");
    }

    void printListFromTail(){
        DoublyLinkedNode currentNode = tailNode;
        System.out.println("\n");
        System.out.println("Linked list starting from tailNode");
        while (currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.previousNode;
        }
        System.out.println("\n");
    }
}

public class DoublyLinkedList {

    public static void main(String[] args) {

        DoublyLinkedListDS doublyLinkedListDS = new DoublyLinkedListDS();

        DoublyLinkedNode doublyLinkedNode1 = new DoublyLinkedNode(1);
        DoublyLinkedNode doublyLinkedNode2 = new DoublyLinkedNode(2);
        DoublyLinkedNode doublyLinkedNode3 = new DoublyLinkedNode(3);

        doublyLinkedListDS.addNodeAtStart(doublyLinkedNode1);
        doublyLinkedListDS.addNodeAtStart(doublyLinkedNode2);
        doublyLinkedListDS.addNodeAtStart(doublyLinkedNode3);

        System.out.println("Added three nodes at the start");

        doublyLinkedListDS.printList();
        doublyLinkedListDS.printListFromTail();

        DoublyLinkedNode doublyLinkedNode4 = new DoublyLinkedNode(4);

        doublyLinkedListDS.addNodeAtTail(doublyLinkedNode4);

        System.out.println("Added one node at the end");

        doublyLinkedListDS.printList();
        doublyLinkedListDS.printListFromTail();

        DoublyLinkedNode doublyLinkedNode5 = new DoublyLinkedNode(5);

        doublyLinkedListDS.addNodeAtPosition(doublyLinkedNode5, 2);

        System.out.println("Added one node at position 2");

        doublyLinkedListDS.printList();
        doublyLinkedListDS.printListFromTail();

        doublyLinkedListDS.deleteNodeAtStart();

        System.out.println("Delete one node at the start");

        doublyLinkedListDS.printList();
        doublyLinkedListDS.printListFromTail();

        System.out.println("Delete one node at the end");

        doublyLinkedListDS.deleteNodeAtEnd();

        doublyLinkedListDS.printList();
        doublyLinkedListDS.printListFromTail();

        System.out.println("Delete one node at the position 1");

        doublyLinkedListDS.deleteNodeAtPosition(1);

        doublyLinkedListDS.printList();
        doublyLinkedListDS.printListFromTail();
    }
}
