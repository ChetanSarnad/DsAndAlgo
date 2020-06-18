package Sorting.BasicImplementations;

/**
 * Method to demonstrate the selection sort mechanism
 * <p>
 * In selection sort, we find the minimum among all elements and start pushing them towards start of array.
 * <p>
 * Algorithm explained
 * <p>
 * - In the first iteration of outer loop, we start from 0 to n-2
 * - Since n-1 will already compared when we are doing iteration for n-1, since we compare with next element
 * - Ok, in first iteration of outer loop, we set iMin index as i i.e. 0
 * - We start a inner loop now
 * - And start comparing the iMin with elements of array inside inner loop
 * - If any element found lesser than iMin, we swap it
 * - The inner loop j start at i+1, since it has to start comparing the next element to i
 * - The inner loop ends at n-1, since it has to compare with all elements
 * - At the end, the entire array is sorted
 * <p>
 * The time complexity of this approach is O(n^2)
 */

public class SelectionSort {

    /**
     * @param numArray Method to perform the selection sort
     */
    private void selectionSort(int[] numArray) {

        // Capture the length of array
        int lenOfArray = numArray.length;

        // Start the outer loop
        for (int i = 0; i <= lenOfArray - 2; i++) {

            // To begin with consider i as the iMin, the most minimum value's index
            int iMin = i;

            // If element found lesser than iMin, we need to swap, set as false initially
            boolean isSwapNeeded = false;

            // Start the inner loop, with j starting from i+1
            // Since we have to compare next elements, the previous would be sorted already
            for (int j = (i + 1); j <= lenOfArray - 1; j++) {

                // Check if other elements are lesser than iMin
                // If so, set it as the new min
                if (numArray[j] < numArray[iMin]) {
                    iMin = j;
                    // set to true, since we found an element lesser than iMin
                    isSwapNeeded = true;
                }
            }

            // Swap iMin with i
            if (isSwapNeeded) {
                int temp = numArray[iMin];
                numArray[iMin] = numArray[i];
                numArray[i] = temp;

                //Can we also achieved without a temp variable
                //int a=10, b=20;
                //a=a+b;//a=30 (10+20)
                //b=a-b;//b=10 (30-20)
                //a=a-b;//a=20 (30-10)
            }

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

        SelectionSort selectionSort = new SelectionSort();

        System.out.println("Array before sorting : ");
        selectionSort.printArray(numArray);

        selectionSort.selectionSort(numArray);

        System.out.println("Array after sorting : ");
        selectionSort.printArray(numArray);

    }

}
