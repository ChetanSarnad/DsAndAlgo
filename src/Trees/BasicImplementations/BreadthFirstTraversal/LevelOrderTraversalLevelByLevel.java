package Trees.BasicImplementations.BreadthFirstTraversal;

import Trees.BasicImplementations.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Class to demonstrate the level order traversal, print level by level
Btw first refer LevelOrderTraversal in same package for basic understanding.

For tree like

            1
     2              3
  4    5         6     7

In our regular LOT , we print the elements in LOT
Level Order : 1  2 3  4 5 6 7

By level by level, we mean print them level by level, not in a single line
Level 1 = 1
Level 2 = 2, 3
Level 3 = 4, 5, 6, 7

This can be achieved by inserted a null after the root node.
After that, continue as usual of de-queuing and adding child nodes.
Whenever while de-queuing you encounter a null, insert a null again in the queue

Insert root i.e. 1 in the queue, then insert null
Queue : 1  null
Dequeue 1 , visit it and add its children
Queue : null 2  3
Dequeue null, when null is encountered then add a null queue
Queue : 2  3  null
Dequeue 2.... Continue.

So null acts as a separator for the levels

 */
public class LevelOrderTraversalLevelByLevel {

}
