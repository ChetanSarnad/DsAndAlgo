package DynamicProgramming.BasicImplementations;

/*

Class to understand different approaches in dynamic programming using fibonacci example.

There are three approaches we need to understand
1. Recursion
2. Memoization
3. Bottom Up

1. Recursion :
So we start with recursive approach, i.e. the method calls itself until a base/break condition is met.
But there is a problem and inefficiency with this approach
Suppose we want fib(5), we have to call fib(4) + fib(3)
Now to find fib(4) we have to call fib(3) + fib(2)
So if you see, fib(3) is called multiple times.
This inefficiency could be solved by using memoization technique by storing values of fib(3) for reuse

2. Memoization :
As mentioned in recursion approach above, when we have to call the same function with same value again,
we should be able to re use the old value, if the function is previously called already.
If we have to find fib(n), we will create a array of length n+1 and save values for fib(0), fib(1), .... until fib(n)
in this array.
So that if any of the fib values is needed again during the recursion, we will retrieve from the array if available.
Hence this is more efficient since we save on performing the whole operation again for same value.


3. Bottom up approach :
So in the above memoize approach we created an array and added values to it during recursion.
The idea now is that why not create the array upfront and start adding values rather than going through recursion approach.
We put first two numbers, add them both and put the result in next slot of array and continue on same line.

 */
public class DpWithFibonacci {

    /*
    Fibonacci using recursion
    The time complexity is exponential i.e 2^n
     */
    public int fibUsingRecursion(int num) {

        // If num is 0 or 1, return 1
        if (num == 1 || num == 2) {
            return 1;
        }

        // use recursion
        return fibUsingRecursion(num - 1) + fibUsingRecursion(num - 2);
    }


    /*
    Fibonacci using memoize
    The time complexity is n, since we make call recursive only once per number,
    After that it is always referred from the array.
    We take the array size to be of num+1, since we want fib(num) to be at index num.
    So we will populate like fib(2) in numArray[2] etc
     */
    public int fibUsingMemoize(int num, Integer[] numArray) {
        int result;
        // Check if the array already the fib value for num
        if (numArray[num] != null) {
            return numArray[num];
        }

        // if num is 1 or 2, return 1
        if (num == 1 || num == 2) {
            result = 1;
        }
        // else, calculate fib value and add it to array for future reference
        else {
            int fibValue = fibUsingRecursion(num - 1) + fibUsingRecursion(num - 2);
            result = fibValue;
        }

        // Save the result of fib of num at the num index in array
        numArray[num] = result;

        // return result
        return result;
    }


    /*
    Fibonacci using bottom up approach
    Start building the array from left to right
     */
    public int fibUsingBottomUp(int num) {

        // create one array of size num+1
        int[] numArray = new int[num + 1];

        if (num == 1 || num == 2) {
            return 1;
        }

        numArray[1] = 1;
        numArray[2] = 1;

        // start a loop from 3 now till num
        for (int i = 3; i <= num; i++) {
            // calculate the fib at each index using two older values
            numArray[i] = numArray[i - 1] + numArray[i - 2];
        }

        // Return the value at num index
        return numArray[num];
    }

    public static void main(String[] args) {

        DpWithFibonacci dpWithFibonacci = new DpWithFibonacci();

        System.out.println(" Start fib using only recursion");

        // Find 6th fibonacci number
        // 1 1 2 3 5 8
        // so it is 8
        int fibValue = dpWithFibonacci.fibUsingRecursion(6);

        System.out.println(fibValue);


        System.out.println(" Next try fib using memoization");

        fibValue = dpWithFibonacci.fibUsingMemoize(6, new Integer[6 + 1]);

        System.out.println(fibValue);


        System.out.println(" Next try fib using bottom up approach");

        fibValue = dpWithFibonacci.fibUsingBottomUp(6);

        System.out.println(fibValue);

    }
}
