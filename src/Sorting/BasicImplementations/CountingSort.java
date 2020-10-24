package Sorting.BasicImplementations;

/*

Short and sweet explanation at : https://www.youtube.com/watch?v=OKd534EWcdk

Counting sort algorithm is used when we have to sort a set of numbers/characters or any elements, and if the range of
those elements is very small.

Examples include :
1. Sort 1000 numbers like 0, 1 , 3, 2, 0, 2, 1 , 1 , 3, 2 ,3 ....., But range is only 0 to 3
2. Sort elements by color
3. Sort people by age, lakhs of people but age varies max from 0 to 100.

Another advantage of counting sort is it maintains the order in sorted output, means even after sorting, the element suppose
1, appearing before another 1 in input array, same order will be maintained.
This does not make much sense in numbers, but imagine for people right, same order as input is maintained.

Now lets dig into the algorithm

Consider input array to be sorted :
Input : [1, 0, 3, 1, 3, 1]

Alright, so the range here is 0 to 3, lets create a range array
Range : [0, 1, 2, 3]
Array of size 4

Now traverse through the input array, for each occurrence an element, increment its value at that index in range array.
The index 0 in range array, should finally hold the count of number of times 0 occurs in input array.
The index 1 in range array, should finally hold the count of number of times 1 occurs in input array.
And so on.

So for the input
Input : [1, 0, 3, 1, 3, 1]
Our range array would be populated as
Range array Indexes: [0, 1, 2, 3]
Range array Values : [1, 3, 0, 2]

As we see, 0 index has value 1, meaning 0 has 1 occurrence in input array.
1 index has value 3, meaning 1 has 3 occurrences in input array.

Now in the range array, we need to perform an cumulative addition.
What it means?
Each value at index should be the value of itself in addition to all the values to its left
Meaning, the value at index 1 = value of index 0 + value of index 1.
value at index 2 = value of index 1 + value of index 2.
And so on, for index 0, it will be unchanged, as nothing to add before it in array.

So, our range array transforms as below
Range array Indexes    : [0, 1, 2, 3]
Range array Values     : [1, 3, 0, 2]
Range array new Values : [1, 4, 4, 6]

Shift the range array to its right by 1
Range array Values     : [1, 4, 4, 6]
Range array new Values : [0, 1, 4, 4]

Now for each index in range, it indicate the start index for the element in input array.
0 is the start index of element 0
1 is the start index of element 1
4 is the start index of element 2 and 3
Wondering by 2 and 3 has same start index?
2 is not present in input, hence it does not make a difference, you will see when we traverse the input and sort.

Btw if you do not wish to shift, another way to get the start index by check value at index-1 in range array.

Alright, now we have all required info, lets get sorting

Start looping through the input array, also have an output array of same length to capture the sorted array
1. For each element in input, find its start index and put the value at that index in output array
2. Increment the value for that element in the range array by 1, so next time same element comes, it will be put in next slot.
3. Continue till all elements in input array are traversed.


 */
public class CountingSort {

    /*
    Method to sort input array with element have particular range
     */
    public int[] countingSort(int[] input, int sizeOfRange){

        // Create an output array
        int[] output = new int[input.length];

        // Create range array
        int[] range = new int[sizeOfRange + 1];

        // Capture count of each element
        for (int i : input){
            range[i] = range[i] + 1;
        }

        // Cumulative sum
        for (int i = 1; i < range.length - 1; i++){
            range[i] = range[i - 1] + range[i];
        }

        // Right shift by one
        for (int i = range.length - 1; i >= 0; i--){
            //first element, set to zero, because value from here would be moved to index 1, so nothing left here after shift
            if (i == 0){
                range[i] = 0;
                continue;
            }
            range[i] = range[i - 1];
        }

        System.out.println("\nPrint range");
        printArray(range);

        // Traverse input array and sort
        for (int i = 0; i < input.length; i++){

            // Fetch start index from range array
            int startIndex = range[input[i]];
            System.out.println("\nStart Index for " + input[i] + " is " + startIndex);

            // output the element on the index found from range array
            output[startIndex] = input[i];

            // Increment value of start index for same element, so suppose element 1 comes again, it should go to next index
            // from the previous inserted index of 1.
            range[input[i]]++;
        }

        return output;

    }

    /*
    Method to print an array
     */
    static void printArray(int[] array){
        System.out.println("\nThe array is :");
        for (int i : array){
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    /*
    Main method
     */
    public static void main(String[] args) {

        int[] input = {1, 0 , 3, 1, 3, 1};
        printArray(input);
        int[] output = new CountingSort().countingSort(input, 3);
        System.out.println("\nAfter sorting");
        printArray(output);

        System.out.println("\nSecond input");
        int[] input1 = {2, 1, 3, 1, 3, 1};
        printArray(input1);
        output = new CountingSort().countingSort(input1, 3);
        System.out.println("\nAfter sorting");
        printArray(output);


    }

}
