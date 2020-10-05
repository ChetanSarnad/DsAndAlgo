package Trees.Applications;

/*

Side view mean the left side view or the right side view of a binary tree.

This is achieved via the Level order traversal of the binary tree. Please refer LOT class in Basic implementation package.

Lets take an example now

For tree like

            1
     2              3
  4    5         6     7


From Left side view :  [1  2  4]

From Right side view : [1  3  7]

Now how can we use LOT for printing left and right side view?

Below is the LOT

Level Order : 1  2 3  4 5 6 7
Level 1 = 1
Level 2 = 2, 3
Level 3 = 4, 5, 6, 7

For left side view : Take all the starting elements of each level(left most).
For right side view : Take the ending elements of each level(right most).

That's it, we have our left side and right side view.

 */
public class SideViewOfBinaryTrees {
}
