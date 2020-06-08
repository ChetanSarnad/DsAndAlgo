package Stacks;

/*
Stack implementation using an array
 */
class StackArray{

    // Define capacity of stack, number of elements it can hold
    int capacity;

    // Array backing the stack
    int[] stackArray;

    // Index of top element of stack
    int top = -1;

    // constructor for the stack, takes the capacity and
    StackArray(int capacity){
        // set the capacity
        this.capacity = capacity;

        // create array of length same as capacity
        stackArray = new int[capacity];
    }

    // Push method to add data to stack
    void push(int data){
        if (size() == capacity){
            System.out.println("\n The stack is full");
            return;
        }
        // Increment the top and add the data to array at next index
        stackArray[++top] = data;
    }

    // Pop the value at top index and decrement the top
    int pop() throws Exception {
        // Throw exception if stack is empty
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        // capture top data before deleting
        int data = stackArray[top];
        // Set dummy value at old top and then decrement top with post --
        stackArray[top--] = Integer.MIN_VALUE;
        return data;
    }

    // Peek the value at top index and decrement the top
    // Everything similar to pop, except no decrement of the top.
    int peek() throws Exception {
        // Throw exception if stack is empty
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        // capture top data before deleting
        int data = stackArray[top];
        return data;
    }

    // Method to print the elements of stack
    void printStack(){
        System.out.println("\n Stack : ");
        int stackLength = stackArray.length;
        for (int i = 0; i < stackLength; i++){
            System.out.println(stackArray[i]);
        }

    }

    // Method to fetch the size of stack. Increment top, since we start with top value as -1
    // After adding first element top value will be incremented from -1 to 1
    int size(){
        return top + 1;
    }

    // If top is -1, then no elements are added, since we increment top while adding elements
    boolean isEmpty(){
        return top == -1;
    }

}

/*
Class to demonstrate stack
 */
public class StackUsingArray {

    public static void main(String[] args) throws Exception {
        System.out.println(" Create a stack of length 3");
        StackArray stackArray = new StackArray(3);

        System.out.println("\n Add three elements");
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);

        stackArray.printStack();

        System.out.println("\n Peek the top value");
        int peekValue = stackArray.peek();
        System.out.println("Peek value : " + peekValue);

        System.out.println("\n Pop out an element");
        stackArray.pop();

        stackArray.printStack();

        System.out.println("\n Pop out an element");
        stackArray.pop();

        stackArray.printStack();

        System.out.println("\n Pop out an element");
        stackArray.pop();

        stackArray.printStack();

        try{
            System.out.println("\n Pop out an element");
            stackArray.pop();

            stackArray.printStack();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
