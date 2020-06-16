package Searching;

/*
This class demonstrate simple linear search on unsorted array

Time complexity : O(n)
 */
public class LinearSearchUnsortedArray {

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

        int[] numArray = {4, 2, 7, 1, 8};

        LinearSearchUnsortedArray linearSearchUnsortedArray = new LinearSearchUnsortedArray();

        linearSearchUnsortedArray.printArray(numArray);

        System.out.println("Search for : " + 7);
        boolean isFound = linearSearchUnsortedArray.linearSearch(numArray, 7);

        System.out.println("Found item : " + isFound);

        System.out.println("Search for : " + 9);
        isFound = linearSearchUnsortedArray.linearSearch(numArray, 9);

        System.out.println("Found item : " + isFound);

    }
}
