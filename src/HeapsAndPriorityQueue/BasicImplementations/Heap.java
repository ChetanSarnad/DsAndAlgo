package HeapsAndPriorityQueue.BasicImplementations;

/*

Refer to ArrayRepresentationOfTree for understanding how to represent tree in array format.

Now, there is also a formula to calculate the parent of a given index and also kids of a particular index.

Parent = (i - 2)/2

Left Children  = 2i + 1
Right Children = 2i + 2

Below class is to represent heaps

Firstly let us understand what is min heap and what is max heap

Max Heap :

                       100

           90                       80

      70       60             50          40

In array : | 100 | 90 | 80 | 70 | 60 | 50 | 40 |

In max heap, the node should be greater than or equal to its descendents


Min Heap :

                        10

             20                     30

         40      50             60       70

In array :  | 10 | 20 | 30 | 40 | 50 | 60 | 70 |

In min heap, the node should be smaller than or equal to its descendents

Now lets see an implementation of Max heap below, Min heap is just another variation of heap

 */

public class Heap {

    Integer[] arrayRepOfTree;

    int capacity;

    int size;

    public Heap(int capacity) {
        // Set capacity and create array of that capacity
        this.capacity = capacity;
        arrayRepOfTree = new Integer[capacity];
        this.size = 0;
    }


    /*
    Method to insert an element in Heap

    We have to put the inserted element in the last spot of the array
    i.e. if the array is filled till 5th index, put the new data in the 6th index spot.

    But we also need to aware that max heap rule should be followed
    i.e. the node element should be greater than its descendents

    Now we will heapify up, i.e. compare the newly added element with its parent.
    Continue this comparison in upward direction i.e. it is called heapify up.
    Compare node with its parent, with swap required, swap it, continue comparing with next parent now, until root(0 index).

    Time complexity : O(1) to O(log(n))
    Because if smallest element is added in last spot, no swaps needed and hence O(1)
    If swap needed until root then log(n), log(n) is height of a complete binary tree

     */
    public void insert(int data) {

        // Firstly add new element at end of heap
        arrayRepOfTree[size] = data;


        // Now heapify up
        heapifyUp(size);

        // Increment size
        size++;

    }


    // Compare newly added element at end of heap with its parents and swap if required
    // Parent = (i - 2)/2

    // Left Children  = 2i + 1
    // Right Children = 2i + 2
    private void heapifyUp(int compareIndex) {

        // If reached root, return, this is break condition for recursion
        if (compareIndex == 0) {
            return;
        }

        int parentIndex;
        if (compareIndex == 1 || compareIndex == 2) {
            parentIndex = 0;
        } else {
            parentIndex = (int) Math.ceil((double) (compareIndex - 2) / 2);
        }

        // If child greater than parent
        if (arrayRepOfTree[compareIndex] > arrayRepOfTree[parentIndex]) {
            swap(compareIndex, parentIndex);

            // compare parent with its parent, recursive call
            heapifyUp(parentIndex);
        }

    }

    /*
        Method to swap the indexes in an array
    */
    public void swap(int firstIndex, int secondIndex) {

        int temp = arrayRepOfTree[secondIndex];
        arrayRepOfTree[secondIndex] = arrayRepOfTree[firstIndex];
        arrayRepOfTree[firstIndex] = temp;

        //Can we also achieved without a temp variable
        //int a=10, b=20;
        //a=a+b;//a=30 (10+20)
        //b=a-b;//b=10 (30-20)
        //a=a-b;//a=20 (30-10)

    }

    public void printHeap() {
        System.out.println("Print the heap");
        for (int i = 0; i < size; i++) {
            System.out.print(arrayRepOfTree[i]);
            System.out.print(" ");
        }
    }


    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);

        heap.printHeap();

    }

}
