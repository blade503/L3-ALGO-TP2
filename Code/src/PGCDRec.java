/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexandrewetzler
 */
public class PGCDRec {
         
            /** Creates a new instance of PGCDRec */
            static int  PGCDRec( int A , int B ) {
         
                if (A == B ){
                    return A ;
                }else {
         
                if ( A > B ){
                    return PGCDRec (A- B ,B);
         
         
                }else {
                    return PGCDRec ( A , B-A );
                }
                }
         
         
            }
         
         
         
         
            public static void main (String [] args ){
                int A, B ;
                int pgcd ;

         
                pgcd = PGCDRec (30, 40);
                System.out.println ("Le PGCD des 2 entiers saisi est  " + pgcd );
         
         
            }
         
        }
