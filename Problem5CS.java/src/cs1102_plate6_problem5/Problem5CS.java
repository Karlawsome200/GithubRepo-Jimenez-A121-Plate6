package cs1102_plate6_problem5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem5CS {
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

        boolean isBipartiteUtil(int src, int[] colorArr) {
            colorArr[src] = 1;
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(src);

            while (!queue.isEmpty()) {
                int u = queue.poll();

                if (adjList[u] != null) {
                    for (int v : adjList[u]) {
                        if (colorArr[v] == -1) {
                            colorArr[v] = 1 - colorArr[u];
                            queue.add(v);
                        } else if (colorArr[v] == colorArr[u]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        boolean isBipartite() {
            int[] colorArr = new int[vertices];
            Arrays.fill(colorArr, -1);

            for (int i = 0; i < vertices; i++)
                if (colorArr[i] == -1)
                    if (!isBipartiteUtil(i, colorArr))
                        return false;
            return true;
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

        if (graph.isBipartite())
            System.out.println("The graph is bipartite.");
        else
            System.out.println("The graph is not bipartite.");

        scanner.close();
    }
}
