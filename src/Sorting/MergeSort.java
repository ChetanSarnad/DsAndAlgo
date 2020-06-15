package Sorting;

/*
Class to provide implementation of merge sort

The merge sort basically has 3 steps
1. Divide and Conquer, split the array into small bits
2. Recursion
3. Merge - Finally the merge the smaller bits to larger bits, until one big sorted array is formed

Merge algorithm :

Consider the array

        2 4 1 6 8 5 3 7

Now start divide

   2 4 1 6          8 5 3 7

2 4      16        85      37

2   4   1   6    8    5   3    7

Now we will sort and merge in recursion

2   4   1   6    8    5   3    7

2 4      16        58      37

   1 2 4 6          3 5 7 8

        1 2 3 4 5 6 7 8


Now how does merging work

Suppose you want to merge 2 arrays, say left and right arrays, into a sorted merged outputArray
m, n, l be the size of left, right and output arrays
i, j, k be the indices to help in iteration over left, right and output arrays respectively

We will start with i, j, k at 0
if left[i] is lesser than right[j], we move left[i] to output[k]
We then increment i and k, j stays at 0 since no element is moved from right still.

We do this till at least one of left or right array is completely moved to output.
After that, the elements left over in pending array are directly moved to output array.

Now we have a sorted output array, which is the combination of left and right array

 */
public class MergeSort {

    /**
     * Method to perform merge sort
     *
     * @param numArray
     */
    public void mergeSort(int[] numArray) {

        // Capture length of array
        int lenOfArray = numArray.length;

        // If length of array is less than 2
        if (lenOfArray < 2) {
            return;
        }

        // Calculate the middle position
        int middle = lenOfArray / 2;

        // Create left and right arrays
        int[] left = new int[middle];
        int[] right = new int[lenOfArray - middle];

        // populate the left and right arrays
        for (int i = 0; i < left.length; i++) {
            left[i] = numArray[i];
        }
        // right array from middle to end of original array
        for (int i = 0; i < right.length; i++) {
            right[i] = numArray[i + middle];
        }

        // Recursive call to sort left array
        mergeSort(left);

        // Recursive call to sort right array
        mergeSort(right);

        // merge the left and right arrays
        merge(left, right, numArray);

    }

    /**
     * Method to merge the arrays
     *
     * @param left
     * @param right
     * @param numArray
     */
    private void merge(int[] left, int[] right, int[] numArray) {

        // Capture lengths of all arrays
        int lSize = left.length;
        int rSize = right.length;

        // Create indices for left, right and numArray respectively
        int i, j, k;
        i = j = k = 0;

        // Till one of either left or right is completely moved to output array
        while (i < lSize && j < rSize) {

            // If the element in left smaller than element in right
            if (left[i] < right[j]) {
                // Move smaller element to output array
                numArray[k] = left[i];
                // Increment both i and k, let to move to next index
                i++;
                k++;
            } else {
                // Else it means, element at index j in right is smaller, move it to output array
                numArray[k] = right[j];
                // Increment index of j and k
                j++;
                k++;
            }
        }

        // Now check for left overs in any of the left or right arrays, usually it will be one among them.
        // One would have been completely moved as part of loop above, that's the condition for loop break as well.

        // If left array has elements left
        while (i < lSize) {
            // Move all elements to output array
            numArray[k] = left[i];
            i++;
            k++;
        }

        // If right array has elements left
        while (j < rSize) {
            // Move all elements to output array
            numArray[k] = right[j];
            j++;
            k++;
        }
    }

    /**
     * Method to print the array
     *
     * @param numArray
     */
    public void printArray(int[] numArray) {
        System.out.println("Print array : ");
        for (int i = 0; i < numArray.length; i++) {
            System.out.println(numArray[i]);
        }
    }

    public static void main(String[] args) {

        int[] numArray = {3, 1, 4, 2, 5};

        MergeSort mergeSort = new MergeSort();

        System.out.println("Array before sorting : ");
        mergeSort.printArray(numArray);

        mergeSort.mergeSort(numArray);

        System.out.println("Array after sorting : ");
        mergeSort.printArray(numArray);

    }
}
