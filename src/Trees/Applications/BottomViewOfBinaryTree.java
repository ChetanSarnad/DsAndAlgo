package Trees.Applications;

/*

For tree like

            1
     2              3
  4    5         6     7

Bottom view would be : [4  2  5  3  7]   or [4  2  6  3  7], because 5 or 6 would overlap.

Now we could find the bottom view of a binary tree using vertical order traversal

For vertical order traversal, please refer vertical order class I wrote in BasicImplementations package.

                                          1(hd = 0)
                                     /                \

                  2(hd = 0 - 1 = -1)                      3(hd = 0 + 1 = 1)

                  /            \                            /              \

   4(hd = -1 - 1 = -2)           5(hd = -1 + 1 = 0)    6(hd = 1 - 1 = 0)       7(hd = 1 + 1 = 2)


Level order traversal : [1   2   3   4   5   6   7]

Vertical order traversal Hashtable :
-2 -> [4]
-1 -> [2]
0  -> [1, 5, 6]
1  -> [3]
2  -> [7]

Now for bottom view, all we need to do is take the last element at each vertical order

[4  2  6  3  7]

Please note that, here we consider 6. We can only consider 5 or 6 since they overlap.

 */

public class BottomViewOfBinaryTree {
}
