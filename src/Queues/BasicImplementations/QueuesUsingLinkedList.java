package Queues.BasicImplementations;

/*
Linked list node to be used in queues implementation
 */
class Node {

    int data;

    Node nextNode;

    public Node(int data) {
        this.data = data;
    }
}

/*
Implement the queues using linked list
 */
class QueuesList {

    Node front, rear;

    int size;

    // Method to add data to rear.
    void enqueue(int data) {

        // Create a node using the data first
        Node dataNode = new Node(data);

        // if front also is null, i.e. empty queue, add to front as well
        if (front == null) {
            front = dataNode;
        } else {
            // if not empty, add dataNode at the end
            rear.nextNode = dataNode;
        }

        // set new node as the rear node
        rear = dataNode;

        size++;

    }

    // Method to return element at front of queue
    int dequeue() throws Exception {

        // No elements
        if (front == null) {
            throw new Exception("Queue is empty, nothing to dequeue");
        }

        // Save the front data to return the value
        int data = front.data;

        // Inorder to delete front, point front to the next node of front
        front = front.nextNode;

        // Decrement the size
        size--;

        return data;

    }

    /*
    Method to print the queue
     */
    void printQueue() {
        Node currentNode = front;
        System.out.println("\n Queue : ");
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        }
    }

}

/*
Class to demonstrate the Queues using linked list
 */
public class QueuesUsingLinkedList {

    public static void main(String[] args) throws Exception {

        QueuesList queuesList = new QueuesList();

        System.out.println("Add 3 elements");

        queuesList.enqueue(1);
        queuesList.enqueue(2);
        queuesList.enqueue(3);

        System.out.println("\n Print the Queue");
        queuesList.printQueue();

        System.out.println("Dequeue an element");
        int data = queuesList.dequeue();
        System.out.println("Dequeued element : " + data);
        System.out.println("\n Print the queue");
        queuesList.printQueue();

        System.out.println("Enqueue another element");
        queuesList.enqueue(4);

        System.out.println("\n Print the Queue");
        queuesList.printQueue();

        System.out.println("Dequeue an element");
        data = queuesList.dequeue();
        System.out.println("Dequeued element : " + data);
        System.out.println("\n Print the queue");
        queuesList.printQueue();

        System.out.println("Dequeue an element");
        data = queuesList.dequeue();
        System.out.println("Dequeued element : " + data);
        System.out.println("\n Print the queue");
        queuesList.printQueue();

    }

}
