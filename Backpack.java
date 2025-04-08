public class Backpack {
    private static int cont;

    static class Item {
        int peso;
        int valor;

        public Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static int backPackPD(int N, int C, Item[] itens) {
        int[][] maxTab = new int[N + 1][C + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= C; j++) {
                if (i == 0 || j == 0) {
                    maxTab[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                cont++;
                if (itens[i - 1].peso <= j) {
                    maxTab[i][j] = Math.max(maxTab[i - 1][j], 
                        itens[i - 1].valor + maxTab[i - 1][j - itens[i - 1].peso]);
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }

        return maxTab[N][C];
    }

    public static void main(String[] args) {
        // Valor máximo na mochila: 309
        // Número de iterações: 1650
        // Time Elapsed: 283569 Nanossegundos
        //int[] pesos = {23, 31, 29, 44, 53, 38, 63, 85, 89, 82};  
        //int[] valores = {92, 57, 49, 68, 60, 43, 67, 84, 87, 72}; 

        // Valor máximo na mochila: 119
        // Número de iterações: 990
        // Time Elapsed: 182019 Nanossegundos
        int[] pesos = {56, 59, 80, 64, 75, 17};
        int[] valores = {50, 50, 64, 46, 50, 5}; 
        int N = pesos.length;  
        int C = 165;  

        Item[] itens = new Item[N];
        for (int i = 0; i < N; i++) {
            itens[i] = new Item(pesos[i], valores[i]);
        }

        long startTime = System.nanoTime();
        int resultado = backPackPD(N, C, itens);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Valor máximo na mochila: " + resultado); 
        System.out.println("Número de iterações: " + cont);
        System.out.println("Time Elapsed: " + elapsedTime + " Nanossegundos");
    }
}
