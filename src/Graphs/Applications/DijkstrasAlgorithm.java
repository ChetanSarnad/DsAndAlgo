package Graphs.Applications;

/*

Dijkstra algorithm is based on greedy algorithm, where in we choose the shortest path to the nodes.

This algorithm helps in find the shortest path from a designated source node to all other nodes.

The algorithm is based on the logic mentioned below, using just three nodes for explanation

Lets have 3 nodes 1, 2 and 3
1st node is connected to 2nd node with distance weight of 2
2nd is connected to 3rd node with distance weight of 4.

The 2nd node is represented as u for generalisation.
3rd node is represented as v.

d(u) is distance of node u from origin node, i.e. 1st node in this case
d(v) is distance of node v from origin node.

cost between two nodes is the weight between two nodes.
c(u,v) is 4 in our case

Distance d(u) can be directly assigned since it is directly connected to start node. It is assigned with value 2.
Distance d(v) is assigned infinite value, since there is no direct connection from start node.

            2       d(u) = 2       4       d(v) = infinite
     1 ------------>  2   -------------->   3
                      u               v

Now shortest path to u is d(u) is 2.
We have to see the shortest path for v.
This process is called relaxation.

Below is formula used for relaxation

if ( d(u) + c(u,v) < d(v))
{
    d(v) = d(u) + c(u,v)
}

In our case d(v) is infinite, so our d(u) + c(u,v) = 2+4 = 6 is definitely lesser than infinity
Hence we can set d(v) as 6


For further explanation https://www.youtube.com/watch?v=XB4MIexjvY0

 */
public class DijkstrasAlgorithm {
}
