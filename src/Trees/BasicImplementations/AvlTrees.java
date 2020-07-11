package Trees.BasicImplementations;

/*

AVL trees are required in order to maintain the balance of the tree
AVL trees are BST trees.

In BST if numbers inserted are already in an sorted order, it creates a highly imbalanced tree.
Like 50 , 40 , 30 , 20 , 10 are inserted in BST

                   50
               40
            30
        20
     10

In order to address problem as above, we use AVL. AVL uses concept of balance factor of each node.
Balance factor of node = Height of left tree - Height of right tree
This should be in the set {-1, 0, 1}

If the balance factor is outside the above set, then rotation is performed to bring the BF in the above range.
Rotation always happen between 3 nodes

There are 4 different types of imbalances
1. Left Left
2. Left Right
3. Right Right
4. Right Left

1. Left Left Imbalance

                30 (BF = 2 - 0 = 2)

          20 (BF = 1 - 0 = 1)

      10 (BF = 0 - 0 = 0)

Now perform rotation, fix root i.e. on the nail and pull towards right, the tree becomes balanced, check BF of nodes

                    20(1)

              10(0)        30(0)

2. Left Right Imbalance

                30 (2)
              /
           10 (-1)
              \
                20 (0)

Now perform rotation, for LR imbalance, directly replace root with bottom right element, put the root on the right

                20 (1)

          10 (0)       30 (0)

3. Right Right Imbalance

                10 (-2)

                    20(-1)

                        30(0)

Perform rotation, nail at the root and pull towards left.

                20 (1)

          10 (1)     30 (0)

4. Right Left Imbalance

                    10 (-2)

                           30 (1)

                      20(0)

For rotation, replace root with bottom left element and put root on left

                    20 (1)

              10 (0)      30 (0)
 */
public class AvlTrees {
}
