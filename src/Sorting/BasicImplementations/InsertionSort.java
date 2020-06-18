package Sorting.BasicImplementations;

/*
Class to implement insertion sort technique

Algorithm :

- Start with the second element, Since first on its own is already sorted.
- Create a hole marker at the index of element, also capture the original holeValue
- Compare the holeValue with the element before that
- If the holeValue is smaller than other element, move the hole index to the compared element index
- Continue compare till the index reaches 0 and keep moving the hole index if required, based on comparison
- Finally put the original holeValue at the newly arrived hole index.

Time complexity is again O(n^2),
Because of outer iteration over all element and inner while loop condition for hole comparison
 */
public class InsertionSort {

    /*
    Method to perform insertion sort
     */
    public void insertionSort(int[] numArray) {

        // length of array
        int lenOfArray = numArray.length;

        // Start with i as 1, since single element at 0, we assume is already sorted.
        for (int i = 1; i < lenOfArray - 1; i++) {

            // create the initial hole index
            int hole = i;

            // Value at hole position
            int holeValue = numArray[hole];

            // Continue while hole > 0, and there is a value lesser than hole value in previous indices
            while (hole > 0 && (numArray[hole - 1] > holeValue)) {

                // Move the value at hole - 1 to hole position, since it is greater than hole value
                numArray[hole] = numArray[hole - 1];

                // Move the hole in that case, to hole - 1 position.
                hole = hole - 1;

            }

            // Once the hole is moved to appropriate position after all comparisons, move the original hole value
            // to the newly identified hole position
            numArray[hole] = holeValue;

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

        InsertionSort insertionSort = new InsertionSort();

        System.out.println("Array before sorting : ");
        insertionSort.printArray(numArray);

        insertionSort.insertionSort(numArray);

        System.out.println("Array after sorting : ");
        insertionSort.printArray(numArray);

    }
}
