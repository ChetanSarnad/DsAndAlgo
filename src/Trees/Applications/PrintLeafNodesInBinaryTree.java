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

Leaf nodes are [8  5  6  7]

What are considered as leaf nodes?
Nodes which do not have any child nodes are called leaf nodes (Neither left nor right, i.e, no child nodes)

Now the algorithm includes, traverse left subtree recursively, base case return when null node hit.
Now for the node at the end, check if any children present, if not, add to leaf nodes list.
Similarly start traversing the right subtree.


Sample pseudo code :

void printLeaf(Node root){

    if(root == null)
        return ;

    printLeaf(root.left);

    if(root.left == null and root.right == null)
        print root;

    printLeaf(root.right);
}



 */

public class PrintLeafNodesInBinaryTree {
}
