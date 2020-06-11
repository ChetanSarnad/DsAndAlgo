package Trees.BreadthFirstTraversal;

import Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Class to demonstrate the level order traversal

For tree like

            1
     2              3
  4    5         6     7

Level Order : 1  2 3  4 5 6 7
Level 1 = 1
Level 2 = 2, 3
Level 3 = 4, 5, 6, 7

So the approach here is to use Queues
1. First put the root in queue (This is like adding 1st level to queue)
2. Peek the front(Visit i.e print), put the left and right child nodes in queue (This is like adding 2nd level to queue)
3. Pop the front
4. So the first level left child is at front now, peek it(Visit i.e print), Add its left and right child(The 3rd level is queued)
5. Pop the first level left child
6. Now the first level right child is at front now, peek it(Visit i.e print), Add its left and right child(The 3rd level is queued)

Continue the process until all the elements in queue are de queued

Still doubt then refer myCodeschool on youtube for good explanation

 */
public class LevelOrderTraversal {

    /*
    Method to perform level order traversal
     */
    public void levelOrderTraversal(BinaryTreeNode root) {

        // Create a queue, where the elements of tree will be queued as per the level
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {

            // Just peek the front node and print it, this is the visit step
            BinaryTreeNode node = queue.peek();
            System.out.println(node.data);

            // Add the left and right nodes, if not null,
            // this is process of adding next level to queue
            if (node.leftNode != null) {
                queue.offer(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.offer(node.rightNode);
            }

            // Remove the peeked/visited node
            queue.poll();

        }

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

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.levelOrderTraversal(root);
    }

}
