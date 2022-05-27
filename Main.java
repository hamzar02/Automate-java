package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("../untitled/src/com/company/text.txt");
        String[] str = new String[30];
        int i = 0;
        //int nbline = 0;
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            str[i] = scan.nextLine();
            //nbline++;

            i++;
        }

        System.out.println("\n");

        /*
        System.out.println("Nombre de ligne : " + nbline);
        System.out.println("Nombre de symbole dans l'automate : " + str[0]);
        System.out.println("Nombre d'états : " + str[1]);

        System.out.println("Nombre d'entrée : " + str[2].charAt(0));

        for (int saut = 2; saut < str[2].length(); saut += 2)    ///Permet d'afficher les caractères des entrées et sorties
            System.out.println(str[2].charAt(saut));

        System.out.println("Nombre de sortie : " + str[3].charAt(0));

        for (int saut = 2; saut < str[3].length(); saut += 2)
            System.out.println(str[3].charAt(saut));

        System.out.println("Nombre de transitions : " + str[4]);

        System.out.println("Les Transitions");

        for (int op = 5; op < nbline; op++)
        {
            System.out.println("Transition : " + str[op]);

            /*if (str[op].charAt(1) == '*')       /// Permet de voir si l'automate est asynchrone
            {
                System.out.println("Asynchrone");
            }


        }

         */

        //Creation des tableaux
        String[][] tab = new String[Integer.parseInt((str[1])) + 1][Integer.parseInt((str[0])) + 3];
        String[][] tabAmodifier = new String[Integer.parseInt((str[1]))+2 ][Integer.parseInt((str[0])) + 3];
        String[][] tabADET = new String[Integer.parseInt((str[1]))+2 ][Integer.parseInt((str[0])) + 3];



        Automate tabNormal = new Automate(tab, str);
        tabNormal.RemplirAutomateTXT();   //le tab qui était vide va mtn etre remplis grace aux indications du fichier txt

        Operation tabC_OP = new Operation(tab, tabAmodifier, str); // tabC_OP correspond aux operation du tab Complet
        tabC_OP.Completer();   // Pour completer la matrice tabComplet

        Operation tabDET= new Operation(tab, tabADET, str); //correspond aux operation du tab deterministe
        tabDET.Determiniser();


        Automate tabModifier= new Automate(tabAmodifier, str);
        Affichage afficherNormal =  new Affichage(tabNormal.estAsynchrone(), tabNormal.estDeterministe(), tabNormal.estComplet());

        Automate tabDETERMINISTE = new Automate(tabADET,str);
        Affichage afficherDet=  new Affichage(tabDETERMINISTE.estAsynchrone(), tabDETERMINISTE.estDeterministe(), tabDETERMINISTE.estComplet());
        Affichage afficherComplet=  new Affichage(tabModifier.estAsynchrone(), tabModifier.estDeterministe(), tabModifier.estComplet());


        //AUTOMATE DE BASE

        System.out.println("\n\nAutomate Normal : ");
        tabNormal.SupprDoublons();
        tabNormal.espacer();
        tabNormal.Affichage();

        //AFFICHER SI CETTE AUTOMATE EST ASYNCHRONE, DETERMINISTE OU COMPLET

        afficherNormal.Asynch();            //AFFFICHER SI C EST ASYNCHRONE OU NON
        afficherNormal.Det();               //AFFICHER SI C EST DETERMINISTE OU NON
        afficherNormal.Complet();           //AFFICHER SI C EST COMPLET OU NON

        if(!tabNormal.estDeterministe()){ // SI CE DERNIER N'EST PAS DETERMINISTE, ALORS ON LE DERMINISE

            //DETERMINISER L AUTOMATE
            System.out.print("\n\n Automate Deterministe : ");
            tabDETERMINISTE.espacer();
            tabDETERMINISTE.Affichage();

            //AFFICHAGE ASYNCHRONE DET COMPLET

            afficherDet.Asynch();            //AFFFICHER SI C EST ASYNCHRONE OU NON
            afficherDet.Det();               //AFFICHER SI C EST DETERMINISTE OU NON
            afficherDet.Complet();           //AFFICHER SI C EST COMPLET OU NON


        }


        if(!tabNormal.estComplet()) { // SI CE DERNIER N'EST PAS COMPLET, ALORS ON LE COMPLETE
            //COMPLETER L'AUTOMATE
            System.out.print("\n\nAutomate Complet : ");

            tabModifier.espacer();
            tabModifier.Affichage();
            //AFFICHAGE ASYNCHRONE DET COMPLET

            afficherComplet.Asynch();            //AFFFICHER SI C EST ASYNCHRONE OU NON
            afficherComplet.Det();               //AFFICHER SI C EST DETERMINISTE OU NON
            afficherComplet.Complet();           //AFFICHER SI C EST COMPLET OU NON

        }





    }
}