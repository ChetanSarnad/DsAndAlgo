package Trees.DepthFirstTraversals;

import Trees.BinaryTreeNode;

/*
Class to demonstrate the post order traversal of a binary tree

Post order is :
1. Process Left Subtree
2. Process Right Subtree
3. Visit the current node
 */
public class PostOrderTraversal {

    /*
    Method to perform post order traversal recursively
     */
    public void postOrder(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        // Process left subtree
        postOrder(root.leftNode);

        // Process right subtree
        postOrder(root.rightNode);

        // Visit the node
        System.out.println(root.data);
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

        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        postOrderTraversal.postOrder(root);
    }

}
