package HeapsAndPriorityQueue.BasicImplementations;

/*

Here we will see how to represent a Binary Tree in a Array format.

Consider the below BT

                              A

                     B                    C

                D         E           F         G

Now in order to create an array of this BT, we create an array of size n.
After that, we populate the elements fo the array level by level.
Mentioned below is the array structure


Elements   -      | A  |  B  |  C  |  D  |  E  |  F  |  G |
Index      -      | 0  |  1  |  2  |  3  |  4  |  5  |  6 |

Now, there is also a formula to calculate the parent of a given index and also kids of a particular index.

Parent = (i - 2)/2

Left Children  = 2i + 1
Right Children = 2i + 2


Also, lets understand about full binary tree and complete binary tree.


Full binary tree means all levels are completely filled up.

Complete binary tree means, in the last level, there can be empty spots.
But it should not ideally leave gaps in the array structure.
i.e. the spot occupied by D and E cannot be empty.
G could be empty, since it will be at the end.
Or F and G both could be empty, since both will be at end.
But it would not be ideal if only F is empty and G is filled, since it would cause a gap.


 */

public class ArrayRepresentationOfTree {
}
