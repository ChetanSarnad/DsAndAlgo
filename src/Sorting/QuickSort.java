package Sorting;

/*
Class to demonstrate quick sort

The quick sort consists of below step
1. Partition the array based on the pivot and partition index.
2. The partition is such that the elements left of pivot are lesser than pivot, those on right are greater than pivot
3. Now recursively call the quick sort of left section and right section

Now lets understand the concept of partition, pivot and partition index
- Consider the last element of array as pivot
- Now set a partition index at the beginning of array to start with.
- Loop over the elements from start to end, compare the value with pivot.
- If value is lesser than pivot value, swap the index with partition index and increment partition index, so that lesser values are towards left of partition index
- Complete this for all elements, finally all elements smaller than partition index will be on left, greater will be on right.
- Only the pivot will be left at the end
- Finally swap the pivot with partition index, so element on left of pivot are smaller. This is our final goal.
- return the pivot position.

Time and space complexity:

1. Time complexity is O(n (log n)) in average and best case
   O(n^2) in worst case, when array is already sorted and we pick pivot as last element
   the left side of pivot will almost to full array, except pivot element.
   Hence next recurvsive call be on n-1 elements, next will be n-2 and so on.
   Instead of n/2 in case of random array.
   This can be solved by randomized partition, i.e. pick random pivot, instead of picking end element always as pivot
2. Space complexity is : in place, no additional space needed i,e O(1)
 */
public class QuickSort {


    /*
    Method to perform quick sort
     */
    public void quickSort(int[] numArray, int start, int end) {

        // Break condition, if the start index is greater than the end index
        if (start >= end) {
            return;
        }

        // partition the array, with elements lesser than partition index on left, greater on right
        int partitionIndex = partition(numArray, start, end);

        // sort the left elements
        quickSort(numArray, start, partitionIndex - 1);

        // sort the right elements
        quickSort(numArray, partitionIndex + 1, end);

    }


    /*
    Method to perform the partition
     */
    private int partition(int[] numArray, int start, int end) {

        // consider the pivot as element at end
        int pivot = numArray[end];

        // start with partition index as start
        int partitionIndex = start;

        // Start the loop from start to (end - 1), we will handle pivot element at end after for loop
        for (int i = start; i <= end - 1; i++) {

            // Compare the element at index with pivot value
            if (numArray[i] < pivot) {
                // swap with partitionIndex and increment partition index,
                // so element smaller than partitionIndex is on the left now
                swap(numArray, i, partitionIndex);

                partitionIndex++;

            }
        }

        // Finally move the pivot value to partition index
        // so now, elements left of pivot are lesser and towards right are bigger
        swap(numArray, partitionIndex, end);

        // Return partitionIndex
        return partitionIndex;

    }


    /*
    Method to swap the indexes in an array
    */
    public void swap(int[] numbers, int firstIndex, int secondIndex) {

        int temp = numbers[secondIndex];
        numbers[secondIndex] = numbers[firstIndex];
        numbers[firstIndex] = temp;

        //Can we also achieved without a temp variable
        //int a=10, b=20;
        //a=a+b;//a=30 (10+20)
        //b=a-b;//b=10 (30-20)
        //a=a-b;//a=20 (30-10)

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

        QuickSort quickSort = new QuickSort();

        System.out.println("Array before sorting : ");
        quickSort.printArray(numArray);

        quickSort.quickSort(numArray, 0, numArray.length - 1);

        System.out.println("Array after sorting : ");
        quickSort.printArray(numArray);

    }

}
