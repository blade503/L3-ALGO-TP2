
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alexandrewetzler
 */
public class Calculs {

    static final int TAILLE = 100;

    public static void main(String[] args) {
        //addition();
        int[] premiers = PremiersListe();
        addition(premiers);
        //addition();
    }

    public static void addition() {
        int total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir 10 nombre");
        int tab[] = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("nombre suivant");
            String str = sc.nextLine();
            tab[i] = (Integer.parseInt(str));
            total += Integer.parseInt(str);
        }
        double ecartType = 0;
        double moyenne = total / tab.length + 1;
        int diff = 0;

        for (int i = 0; i < tab.length; i++) {
            diff = diff + (int) ((tab[i] - moyenne) * (tab[i] - moyenne));
        }

        double variance = diff / tab.length;
        ecartType = Math.sqrt(variance);
        System.out.println("la moyenne est de " + moyenne + " et l'écart type est de " + ecartType);
    }

     public static int[] PremiersListe() {
        // declaration et allocation du tableau
        boolean[] premiers = new boolean[TAILLE];

        // initialiser toutes les cases a true (non barre)
        for (int i = 0; i < TAILLE; i++) {
            premiers[i] = true;
        }
        premiers[0] = false;

        int i = 2;
        while (i < TAILLE) {
            // on commence par le permier multiple superieur au nombre courant (i)
            int j = i * 2;
            while (j < TAILLE) {
                // on barre ce multiple
                premiers[j] = false;
                // passage au multiple suivant
                j += i;
            }
            // nombre suivant
            i++;
        }
        int count = 0;
        // affichage du tableau pour verification
        int j = 0;
        for (int k = 0; k < TAILLE; k++) {
            if (premiers[k] == true) {
                count++;
            }
        }
        int tab[] = new int[count];
        for (int k = 0; k < TAILLE; k++) {
            if (premiers[k] == true) {
                tab[j] = k;
                j++;
            }
        }
        System.out.println(count);
        PrintTab(tab);
        return tab;
    }
    
    public static void addition(int tab[]) {
        int total = 0;

        for (int i = 0; i < tab.length; i++) {
            total += tab[i];
        }

        double ecartType = 0;
        double moyenne = total / tab.length + 1;
        int diff = 0;

        for (int i = 0; i < tab.length; i++) {
            diff = diff + (int) ((tab[i] - moyenne) * (tab[i] - moyenne));
        }

        double variance = diff / tab.length;
        ecartType = Math.sqrt(variance);
        System.out.println("la moyenne est de " + moyenne + " et l'écart type est de " + ecartType);
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

}
