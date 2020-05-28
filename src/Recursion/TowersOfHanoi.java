package Recursion;
/*

Problem statement :
-------------------
• Only one disk may be moved at a time.
• Each move consists of taking the upper disk from one of the rods and sliding it onto
another rod, on top of the other disks that may already be present on that rod.
• No disk may be placed on top of a smaller disk.

Algorithm :
-----------
Algorithm
• Move the top n – 1 disks from Source to Auxiliary tower,
• Move the nth disk from Source to Destination tower,
• Move the n – 1 disks from Auxiliary tower to Destination tower.
• Transferring the top n – 1 disks from Source to Auxiliary tower can again be thought
  of as a fresh problem and can be solved in the same manner.

Once we solve Towers of Hanoi with three disks, we can solve it with any number of disks with the above algorithm.

For n disks, total 2n – 1 moves are required.

 */

import java.util.Stack;

public class TowersOfHanoi {

    static void moveTheDisksDemoUsingStacks(int numberOfDisks, Stack fromTower, Stack toTower, Stack auxTower){

        // Base condition
        if (numberOfDisks == 1){
            // Move the remaining one node from fromTower to toTower
            int disk = (int) fromTower.peek();
            System.out.println("\nMove one disk " + disk + " from " + fromTower + " to " + toTower);
            disk = (int) fromTower.pop();
            toTower.push(disk);
            return;
        }

        // Move n-1 disks from the fromTower to auxTower, using toTower as auxTower
        moveTheDisksDemoUsingStacks(numberOfDisks - 1, fromTower, auxTower, toTower);

        // Move the remaining one node from fromTower to toTower
        int disk = (int) fromTower.peek();
        System.out.println("\nMove remaining one disk " + disk + " from " + fromTower + " to " + toTower);
        disk = (int) fromTower.pop();
        toTower.push(disk);

        // Move n-1 disks from the auxTower to toTower, using from as auxilary Tower
        moveTheDisksDemoUsingStacks(numberOfDisks - 1, auxTower, toTower, fromTower);

    }

    public static void main(String[] args) {

        Stack fromTower = new Stack();
        Stack toTower = new Stack();
        Stack auxTower = new Stack();

        fromTower.push(3);
        fromTower.push(2);
        fromTower.push(1);

        System.out.println("The fromTower : " + fromTower);
        System.out.println("The toTower : " + toTower);
        System.out.println("The auxTower : " + auxTower);

        int numberOfDisks = 3;

        moveTheDisksDemoUsingStacks(numberOfDisks, fromTower, toTower, auxTower);

        System.out.println("\nPrint towers after moving from fromTower to toTower \n");

        System.out.println("The fromTower : " + fromTower);
        System.out.println("The toTower : " + toTower);
        System.out.println("The auxTower : " + auxTower);

    }


}
