package Searching.BasicImplementations;

/*
Binary search works on sorted array
We first find the middle element and compare with out item
If exact match then return as found
If the middle element is lesser than out item, then search only in left half
If the middle element is greater than out item, then search only in right half
Continue to recursively find the middle element of left and right section and continue procedure until found
or no further division possible.

Time complexity : O(logn)
 */
public class BinarySearch {

    /*
    Method to perform binary search
     */
    public boolean binarySearch(int[] numArray, int item) {

        // find length of array
        int lenOfArray = numArray.length;

        int low = 0;
        int high = lenOfArray - 1;

        // Do until there is at least one element
        while (low <= high) {
            // find middle index
            int middle = (low + high) / 2;
            // This could also be written as low + (high - low)/2.
            // This is for overcoming overflow in integers if low + high is very large number
            // If you multiply low + (high - low)/2 by 2, you again get (low + high)/2

            // find middle element
            int middleElement = numArray[middle];

            if (middleElement == item) {
                // If middle element is same as item, then found, return true
                return true;
            } else if (middleElement < item) {
                // if middleElement lesser than item, search in first half only, set high at half way mark
                high = middle - 1;
            } else {
                // if middleElement greater than item, search in second half only, set low at half way mark
                low = middleElement + 1;
            }
        }

        // No luck
        return false;

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

        int[] numArray = {1, 2, 3, 4, 8, 11, 15, 18, 20};

        BinarySearch binarySearch = new BinarySearch();

        binarySearch.printArray(numArray);

        System.out.println("Search for : " + 8);
        boolean isFound = binarySearch.binarySearch(numArray, 8);

        System.out.println("Found item : " + isFound);

        System.out.println("Search for : " + 9);
        isFound = binarySearch.binarySearch(numArray, 9);

        System.out.println("Found item : " + isFound);

    }
}
