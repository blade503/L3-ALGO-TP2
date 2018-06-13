
import java.util.Arrays;
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
public class Recherches {

    public static final int NOMBRE = 50;

    public static void main(String[] args) {
        //int T1[] = new int[NOMBRE];
        //int T2[] = new int[NOMBRE];
        int T3[] = new int[NOMBRE];
        //T1 = multiples(4, NOMBRE);
        //T2 = multiples(3, NOMBRE);
        //commun(T1, T2);
        int T4[]= {1,2,4,5,2,6,8};
        //retirerDoublon(T4);
        retirerNombre(T4,4,2);
    }

    public static int[] commun(int T1[], int T2[]) {
        int tempo[] = new int[NOMBRE];
        int k = 0;

        for (int i = 0; i < NOMBRE; i++) {
            for (int j = 0; j < NOMBRE; j++) {
                if (T1[i] == T2[j]) {
                    //la valeur que l'on en commun
                    tempo[k] = T1[i];
                    // l'indice dans le premier tableau
                    tempo[k + 1] = i;
                    //l'indice dans le second tableau
                    tempo[k + 2] = j;
                    k = k + 3;
                    //mettre toutes les données dans un seul tableau.
                    System.out.print("nombre : " + T1[i] + " en T1 : " + i);
                    System.out.println(" et en T2 : " + j);
                }
            }
        }
        return tempo;
    }

    public static int[] multiples(int q, int nb) {
        int count = 0;
        int num = q;
        int tempo[] = new int[nb];
        for (int i = 0; i < nb; i++) {
            tempo[i] = num;
            num = num + q;
            if (count == nb) {
                return tempo;
            } else {
                count++;
            }
        }
        return tempo;
    }

    public static void saisi() {
        System.out.println("Veuillez saisir la quantité de nombre que vous allez entrer");
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int p = sc.nextInt();
        int tab[] = new int[p];
        for (int i = 0; i < p - 1; i++) {
            int val = sc.nextInt();
            if (checkTab(tab, val) == false) {
                tab[count] = val;
                Arrays.sort(tab);
                count++;
            } else {
                System.out.println("le nombre que vous avez saisr est déjà dans le tableau");
            }

        }
    }

    //2.3
    public static void retirerValTab(int[] tab, int val) {
        for (int i = 0; i < tab.length; i++) {
            if (val == tab[i]) {
                // On retire la valeur en question
                // On recup son indice et on redécale tout.
            }
        }
    }

    //2.4
    public static void retirerDoublon() {
        System.out.println("Veuillez saisir la quantité de nombre que vous allez entrer");
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int p = sc.nextInt();
        int tab[] = new int[p];
        for (int i = 0; i < p; i++) {
            System.out.println("nombre " + (i+1));
            tab[count] = sc.nextInt();
            count++;
        }
        for (int i = 0; i < tab.length; i++) {
            int tempo = tab[i];
            for (int k = i+1; k < tab.length; k++) {
                if (tab[k] == tempo) {
                    for (int q = k; q < tab.length - 1; q++) {
                        tab[q] = tab[q + 1];
                        tab[tab.length-1]=0;
                    }
                }
            }
        }
       printTab(tab);
    }

   public static void retirerDoublon(int[] tab) {
        System.out.println("Quel nombre voulez vous supprimer du tableau ?");
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int aRetirer = sc.nextInt();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == aRetirer && tab[i] != 0) {
                for (int k = i; k < tab.length - 1; k++) {
                    tab[k] = tab[k + 1];
                }
                tab[tab.length - 1] = 0;
            }
            break;
        }
        printTab(tab);
    }
   
      public static void retirerNombre(int[] tab,int indice, int nombre) {
        if(tab[indice]==nombre){
            for (int i = indice ; i < tab.length-1; i++) {
                tab[i] = tab[i+1];
            }
            tab[tab.length-1]=0;
            printTab(tab);
        } else {
            System.out.println("les valeurs fournit ne sont pas bonnes.");
            System.out.println("Il ny' a pas " + nombre + "à l'indice " + indice);
        }
    }

    public static boolean checkTab(int[] tab, int val) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == val) {
                return true;
            }
        }
        return false;
    }
    
     static void printTab(int tab[]) {
        System.out.println("+---------------------------+");
        System.out.print("|");
        for (int i = 0; i < tab.length; i++) {
            System.out.print(" " + tab[i] + " ");
        }
        System.out.println("|");
        System.out.println("+---------------------------+");
    }

}
