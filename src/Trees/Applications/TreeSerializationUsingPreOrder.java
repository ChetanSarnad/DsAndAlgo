package Trees.Applications;

/*

Consider the tree

                        1
                      /   \
                   2        5
                 /  \
               3     4

We perform pre order traversal to serialize and deserialize the tree. Let us see how

Serialize:
----------
We start from the root, node 1, the serialization string is 1,.
Then we jump to its left subtree with the root node 2, and the serialization string becomes 1,2,.
Now starting from node 2, we visit its left node 3 (1,2,3,None,None,) and right node 4 (1,2,3,None,None,4,None,None) sequentially.
Note that None,None, appears for each leaf to mark the absence of left and right child node,
this is how we save the tree structure during the serialization.
And finally, we get back to the root node 1 and visit its right subtree which happens to be a leaf node 5.
Finally, the serialization string is done as 1,2,3,None,None,4,None,None,5,None,None,.

Deserialize:
------------
Deserialize the serialization string constructed above 1,2,3,None,None,4,None,None,5,None,None,.
It goes along the string, initiate the node value and then calls itself to construct its left and right child nodes.

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeSerializationUsingPreOrder {

    public String rserialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
}
