package Graphs.BasicImplementations;

/*

There are two things in graph traversal,
1. Visiting
2. Exploration (Identify  all the children)

There are two ways to traverse a graph
1. Depth First Search
2. Breadth First Search - Level by level traversal

BFS :
Here we visit the node, explore it i.e. visit all its children. Then explore each of its children.

This is achieved using a queue.
We visit a node, add it to queue, pop the item from queue and add all its children to queue.
Now continuing popping the elements from queue and add its children to queue.
This will do level order traversal.
Refer trees section, already implemented.

DFS :

Here we visit the node, explore it, once the first children is found, start exploring that child and continue in depth.
Once reached till leaf node, go back to its parent and find next child to explore, continue till all nodes visited.

This can be achieved using recursion or stack.
Using recursion already implemented in trees section.

Using stack
Visit a node, add it to stack, explore it, visit the first child, add to stack and start exploring it.
When reached end, pop the latest inserted element and start exploring its other children.

What is spanning tree?
When a graph is converted to tree, all vertices are included.
But only minimal number of edges will be present.
A vertex might be connected to many vertices, but will be shown once, might be other connections shown in dotted line.

 */
public class GraphTraversal {
}
