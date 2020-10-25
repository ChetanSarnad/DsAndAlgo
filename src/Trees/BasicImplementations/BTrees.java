package Trees.BasicImplementations;

/*

This is to discuss the below mentioned topics

1. Indexing in data bases

2. M-way trees, multi way trees

3. B Trees

4. B+ Tress

You can refer to https://www.youtube.com/watch?v=aZjYr87r1b8 for more details

1. Indexing in databases :
Indexing means for each row, we maintain the mapping of the row's indexed key to the block and sector index on the disk.
It may so happen that there are high number of rows, then the index entries also grows. Now the index itself requires another index.
Hence we might need multi level of indexing.
Lets see how the M-way trees / B Trees / B+ Trees.

2. M-way trees :
Like Binary trees mean there will be two children for each node, M-way trees mean there can be m children for each node.
And not only have m children, it can also have multiple keys at each node. And keys will be m - 1.
As an example, lets consider 3-way tree. Keys will be 3-1 = 2 keys.

                       (10, 30)

             (5,6)     (12,18)     (32,38)

First set of children are lesser than 10, second set are >10 but <30, third set are > 30

3. B Trees :
B Trees are specialized M-way trees with certain rules.
i.   For M-way, each node must have at least m/2 children
ii.  Root can have only two children
iii. All leaf nodes should be at same level
iv.  Creation process is bottom up.
     Nodes are inserted from bottom of the tree, if required parent nodes are created if child nodes are filled.
     This matches indexing requirement, if required secondary index are again created. Not just two, it might be multi level.

In B Trees, each node, apart from child nodes info, will also have record pointer i.e pointer to record on the disk


4. B+ Trees :
Only difference from B Trees is, it has all nodes and record pointers in the leaf nodes.

 */

public class BTrees {
}
