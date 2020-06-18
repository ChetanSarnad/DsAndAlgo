package Trees.BasicImplementations.DepthFirstTraversals;

import Trees.BasicImplementations.BinaryTreeNode;

/*
Class to demonstrate the In Order traversal of a binary tree

In order is :
1. Process Left Subtree
2. Visit the current node
3. Process Right Subtree
 */
public class InOrderTraversal {

    /*
    Method to perform in order traversal recursively
     */
    public void inOrder(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        // Process left subtree
        inOrder(root.leftNode);

        // Visit the node
        System.out.println(root.data);

        // Process right subtree
        inOrder(root.rightNode);

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

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inOrder(root);
    }

}
