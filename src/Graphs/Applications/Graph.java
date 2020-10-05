package Graphs.Applications;

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

import java.util.*;

public class Graph<T>{

    private List<Edge<T>> allEdges;
    private Map<Long, Vertex<T>> allVertex;
    boolean isDirected = false;

    public Graph(boolean isDirected){
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long, Vertex<T>>();
        this.isDirected = isDirected;
    }

    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }

    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    public void addVertex(Vertex<T> vertex){
        if(allVertex.containsKey(vertex.getId())){
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        for(Edge<T> edge : vertex.getEdges()){
            allEdges.add(edge);
        }
    }

    public Vertex<T> addSingleVertex(long id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        allVertex.put(id, v);
        return v;
    }

    public Vertex<T> getVertex(long id){
        return allVertex.get(id);
    }

    public void addEdge(long id1,long id2, int weight){
        Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }

    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertex(){
        return allVertex.values();
    }
    public void setDataForVertex(long id, T data){
        if(allVertex.containsKey(id)){
            Vertex<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}


class Vertex<T> {
    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }

    public String toString(){
        return String.valueOf(id);
    }

    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }

    public List<Edge<T>> getEdges(){
        return edges;
    }

    public int getDegree(){
        return edges.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

class Edge<T>{
    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    Edge(Vertex<T> vertex1, Vertex<T> vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
    }

    Vertex<T> getVertex1(){
        return vertex1;
    }

    Vertex<T> getVertex2(){
        return vertex2;
    }

    int getWeight(){
        return weight;
    }

    public boolean isDirected(){
        return isDirected;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }
}
