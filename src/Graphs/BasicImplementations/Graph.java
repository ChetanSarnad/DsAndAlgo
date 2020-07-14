package Graphs.BasicImplementations;

/*

This class is mostly for representation and explanation about graphs

A graph G can be defined as a set of ordered pair of vertices and V and set of edges E

G = (V, E)

Vertices V are the nodes.
Edges E are the lines that connect one vertex to another.

Graphs with edges having direction are called Digraph or Directed Graph.
Graphs with edges not having any directions associated are called Undirected Graph

Graphs with edges having some weights is called Weighted graph.
If Vertices are cities then weight of edges could be distance between them etc.

Some terms,
Self loop : Having an edge to itself
Multi Edge : Multiple edges from one vertex to another. Ex : Different flights from one city to another. Might have diff weights.

If Graph does not have self loop or multi edge, it is called as a simple graph.

Number of Edges in simple graph :

For directed graphs, like A pointing to B and B pointing to A.
if V = n
E = n * (n - 1)

For undirected graphs, there will be only one edge between A and B
hence, E = n * (n - 1) / 2


Some more terms,

Walk : A sequence of vertices where each adjacent pair of vertices is connected by an edge

Path : A walk in which no vertices(and hence no edges) are repeated

Trail : A walk in which no edges are repeated, the vertex could be repeated.

Graphs can distinguished based on connection:
Strongly connected : All vertices have a path connection to all other vertices
Weakly connected : Not all may have path connection in directed graph, but if converted to undirected, there should be path
Not connected : Some vertices are not connected to others


Cyclic Graph : If there a loop
Acyclic Graph : No cycles in the graph. Ex : Trees


Adjacency Matrix:
----------------

Suppose if 4 vertices : A,  B,  C,  D

A connected to B, B connected to C, C to D and D to A
All are directed edges.

  A -----------> B
  ^              |
  |              ~
  D <----------- C

Vertex list
Index    Vertex
0         A
1         B
2         C
3         D

Adjacency matrix now using indices of vertex

      |  0       1       2       3
------|------------------------------
0     |  0       1       0       0
      |
1     |  0       0       1       0
      |
2     |  0       0       0       1
      |
3     |  1       0       0       0

 */

public class Graph {
}
