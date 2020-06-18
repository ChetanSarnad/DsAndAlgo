package Queues.BasicImplementations;

import java.util.Stack;

/*
Class providing Queue functionality of enqueue and dequeue using two stacks
 */
class QueuesUsingTwoStacks {

    Stack s1 = new Stack();
    Stack s2 = new Stack();

    int size;

    // Method to enqueue the data, we just push the data on s1 stack
    void enqueue(int data) {

        //Push the data to s1 stack
        s1.push(data);

        // Increment the size
        size++;
    }


    /*
    Method to dequeue elements.
    Here we pop from s1 and push to s2, effectively reversing the order.
    Hence when we pop from s2, it gives the first element pushed in s1.
    Effectively the behaviour of an queue.
     */
    int dequeue() throws Exception {

        // If s2 is empty, first populate s2 from s1
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                // Now the elements will be added in reverese order in s2.
                s2.push(s1.pop());
            }
        }

        if (!s2.isEmpty()) {
            return (int) s2.pop();
        } else {
            throw new Exception("Queue is empty. No elements to dequeue");
        }
    }

}

/*
Class to demonstrate the capabilities of Queues using Stack
 */
public class QueuesUsingStack {

    public static void main(String[] args) throws Exception {

        System.out.println("\n Create a new queue using two stacks");

        QueuesUsingTwoStacks queuesUsingTwoStacks = new QueuesUsingTwoStacks();

        System.out.println("\n Add 3 elements");

        queuesUsingTwoStacks.enqueue(1);
        queuesUsingTwoStacks.enqueue(2);
        queuesUsingTwoStacks.enqueue(3);


        System.out.println("\n Dequeue an element");
        int data = queuesUsingTwoStacks.dequeue();
        System.out.println("\n Dequeued element is : " + data);


    }

}
