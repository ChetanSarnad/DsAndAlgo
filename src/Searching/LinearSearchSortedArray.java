package Searching;

/*
Class to demonstrate linear search on a sorted array

Time complexity is again O(n)
But advantage in sorted array is, if we reach an item greater than one we are trying to find.
We can simply break and return, since we will not find it in later part of array.
Because it contains elements greater than the item
 */
public class LinearSearchSortedArray {

    /*
Method to perform linear search
Just traverse through array and search of the item
 */
    public boolean linearSearch(int[] numArray, int item) {
        boolean isFound = false;

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == item) {
                isFound = true;
                break;
            } else if (numArray[i] > item) {
                System.out.println("Breaking at " + numArray[i]);
                break;
            }
        }

        return isFound;
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

        // Sorted array
        int[] numArray = {1, 2, 7, 9, 11};

        LinearSearchSortedArray linearSearchSortedArray = new LinearSearchSortedArray();

        linearSearchSortedArray.printArray(numArray);

        System.out.println("Search for : " + 7);
        boolean isFound = linearSearchSortedArray.linearSearch(numArray, 7);

        System.out.println("Found item : " + isFound);

        System.out.println("Search for : " + 8);
        isFound = linearSearchSortedArray.linearSearch(numArray, 8);

        System.out.println("Found item : " + isFound);

    }

}
