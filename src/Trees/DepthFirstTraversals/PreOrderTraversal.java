package Trees.DepthFirstTraversals;

import Trees.BinaryTreeNode;

/*
Class to demonstrate the pre order traversal of a binary tree

Pre order is :
1. Visit the current node
2. Process Left Subtree
3. Process Right Subtree
 */
public class PreOrderTraversal {

    /*
    Method to perform pre order traversal recursively
     */
    public void preOrder(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        // Visit the node
        System.out.println(root.data);

        // Process left subtree
        preOrder(root.leftNode);

        // Process right subtree
        preOrder(root.rightNode);
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

        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        preOrderTraversal.preOrder(root);
    }

}
