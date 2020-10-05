package Trees.Applications;

/*

We need a combination of Level order traversal and Vertical order traversal .
Explanation available in BasicImplementation package of trees.

Take an example

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


Now visually we can already see that [4  2  1  3  7] forms the top view of the Binary Tree.

How do get from the LOT and VOT results?

From min to max in VOT, pick one element for each hd, i.e. from -2 to 2.
For hd having multiple nodes like for hd 0, we have [1  5  6]
Here take the element which appears first in the LOT sequence. Here 1 appears first, so take only 1.


 */

public class TopViewOfBinaryTree {
}
