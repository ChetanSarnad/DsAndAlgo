package Stacks.BasicImplementations;

/*
Linked list node to be used in stack implementation
 */
class Node {

    int data;

    Node nextNode;

    public Node(int data) {
        this.data = data;
    }
}

/*
Implementation of stack using linked list
 */
class StackList {

    // Length of stack
    int lengthOfStack;

    // top element
    Node top;

    // Constructor
    StackList() {
        lengthOfStack = 0;
        top = null;
    }

    // Method to push data on stack
    void push(int data) {
        // Create a node from data to be pushed
        Node dataNode = new Node(data);

        // Save the current top in a temp node
        Node tempNode = top;

        // Set the current data node as top and point the next of it to old top node
        top = dataNode;
        top.nextNode = tempNode;

        // increment the length of stack
        lengthOfStack++;
    }

    /*
    Method to pop data out of stack
     */
    int pop() throws Exception {

        // throw exception if stack is empty, since nothing to peek or pop
        if (isEmpty()) {
            throw new Exception("The stack is empty !!!");
        }

        // Save current top in temp node
        Node temp = top;

        // Set the next node to top as the new top, this is like deleting the old top
        top = top.nextNode;

        // Decrement the length
        lengthOfStack--;

        // return the value of old top that was popped
        return temp.data;
    }

    /*
    Method to peek top data
    */
    int peek() throws Exception {

        // throw exception if stack is empty, since nothing to peek or pop
        if (isEmpty()) {
            throw new Exception("The stack is empty !!!");
        }

        // return the value of top
        return top.data;
    }

    /*
    Method to check if stack is empty
     */
    boolean isEmpty() {
        return lengthOfStack == 0;
    }

    /*
    Method to print all elements in stack
     */
    void printStack() {
        System.out.println("\n Stack :");
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.nextNode;
        }
    }

}

/*
Class to demostrate the operations on stack using linked list
 */
public class StackUsingLinkedList {

    public static void main(String[] args) throws Exception {

        System.out.println("Create a stack");

        StackList stackList = new StackList();

        System.out.println("\n Add three elements to stack");

        stackList.push(1);
        stackList.push(2);
        stackList.push(3);

        System.out.println("\n Print the stack ");
        stackList.printStack();

        System.out.println("\n Peek the stack");
        int peekValue = 0;
        try {
            peekValue = stackList.peek();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n Peek value : " + peekValue);

        System.out.println("\n Pop an element from stack");

        stackList.pop();

        stackList.printStack();

        System.out.println("\n Pop an element from stack");

        stackList.pop();

        stackList.printStack();

        System.out.println("\n Pop an element from stack");

        stackList.pop();

        stackList.printStack();

        System.out.println("\n Pop an element from stack");

        try {
            stackList.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        stackList.printStack();

    }
}
