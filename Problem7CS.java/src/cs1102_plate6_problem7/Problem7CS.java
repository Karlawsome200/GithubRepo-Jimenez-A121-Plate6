package cs1102_plate6_problem7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem7CS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int edges = scanner.nextInt();

        Map<String, Integer> edgeCount = new HashMap<>();

        System.out.println("Enter edges (format: v1 v2 count):");
        for (int i = 0; i < edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int count = scanner.nextInt();
            String edge = v1 + "-" + v2;
            edgeCount.put(edge, count);
        }

        int[][] incidenceMatrix = new int[vertices][edges];
        int edgeIndex = 0;

        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            String[] verticesPair = entry.getKey().split("-");
            int v1 = Integer.parseInt(verticesPair[0]);
            int v2 = Integer.parseInt(verticesPair[1]);
            int count = entry.getValue();
            
            for (int i = 0; i < count; i++) {
                incidenceMatrix[v1][edgeIndex] = 1;
                incidenceMatrix[v2][edgeIndex] = 1;
                edgeIndex++;
            }
        }

        System.out.println("Incidence Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
