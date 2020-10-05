package Trees.BasicImplementations.VerticalOrderTraversal;

/*

Vertical order traversal involves traversing along the width of the tree.

For that we need to calculate the horizontal distance(hd) of each node and then print the nodes in increasing order of hd.

Below shows the tree and hd for each node. The root hd is 0, left child is parent hd - 1, right child is parent hd + 1.



                                          1(hd = 0)
                                     /                \

                  2(hd = 0 - 1 = -1)                      3(hd = 0 + 1 = 1)

                  /            \                            /              \

   4(hd = -1 - 1 = -2)           5(hd = -1 + 1 = 0)    6(hd = 1 - 1 = 0)       7(hd = 1 + 1 = 2)


So the order would be [ 4,  2,  1,  5,  6,  3,  7]
The corresponding hd  [ -2  -1  0   0   0   1   2]

Note : 1, 5, 6 actually overlap, they are of same hd, they could ideally appear in any order.

Algorithm :
-----------
It is a combination of Level order traversal and Hashtable

1. Enqueue the root in a queue
2. We have to update the hd for the root as 0.
3. Add hd = 0, i.e. 0 as the key in hashtable with root node as the value.
4. Dequeue from the queue,
   i. Check for the left and right child, calculate and update hd in the hashtable.
   ii. Enqueue the left and right child
5. Continue till all elements are de-queued.


Example for the queue and hashtable below,

Queue :
1  2  3  4  5  6  7

Hashtable :
0  -> [1, 5, 6]
-1 -> [2]
-2 -> [4]
1  -> [3]
2  -> [7]

Now if we keep track of the minimum key and maximum key, we can start retrieving the elements form the minimum key to maximum.

Or personally I feel , if we use something like tree set, the key would be sorted and we could retrieve as well.

 */
public class VerticalOrderTraversal {
}
