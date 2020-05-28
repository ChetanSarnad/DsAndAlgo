package Recursion;

/*
 Factorial using recursion

 Main concept of recursion
 1. The method calls itself with a simpler input i.e a reduced set of input.
 Ex : Here we call recursion on a number lesser than original
 2. Break condition, condition on which the recursion should stop.
 Ex : number <= 1 is a break case
 */
public class FactorialUsingRecursion {

    static int factorial(int number){
        // Break condition
        if (number <= 1){
            return 1;
        }
        // calls itself recursively on a number lesser than original
        return number * factorial(number - 1);

    }

    public static void main(String[] args) {
        int number = 10;
        int factorial =  factorial(number);
        System.out.println("Factorial of " + number + " is : " + factorial);
    }

}
