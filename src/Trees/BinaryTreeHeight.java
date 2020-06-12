package Trees;


/*
Class to demonstrate the height functionality of binary tree

Lets understand height and depth of a tree

Height : It is the number of edges in the longest path from root to the farthest leaf node
Ex : Height of root is the height of entire tree
     Height of leaf node or a node with only one element is 0 (Since no edges involved)

Depth : It is the number of edges from root to the node under contention
Ex : Depth of root is 0
 */
public class BinaryTreeHeight {

    public int height(BinaryTreeNode root) {

        // Base condition is -1, since for leaf nodes height is 0.
        // The -1 here will balance with +1 while returning and make it 0
        if (root == null) {
            return -1;
        }

        // Calculate height of left and right subtree
        // The height of tree is max of left or right subtree + 1 for the root node.
        return Math.max(height(root.leftNode), height(root.rightNode)) + 1;
    }

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.leftNode = new BinaryTreeNode(2);
        root.rightNode = new BinaryTreeNode(3);
        root.leftNode.leftNode = new BinaryTreeNode(4);
        root.leftNode.rightNode = new BinaryTreeNode(5);
        root.rightNode.leftNode = new BinaryTreeNode(6);
        root.rightNode.rightNode = new BinaryTreeNode(7);

        /*
         Structure of the binary tree is
                          1
                 2                 3
             4      5           6     7
         */

        BinaryTreeHeight binaryTreeHeight = new BinaryTreeHeight();
        System.out.println(binaryTreeHeight.height(root));
    }

}
