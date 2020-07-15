package Trees.BasicImplementations;

/*

Red Black tree like AVL, is another way to balance the BST.

In RB tree, the nodes are marked as either red or black, so one extra memory space is required.

Rules of RB tree,
1. Root is black
2. No red-red parent child
3. Number of black nodes from root node to node with less than 2 children is same.

Rules for insertion,
1. If empty then create black root node
2. Always insert new leaf node as red
    a. If parent is black then done
    b. If parent is red
        i. If black or absent sibling of that red parent, rotate , recolour and done
        ii. If red sibling then recolour and check again
        
 */
public class RedBlackTrees {
}
