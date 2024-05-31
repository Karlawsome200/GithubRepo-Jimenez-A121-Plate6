import java.util.*;

public class Problem2OfficialCS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int vertices = scanner.nextInt();

        int[][] adjacencyMatrix = new int[vertices][vertices];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        Map<String, Integer> edgeCount = new HashMap<>();

        System.out.println("Edges and their counts:");
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCount.put(edge, adjacencyMatrix[i][j]);
                    System.out.println(edge + ": " + adjacencyMatrix[i][j]);
                }
            }
        }

        scanner.close();
    }
}
