/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexandrewetzler
 */
public class Classer {

    public static void main(String[] args) {
        String tab1[] = {"bonjour", "wetzler", "oscar", "alpha", "test"};
        String tab2[] = {"yolo", "bonjour", "Test", "aurevoir"};
        String tab3[] = {"bonjour", "wetzler", "oscar", "alpha", "test"};
        orderWordTab(tab1);
        commun(tab1, tab3);

    }

    //3.1
    public static void orderWordTab(String tab[]) {
        boolean inversion;
        do {
            inversion = false;

            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i].compareTo(tab[i + 1]) > 0) {
                    String tmp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = tmp;
                    inversion = true;
                }
            }
        } while (inversion);
        printTab(tab);
    }

    //3.2
    public static void commun(String T1[], String T2[]) {
        String tempo[] = new String[15];
        int q = 0;
        for (int i = 0; i < T1.length; i++) {
            for (int k = 0; k < T2.length; k++) {
                if (T1[i] == T2[k]) {
                    //la valeur que l'on en commun
                    tempo[q] = T1[i];
                    // l'indice dans le premier tableau
                    tempo[q + 1] = Integer.toString(i);
                    //l'indice dans le second tableau
                    tempo[q + 2] = Integer.toString(k);
                    q = q + 3;
                    //mettre toutes les données dans un seul tableau.
                    System.out.print("nombre : " + T1[i] + " en T1 : " + i);
                    System.out.println(" et en T2 : " + k);
                }
            }
        }
    }

    //3.3
    public static void extraireMot(String mot, String contenu) {
        //.....
    }

    static void printTab(String tab[]) {
        System.out.println("+---------------------------+");
        System.out.print("|");
        for (int i = 0; i < tab.length; i++) {
            System.out.print(" " + tab[i] + " ");
        }
        System.out.println("|");
        System.out.println("+---------------------------+");
    }

}
