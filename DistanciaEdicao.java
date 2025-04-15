public class DistanciaEdicao{
    private static int cont;
    public static void main(String[] args){
        // String s = "Casablanca";
        // String t = "Portentoso";

        String s = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
                "simplify the build processes in the Jakarta Turbine project. There were several" +
                " projects, each with their own Ant build files, that were all slightly different." +
                "JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+
                "definition of what the project consisted of, an easy way to publish project information" +
                "and a way to share JARs across several projects. The result is a tool that can now be" +
                "used for building and managing any Java-based project. We hope that we have created " +
                "something that will make the day-to-day work of Java developers easier and generally help " +
                "with the comprehension of any Java-based project.";
        String t = "This post is not about deep learning. But it could be might as well. This is the power of " +
                "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
                "ask? I am going to try to answer this question in this article." +
                    "Go to the profile of Marin Vlastelica Pogančić" +
                    "Marin Vlastelica Pogančić Jun";

        //int distancia = calculaDistancia(s, t, s.length(), t.length());
        int distancia2 = distEdProgDina(s,t);
        System.out.println("distancia = " + distancia2);
        System.out.println("cont = " + cont);
    }

        // String s = "Casablanca";
        // String t = "Portentoso";
        // distancia = 10
        // cont = 10100193
    public static int calculaDistancia(String s, String t, int i, int j){
        cont++;
        if (i == 0 && j == 0){
            return 0;
        }
        if (i == 0){
            return j;
        }
        if (j == 0){
            return i;
        }
        if (s.charAt(i-1) == t.charAt(j-1)){
            return calculaDistancia(s, t, i-1, j-1);
        }
        int substituicao = calculaDistancia(s, t, i-1, j-1) + 1;
        int insercao = calculaDistancia(s, t, i, j-1) + 1;
        int remocao = calculaDistancia(s, t, i-1, j) + 1;
        return Math.min(Math.min(substituicao, insercao), remocao);
    }

    // String s = "Casablanca";
    // String t = "Portentoso";
    // distancia = 10
    // cont = 120

    // String s = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
    // "simplify the build processes in the Jakarta Turbine project. There were several" +
    // " projects, each with their own Ant build files, that were all slightly different." +
    // "JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+
    // "definition of what the project consisted of, an easy way to publish project information" +
    // "and a way to share JARs across several projects. The result is a tool that can now be" +
    // "used for building and managing any Java-based project. We hope that we have created " +
    // "something that will make the day-to-day work of Java developers easier and generally help " +
    // "with the comprehension of any Java-based project.";
    // String t = "This post is not about deep learning. But it could be might as well. This is the power of " +
    // "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
    // "ask? I am going to try to answer this question in this article." +
    //     "Go to the profile of Marin Vlastelica Pogančić" +
    //     "Marin Vlastelica Pogančić Jun";
    // distancia = 557
    // cont = 228641
    public static int distEdProgDina(String A, String B){
        int m = A.length();
        int n = B.length();
        int custoExtra = 0;
        int[][] matriz = new int[m+1][n+1];
        matriz[0][0] = 0;
        for (int i = 1; i <= m; i++){
            cont++;
            matriz[i][0] = matriz[i-1][0] + 1;
        }
        for (int j = 1; j <= n; j++){
            cont++;
            matriz[0][j] = matriz[0][j-1] + 1;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                cont++;
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    custoExtra = 0;
                } else {
                    custoExtra = 1;
                }
                matriz[i][j] = Math.min(Math.min(matriz[i-1][j] +1, matriz[i][j-1] +1), matriz[i-1][j-1] + custoExtra);
            }
        }
        return matriz[m][n];
    }
}