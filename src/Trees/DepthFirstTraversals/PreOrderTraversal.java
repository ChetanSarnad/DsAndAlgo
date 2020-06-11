package Trees.DepthFirstTraversals;

import Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

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

    /*
    Method to perform pre order traversal using iterative method
     */
    public ArrayList<Integer> preOrderIterative(BinaryTreeNode root) {

        // Array list to hold the elements in traversed order
        ArrayList<Integer> dataList = new ArrayList<>();

        Stack<BinaryTreeNode> stack = new Stack<>();

        // First push the root on stack
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {

            BinaryTreeNode node = stack.pop();

            // Fetch the data from node
            int data = node.data;

            dataList.add(data);

            // If the node right node is available, push it on stack
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }

            // If the node left node is available, push it on stack.
            // In stack the element put last will be popped first,
            // so we put left at the end, since we want left node first
            // This continues in the iterative loop, the lefts will be kept adding last, so popped first
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }

        }

        // Return the list with elements in pre order
        return dataList;

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

        System.out.println("\n Pre Order using recursion");
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        preOrderTraversal.preOrder(root);

        System.out.println("\n Pre Order using iterative method");
        ArrayList<Integer> dataList = preOrderTraversal.preOrderIterative(root);
        System.out.println(dataList);

    }

}
