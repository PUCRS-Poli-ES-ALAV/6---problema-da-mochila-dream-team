import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class BackpackBrutforce {
    private static int cont = 0;

    public static int knapsackDivideAndConquer(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int mid = n / 2;

        List<Integer> leftItems = new ArrayList<>();
        List<Integer> rightItems = new ArrayList<>();
        
        for (int i = 0; i < mid; i++) {
            leftItems.add(i);
        }
        for (int i = mid; i < n; i++) {
            rightItems.add(i);
        }

        int leftMaxValue = knapsackRecursive(values, weights, capacity, leftItems);
        int rightMaxValue = knapsackRecursive(values, weights, capacity, rightItems);

        return Math.max(leftMaxValue, rightMaxValue);
    }

    private static int knapsackRecursive(int[] values, int[] weights, int capacity, List<Integer> items) {
        int n = items.size();
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            int itemIndex = items.get(i);
            int itemWeight = weights[itemIndex];
            int itemValue = values[itemIndex];

            for (int w = capacity; w >= itemWeight; w--) {
                cont++;
                dp[w] = Math.max(dp[w], dp[w - itemWeight] + itemValue);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        // Melhor valor: 277
        // Número de iterações: 1123
        // Time Elapsed: 177731 Nanossegundos
        // int[] pesos = {23, 31, 29, 44, 53, 38, 63, 85, 89, 82};  
        // int[] valores = {92, 57, 49, 68, 60, 43, 67, 84, 87, 72}; 

        // Melhor valor: 114
        // Número de iterações: 645
        // Time Elapsed: 130473 Nanossegundos
        int[] pesos = {56, 59, 80, 64, 75, 17};
        int[] valores = {50, 50, 64, 46, 50, 5}; 

        int capacidade = 165; 


        long startTime = System.nanoTime();
        int maxValue = knapsackDivideAndConquer(valores, pesos, capacidade);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Melhor valor: " + maxValue);
        System.out.println("Número de iterações: " + cont);
        System.out.println("Time Elapsed: " + elapsedTime + " Nanossegundos");
    }
}
