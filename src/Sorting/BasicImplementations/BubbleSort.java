package Sorting.BasicImplementations;

/*
Class to demonstrate a bubble sort algorithm

Algorithm details :

- We basically start with first element
- Start comparing it with next element
- If greater than next element, then swap it.
- Continuing comparing and swapping if required
- Once n(size of array) iteration is completed, the largest element is pushed to the end of array.
- We continue same exercise again, this time second largest element is pushed to last but one spot in the array
- We continue this for n iteration again.
- Hence totally it will take n*n i.e. n2 time complexity to completely sort the array using bubble sort.

Now some level of optimisation is possible as mentioned below, but overall the complexity still remains n2

- Since largest element is pushed at the end, in second iteration with can only traverse till last but one spot
- We can maintain a flag and set is only if there is a swap, if the flag is unset after comparison, meaning
  the array is already sorted, hence we can end it without need to continue comparisons and swapping.

 */

public class BubbleSort {

    public void bubbleSort(int[] numbers) {

        // Capture the length of array
        int lenOfArray = numbers.length;

        // Outer loop, for one iteration of this, largest will be pushed to end of array
        for (int i = lenOfArray; i > 0; i--) {

            // Flag to check if already sorted, set flag as 0 initially
            int flag = 0;

            // Inner loop, compares each element with next, will go till i.
            // i.e. the position of already pushed large elements.
            // starting with (i - 2) because, when we compare A[i] and A[i+1], it should not lead to AIOB Exception
            for (int j = 0; j < (i - 2); j++) {

                // Check if element at lower index is greater than next index
                if (numbers[j] > numbers[j + 1]) {
                    // If yes then swap
                    swap(numbers, j, (j + 1));

                    // Set flag as 1, since sorting was required
                    flag = 1;

                }

            }

            if (flag == 0) {
                System.out.println("Array is in sorted state, no further iterations required");
                System.out.println("Stopping at index : " + i);
                return;
            }

        }

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

        BubbleSort bubbleSort = new BubbleSort();

        System.out.println("Array before sorting : ");
        bubbleSort.printArray(numArray);

        bubbleSort.bubbleSort(numArray);

        System.out.println("Array after sorting : ");
        bubbleSort.printArray(numArray);

    }

}
