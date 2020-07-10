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

import java.util.Arrays;

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


    /*

    Delete method for heap

    Delete always deletes the element at root, i.e. the maximum value.

    Now there will be blank spot at root, we will put the element from last spot to root.

    After that we need check the new root value with its descendents and check if it is smaller than them.
    If smaller, move the greater of the two kids to the parents position, move the parent to that kid's position.

    Continue comparing that new kid to its kids and check if heap property of max heap is applicable, else swap, this is recursive.

    We call this procedure heapify down.

    Also a bit of heap sort functionality we will add here in delete method.
    Once the root is deleted, the last element is moved to root.
    There is a vacant space left by that last element, we will put the deleted root element here.
    So like that, if we delete all elements and keep adding at the empty spots, the whole array will be sorted :)
    More will be covered in heap sort method, but making that change in delete method here.

     */
    public int delete() {

        // Always delete root. i.e. item at index 0
        int deletedItem = arrayRepOfTree[0];

        // Now put the last element in root empty space
        int lastItem = arrayRepOfTree[size - 1];
        arrayRepOfTree[0] = lastItem;

        // Now there is an empty spot at last element, put the deleted root element there
        arrayRepOfTree[size - 1] = deletedItem;

        // Decrease size of Heap
        size--;

        // Now the item that we put in root may not be the largest element, heap rule might fail,
        // hence call heapifyDown starting with root
        heapifyDown(0);

        // return item to be deleted
        return deletedItem;

    }

    /*
    Compare the two children of the parent, compare the larger kid with its parent, swap if parent smaller than kid.
    Continue down till the leaf element
     */
    private void heapifyDown(int parentIndex) {

        // Break if incoming index is greater than size of heap
        // Useful in recursion, since we will call it with kids of parentIndex
        if (parentIndex >= size) {
            return;
        }

        // parent Element
        int parentElement = arrayRepOfTree[parentIndex];

        Integer leftChild = null;
        int leftChildIndex = -1;
        if ((2 * parentIndex + 1) < size) {
            leftChildIndex = 2 * parentIndex + 1;
            leftChild = arrayRepOfTree[leftChildIndex];
        }

        Integer rightChild = null;
        int rightChildIndex = -1;
        if ((2 * parentIndex + 2) < size) {
            rightChildIndex = 2 * parentIndex + 2;
            rightChild = arrayRepOfTree[rightChildIndex];
        }

        // Return if leftChild null, right child will obviously be null in complete binary tree
        // So no comparison needed if no kids, return from here
        if (leftChild == null) {
            return;
        }

        if (rightChild == null) {
            // Compare leftChild with parent and swap if required
            if (leftChild > parentElement) {
                swap(parentIndex, leftChildIndex);
            }
            // Now call heapifyDown with left child index
            heapifyDown(leftChildIndex);
            return;
        }

        if (leftChild > rightChild) {
            swap(parentIndex, leftChildIndex);
            // Now call heapifyDown with left child index
            heapifyDown(leftChildIndex);
            return;
        } else {
            swap(parentIndex, rightChildIndex);
            // Now call heapifyDown with left child index
            heapifyDown(rightChildIndex);
            return;
        }

    }

    /*

    So heapify method converts and array representation of tree to heap.

    Here we visit each node starting from the end and perform heapify down, i.e. compare with its kids.

    The complexity is considered as O(n) because half of the elements are at leaf, hence 0(1) for each one of those nodes.

    And log(n) for root, some intermediate value for middle level elements.

    Hence O(n) overall.

     */
    public void heapify() {

    }

    public void printHeap() {
        System.out.println("Print the heap");
        for (int i = 0; i < size; i++) {
            System.out.print(arrayRepOfTree[i]);
            System.out.print(" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);

        heap.printHeap();

        System.out.println("\nDelete invoked");
        heap.delete();
        heap.printHeap();

        System.out.println("\nDelete invoked");
        heap.delete();
        heap.printHeap();

        System.out.println("\nDelete invoked");
        heap.delete();
        heap.printHeap();

        System.out.println("\nDelete invoked");
        heap.delete();
        heap.printHeap();

        System.out.println("\nDelete invoked");
        heap.delete();
        heap.printHeap();

        System.out.println("Check if sorted after deleting all elements");
        System.out.println(Arrays.asList(heap.arrayRepOfTree));

    }

}
