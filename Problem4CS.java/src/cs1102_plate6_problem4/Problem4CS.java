package cs1102_plate6_problem4;

import java.util.Scanner;

public class Problem4CS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int edges = scanner.nextInt();

        int[] degree = new int[vertices];

        System.out.println("Enter edges (format: v1 v2):");
        for (int i = 0; i < edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            degree[v1]++;
            degree[v2]++;
        }

        System.out.println("Degrees of vertices:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " has degree " + degree[i]);
        }

        scanner.close();
    }
}
