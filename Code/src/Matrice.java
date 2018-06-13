
public class Matrice {

    public static void main(String[] args) {
        int MAT1[][] = {{1, 2, 1},
                        {2, 1, 2},
                         {1, 2, 1}};

        int MAT2[][] = {{1, 2, 1},
                        {2, 1, 2},
                        {1, 2, 1}};

        int MAT3[][] = {{1, 2, 1},
                        {2, 1, 2},
                        {1, 2, 1}};
        
        MAT3 = add(MAT1, MAT2);
        PrintTab(MAT3);
        MAT3 = multiply(MAT1, MAT2);
        PrintTab(MAT3);
    }

    static void PrintTab(int tab[][]) {
        for (int i = 0; i < tab.length; i++) {
            for (int k = 0; k < tab.length; k++) {
                if (k % 3 == 0) {
                    System.out.println("");
                }
                System.out.print(" " + tab[i][k] + " ");

            }
        }
        System.out.println("");
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        int nB = B[0].length;
        if (nA != mB) {
            throw new RuntimeException("La dimension de la matric n'est pas bonne");
        }
        int[][] C = new int[mA][nB];
        for (int i = 0; i < mA; i++) {
            for (int j = 0; j < nB; j++) {
                for (int k = 0; k < nA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static int[][] add(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

}
