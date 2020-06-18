package Queues.BasicImplementations;

/*
Implementation of queues using arrays.

In case of regular array, if items are de queued from front, those index will be left empty.
The new elements will be queued at end i.e rear. Once rear reaches end of array, no more elements like be inserted.
Even though few elements would have been de queued at the front, those will be left empty and new elements cant be inserted.

Hence the array we will assume will behave like a circular array.
If the capacity is 5, it will start with 0 and end at 4. Again continue inserting new elements at 0, if cell is empty.

We will make use of modulus operation for finding the slot to fill
If capacity 5. Suppose you inserted 5 elements, the queue is full.
 1 2 3 4 5
 Now I delete 2 element, two elements are deleted from front
 - - 3 4 5
 No as you see, two empty spaces at the beginning, we can enqueue in those position using modulus operator
 Currently front is at index 2 and rear is at index 4.
 New rear = ( rear + 1 ) % capacity = ( 4 + 1 ) % 5 = 0
 New element will be inserted at index 0, if size of queue is less than capacity

 */
class QueueArray {

    int front;

    int rear;

    int capacity;

    int[] queArray;

    int size;

    QueueArray(int capacity) {

        // Set the capacity, the number of elements of queue can hold
        this.capacity = capacity;

        // Initialize the front and rear as 0, Both at same index
        front = 0;
        rear = 0;

        queArray = new int[capacity];

    }

    void enqueue(int data) throws Exception {

        // If queue is full
        if (size == capacity) {
            throw new Exception("Queue is full");
        }

        // Add new element at rear
        queArray[rear] = data;
        // Increment rear, use modulus operator, to give the array a circular feel.
        rear = (rear + 1) % capacity;

        // Increment the size
        size++;
    }

    int dequeue() throws Exception {

        // If no elements
        if (size == 0) {
            throw new Exception("Queue is empty");
        }

        // Store the data at front to return
        int data = queArray[front];

        // Move the front to next element, use modulus to give it a circular feel
        front = (front + 1) % capacity;

        // Decrement the size
        size--;

        // Return the data at old front
        return data;
    }

    void printQueue() {
        System.out.println("\n Queue : ");
        for (int i = 0; i < size; i++) {
            System.out.println(queArray[(front + i) % capacity]);

        }
    }
}

/*
Queues demonstration
 */
public class QueuesUsingArrays {

    public static void main(String[] args) throws Exception {

        System.out.println(" Create a new Queue ");

        QueueArray queueArray = new QueueArray(5);

        System.out.println("\n Add 5 elements, full capacity");

        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);
        queueArray.enqueue(5);

        System.out.println("\n Print the queue");
        queueArray.printQueue();

        System.out.println("\n Dequeue an element");
        int data = queueArray.dequeue();
        System.out.println("Dequeued data : " + data);
        System.out.println("\n Print the queue");
        queueArray.printQueue();

        System.out.println("\n Dequeue an element");
        data = queueArray.dequeue();
        System.out.println("Dequeued data : " + data);
        System.out.println("\n Print the queue");
        queueArray.printQueue();


        System.out.println("\n Since two elements de queued, two spaces available for adding data");

        queueArray.enqueue(6);
        queueArray.enqueue(7);

        System.out.println("\n Print the queue");
        queueArray.printQueue();
    }
}

