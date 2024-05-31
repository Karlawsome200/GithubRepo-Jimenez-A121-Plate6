package cs1102_plate6_problem3;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem3CS {
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
            adjList[w].add(v); // Since the graph is undirected
        }

        boolean isCyclicUtil(int v, boolean[] visited, int parent) {
            visited[v] = true;
            Integer i;

            for (Integer it : adjList[v]) {
                i = it;
                if (!visited[i]) {
                    if (isCyclicUtil(i, visited, v))
                        return true;
                } else if (i != parent)
                    return true;
            }
            return false;
        }

        boolean isCyclic() {
            boolean[] visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++)
                if (!visited[i])
                    if (isCyclicUtil(i, visited, -1))
                        return true;

            return false;
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
            graph.addEdge(v1, v2);
        }

        if (graph.isCyclic())
            System.out.println("The graph contains a cycle.");
        else
            System.out.println("The graph does not contain a cycle.");

        scanner.close();
    }
}
