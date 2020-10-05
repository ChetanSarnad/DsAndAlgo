package Trees.Applications;

/*

Take an example of the below tree



                                1

                            /       \
                         2            3
                       /  \         /   \
                    4       5      6     7
                     \
                      8

Boundary traversal means 3 things
1. Left boundary traversal  : [1  2  4  8]
2. Right boundary traversal : [1  3  7]
3. Leaf nodes traversal     : [8  5  6  7]

Couple of things to note, we see that root node 1 is available in both left and right boundary list.
Hence, we need to consider only once, during right boundary traversal, we could directly start traversal from root.right.
Another thing to note is, couple of leaf nodes are repeated like 8 in left and 7 is right boundary traversal.
Probably we could ignore leaf node in either one of the flow.

Now let us see how we can perform the steps 1, 2 and 3.

1. Left boundary traversal :
Start from root, print and traverse left nodes continuously until null left node hit.
Check if right available like in case of node 8, print it and again continue with check for left with its children.
So we continue to do this until a left or a right is available.
Here we stop at node 8. Since there is no left of right for it.

Pseudo code :

void left_bdr(Node root){

    if(root != null){

        if(root.left != null){
            print(root.value);
            left_bdr(root.left);
        }

        else if(root.right != null){
            print(root.value);
            left_bdr(root.right);
        }
    }

}

2. Right boundary traversal :
This is similar to the right boundary traversal, only thing is we start printing and traversing the right nodes first.

Pseudo code :

void right_bdr(Node root){

    if(root != null){

        if(root.right != null){
            print(root.value);
            right_bdr(root.right);
        }

        else if(root.left != null){
            print(root.value);
            right_bdr(root.left);
        }
    }
}

Note : We could directly pass root.right to this right_bdr method to avoid duplication of root node.

3. Leave nodes traversal:
Refer the class PrintLeafNodesInBinaryTree in the same package to print all the leaf nodes.

 */
public class BoundaryTraversalOfBinaryTree {
}
