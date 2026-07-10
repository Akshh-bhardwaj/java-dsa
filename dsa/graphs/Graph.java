package dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int numVertices;
    private LinkedList<Integer>[] adjLists;

    // Constructor
    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.numVertices = vertices;
        this.adjLists = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    // Add Edge (Undirected)
    public void addEdge(int src, int dest) {
        adjLists[src].add(dest);
        adjLists[dest].add(src); // Symmetric link for undirected graph
    }

    // Breadth-First Search (BFS) Traversal
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS (starting from vertex " + startVertex + "): ");

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjLists[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS) Traversal
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        System.out.print("DFS (starting from vertex " + startVertex + "): ");
        DFSRecursive(startVertex, visited);
        System.out.println();
    }

    private void DFSRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjLists[vertex]) {
            if (!visited[neighbor]) {
                DFSRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Graph Test ---");
        /*
             0 ---- 1
             |    / |
             |  /   |
             2 ---- 3
        */
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        g.BFS(0); // Expected BFS: 0 1 2 3
        g.DFS(0); // Expected DFS: 0 1 2 3 (depending on traversal adjacency list ordering)
    }
}
