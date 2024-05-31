package cs1102_plate6;

import java.util.*;

public class ConnectedGraph {
    static class Graph {
        private int vertices;
        private LinkedList<Integer>[] adjList;

        @SuppressWarnings("unchecked")
        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; ++i) {
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adjList[v].add(w);
            adjList[w].add(v); 
        }

        void DFSUtil(int v, boolean[] visited) {
            visited[v] = true;
            Iterator<Integer> i = adjList[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }
        }

        boolean isConnected() {
            boolean[] visited = new boolean[vertices];
            DFSUtil(0, visited);
            for (int i = 0; i < vertices; i++) {
                if (!visited[i])
                    return false;
            }
            return true;
        }

        int connectedComponents() {
            boolean[] visited = new boolean[vertices];
            int count = 0;
            for (int v = 0; v < vertices; ++v) {
                if (!visited[v]) {
                    DFSUtil(v, visited);
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int edges = scanner.nextInt();
        
        Graph graph = new Graph(vertices);
        
        System.out.println("Enter edges (format: v1 v2):");
        for (int i = 0; i < edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            if (v1 >= vertices || v2 >= vertices) {
                System.out.println("Error: Vertex numbers must be between 0 and " + (vertices - 1));
                i--; 
                continue;
            }
            graph.addEdge(v1, v2);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int components = graph.connectedComponents();
            System.out.println("The graph is not connected. Number of connected components: " + components);
        }

        scanner.close();
    }
}

