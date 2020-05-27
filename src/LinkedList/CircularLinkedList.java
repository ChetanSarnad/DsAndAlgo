package LinkedList;

/*
 Here we will have a look at the circular linked list.
 Unlike the singly and doubly linked list, where in the tail node points to null,
 Here the tail node points to the head node again, making it circular.

 The tail node becomes critical for navigation. The node next to tail node is considered as head node.

 The list is considered empty if tail node is null.

 Adding node to start means making the node as next node of tail node.
 The node will be added after the tail node, since we assume tail points to head. And this node should be new head

 Adding node to end means making the node as the tail node.
 */


class CLLNode{

    int data;

    CLLNode nextNode;

    public CLLNode(int data) {
        this.data = data;
    }
}


class CircularLinkedListDS{

    CLLNode tail;

    int lenOfList;

    /*
    Add node to start of list
    The node will be added after the tail node, since we assume tail points to head. And this node should be new head
     */
    void addNodeToStart(CLLNode node){
        if (tail == null){
            tail = node;
            tail.nextNode = node;
            lenOfList++;
            return;
        }

        node.nextNode = tail.nextNode;
        tail.nextNode = node;
    }

    /*
    Add node to the end of list.
    The new node should be set as the tail node
     */
    void addNodeToEnd(CLLNode node){
        //If no nodes in the list
        if (tail == null){
            tail = node;
            tail.nextNode = node;
            lenOfList++;
            return;
        }

        // Make new node the tail node and point it to the node, the old tail node was poiting to.
        // Also the old tail node should point to new tail node.
        CLLNode tempNode = tail;
        tail = node;
        tail.nextNode = tempNode.nextNode;
        tempNode.nextNode = tail;
        lenOfList++;
        return;
    }


    /*
    Method to delete the node at the start of list i.e. head i.e. the node after the tail node.
     */
    void deleteNodeAtStart(){
        // If list empty, return without doing anything
        if (tail == null){
            System.out.println("The list is empty");
            return;
        }

        // If length is 1, i.e. only one element, delete tail and return
        if (lenOfList == 1){
            tail = null;
            lenOfList--;
            return;
        }

        // Other cases, We should delete headNode i.e. the node after tail node.
        // So tail node should now point to the node after the headNode directly, thereby letting go of current headNode
        CLLNode headNode = tail.nextNode;
        tail.nextNode = headNode.nextNode;
        headNode.nextNode = null;
        headNode = null;


    }

    /*
    Method to delete the node at the end of list, i.e. delete the tail node
     */
    void deleteNodeAtEnd(){
        // If list empty, return without doing anything
        if (tail == null){
            System.out.println("The list is empty");
            return;
        }

        // If length is 1, i.e. only one element, delete tail and return
        if (lenOfList == 1){
            tail = null;
            lenOfList--;
            return;
        }

        // Other cases, we would need access to the node before tail node,
        // So we could point that nodes next pointer to node after the tail node and also mark it as tail node
        CLLNode tempNode = tail;
        while (tempNode.nextNode != tail){
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = tail.nextNode;
        tail = tempNode;

    }

    /*
    Method to print all the elements in circular list
     */
    void printList(){
        if (tail == null){
            System.out.println("List empty");
            return;
        }
        System.out.println("\n");
        System.out.println("Print the list");
        CLLNode currentNode = tail;
        currentNode = currentNode.nextNode;
        // Continue until the list node reaches back to tail
        while (currentNode != tail){
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        }
        System.out.println(currentNode.data);
        System.out.println("\n");
    }

}

/*
Main class to demonstrate all the functionality of CLL
 */
public class CircularLinkedList {

    public static void main(String[] args) {

        CircularLinkedListDS circularLinkedListDS = new CircularLinkedListDS();

        System.out.println("Add three nodes to the start and print list");
        CLLNode cllNode1 = new CLLNode(1);
        CLLNode cllNode2 = new CLLNode(2);
        CLLNode cllNode3 = new CLLNode(3);
        CLLNode cllNode4 = new CLLNode(4);

        circularLinkedListDS.addNodeToStart(cllNode1);
        circularLinkedListDS.addNodeToStart(cllNode2);
        circularLinkedListDS.addNodeToStart(cllNode3);
        circularLinkedListDS.addNodeToStart(cllNode4);

        circularLinkedListDS.printList();

        System.out.println("Add a node to the end of list and print list");
        CLLNode cllNode5 = new CLLNode(4);
        circularLinkedListDS.addNodeToEnd(cllNode5);

        circularLinkedListDS.printList();

        System.out.println("Delete a node at the start of circular linked list");
        circularLinkedListDS.deleteNodeAtStart();

        circularLinkedListDS.printList();

        System.out.println("Delete a node at the end of circular linked list");
        circularLinkedListDS.deleteNodeAtEnd();

        circularLinkedListDS.printList();
    }

}
