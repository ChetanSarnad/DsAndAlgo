package LinkedList;

/*
Class to demonstrate Floyds algorithm for loop detection in linked list.

Here we would be having two pointers, slow pointer and fast pointer.

In the begining both point to head node, then slow pointer moves by one node and fast moves two nodes at a time.

Finally at some point the fast pointer catches up and meets slow pointer. If both meet then it has a loop.

If no loop then the fast pointer will reach the null end and we conclude it to be having no loops
 */
public class LoopDetectionFloyd {

    static boolean findLoopUsingFloyds(CLLNode headNode){

        CLLNode slowPointer = headNode;

        CLLNode fastPointer = headNode;

        while (fastPointer != null && fastPointer.nextNode != null){

            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;

            if (slowPointer == fastPointer){
                System.out.println("Matched at node : " + slowPointer.data);
                return true;
            }
        }

        return false;
    }


    /*
    Testing with circular linked list for now, ideally should be a list which has some loop in between
     */
    public static void main(String[] args) {

        CircularLinkedListDS circularLinkedListDS = new CircularLinkedListDS();

        System.out.println("Add four nodes to the start and print list");
        CLLNode cllNode1 = new CLLNode(1);
        CLLNode cllNode2 = new CLLNode(2);
        CLLNode cllNode3 = new CLLNode(3);
        CLLNode cllNode4 = new CLLNode(4);

        circularLinkedListDS.addNodeToStart(cllNode1);
        circularLinkedListDS.addNodeToStart(cllNode2);
        circularLinkedListDS.addNodeToStart(cllNode3);
        circularLinkedListDS.addNodeToStart(cllNode4);

        circularLinkedListDS.printList();

        boolean hasLoop = findLoopUsingFloyds(cllNode4);

        if (hasLoop){
            System.out.println("The list has a loop");
        }else {
            System.out.println("No loop detected in the linked list");
        }
    }

}
