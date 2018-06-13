/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexandrewetzler
 */
public class Tri {

    public final static int TAILLEMAX = 50;

    public static void main(String[] args) {
        int[] tableau = generationTableau(TAILLEMAX);
        System.out.println("tableau initial non-trié");
        PrintTab(tableau);
        System.out.println("\n");
        System.out.println("tableau resultat du tri fusion");
        long temps1 = System.currentTimeMillis();
        triFusion(tableau);
        long temps2 = System.currentTimeMillis();
        long res = temps2 - temps1;
        System.out.println("le calcul du tri fusion a mis ->" + res + "ms\n\n");

        System.out.println("tableau résultat du tri par shell");
        temps1 = System.currentTimeMillis();
        tri_shell(tableau);
        temps2 = System.currentTimeMillis();
        res = temps2 - temps1;
        System.out.println("le calcul du tri shell a mis ->" + res + "ms\n\n");

        System.out.println("tableau résultat du tri à bulles");
        tri_bulles(tableau);
        System.out.println("tableau résultat du tri par insertion");
        tri_insertion(tableau, TAILLEMAX);
        System.out.println("tableau résultat du tri par selection");
        tri_selection(tableau, TAILLEMAX);

    }

    static void PrintTab(int tab[]) {
        System.out.println("+---------------------------+");
        System.out.print("|");
        for (int i = 0; i < tab.length - 1; i++) {
            System.out.print(" " + tab[i] + " ");
        }
        System.out.println("|");
        System.out.println("+---------------------------+");
    }

    static int[] generationTableau(int taille) {
        int[] tableau = new int[taille];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = (int) ((int) 1 + Math.random() * 100);
        }
        return tableau;
    }

    public static void tri_bulles(int tableau[]) {
        int longueur = tableau.length;
        boolean inversion;

        do {
            inversion = false;

            for (int i = 0; i < longueur - 1; i++) {
                if (tableau[i] > tableau[i + 1]) {
                    echanger(tableau, i, i + 1);
                    inversion = true;
                }
            }
        } while (inversion);
        PrintTab(tableau);
    }
    
        // Échange deux éléments d'un tableau
    static void echanger(int tab[], int x, int y) {
        int tmp;

        tmp = tab[x];
        tab[x] = tab[y];
        tab[y] = tmp;
    }

    static void inserer(int element_a_inserer, int tab[], int taille_gauche) {
        int j;
        for (j = taille_gauche; j > 0 && tab[j - 1] > element_a_inserer; j--) {
            tab[j] = tab[j - 1];
        }
        tab[j] = element_a_inserer;
    }

    static void tri_insertion(int tab[], int taille) {
        int i;
        for (i = 1; i < taille; ++i) {
            inserer(tab[i], tab, i);
        }

        PrintTab(tab);
    }

    public static void tri_shell(int tableau[]) {
        int longueur = tableau.length;
        int n = 0;

        while (n < longueur) {
            n = 3 * n + 1;
        }

        while (n != 0) {
            n = n / 3;
            for (int i = n; i < longueur; i++) {
                int valeur = tableau[i];
                int j = i;

                while ((j > (n - 1)) && (tableau[j - n] > valeur)) {
                    tableau[j] = tableau[j - n];
                    j = j - n;
                }
                tableau[j] = valeur;
            }
        }
        PrintTab(tableau);
    }

    //Renvoie l'indice du plus grand élément du tableau
    static int max(int tab[], int taille) {
        // on considère que le plus grand élément est le premier
        int i = 0, indice_max = 0;

        while (i < taille) {
            if (tab[i] > tab[indice_max]) {
                indice_max = i;
            }
            i++;
        }

        return indice_max;
    }



    static void tri_selection(int tab[], int taille) {
        int indice_max;

	// à chaque tour de boucle, on va déplacer le plus grand élément
        // vers la fin du tableau, on diminue donc à chaque fois sa taille
        // car le dernier élément est obligatoirement correctement
        // placé (et n'a donc plus besoin d'être parcouru/déplacé)
        for (; taille > 1; taille--) // tant qu'il reste des éléments non triés
        {
            indice_max = max(tab, taille);

            echanger(tab, taille - 1, indice_max); // on échange le dernier élément avec le plus grand
        }
        PrintTab(tab);
    }

    public static void triFusion(int tableau[]) {
        int longueur = tableau.length;
        if (longueur > 0) {
            triFusion(tableau, 0, longueur - 1);
        }
        PrintTab(tableau);
    }

    private static void triFusion(int tableau[], int deb, int fin) {
        if (deb != fin) {
            int milieu = (fin + deb) / 2;
            triFusion(tableau, deb, milieu);
            triFusion(tableau, milieu + 1, fin);
            fusion(tableau, deb, milieu, fin);
        }
    }

    private static void fusion(int tableau[], int deb1, int fin1, int fin2) {
        int deb2 = fin1 + 1;

        //on recopie les éléments du début du tableau
        int table1[] = new int[fin1 - deb1 + 1];
        for (int i = deb1; i <= fin1; i++) {
            table1[i - deb1] = tableau[i];
        }

        int compt1 = deb1;
        int compt2 = deb2;

        for (int i = deb1; i <= fin2; i++) {
            if (compt1 == deb2) //c'est que tous les éléments du premier tableau ont été utilisés
            {
                break; //tous les éléments ont donc été classés
            } else if (compt2 == (fin2 + 1)) //c'est que tous les éléments du second tableau ont été utilisés
            {
                tableau[i] = table1[compt1 - deb1]; //on ajoute les éléments restants du premier tableau
                compt1++;
            } else if (table1[compt1 - deb1] < tableau[compt2]) {
                tableau[i] = table1[compt1 - deb1]; //on ajoute un élément du premier tableau
                compt1++;
            } else {
                tableau[i] = tableau[compt2]; //on ajoute un élément du second tableau
                compt2++;
            }
        }
    }
    
    
    

}
