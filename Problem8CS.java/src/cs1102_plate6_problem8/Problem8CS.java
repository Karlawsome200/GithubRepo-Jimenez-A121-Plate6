package cs1102_plate6_problem8;

import java.util.Arrays;
import java.util.Scanner;

public class Problem8CS {
    static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n1 = graph1.length;
        int n2 = graph2.length;

        if (n1 != n2) {
            return false;
        }

        int[] degrees1 = new int[n1];
        int[] degrees2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                degrees1[i] += graph1[i][j];
                degrees2[i] += graph2[i][j];
            }
        }

        Arrays.sort(degrees1);
        Arrays.sort(degrees2);

        return Arrays.equals(degrees1, degrees2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices for the first graph:");
        int vertices1 = scanner.nextInt();
        int[][] graph1 = new int[vertices1][vertices1];

        System.out.println("Enter adjacency matrix for the first graph:");
        for (int i = 0; i < vertices1; i++) {
            for (int j = 0; j < vertices1; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter number of vertices for the second graph:");
        int vertices2 = scanner.nextInt();
        int[][] graph2 = new int[vertices2][vertices2];

        System.out.println("Enter adjacency matrix for the second graph:");
        for (int i = 0; i < vertices2; i++) {
            for (int j = 0; j < vertices2; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        if (areIsomorphic(graph1, graph2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        scanner.close();
    }
}
