package com.company;
import java.util.Arrays;
import java.util.Objects;


public class Automate {


    String[][] tab;
    String[][] tabC;
    String[] str;

    Automate(String[][] tableau, String[] string) {
        tab = tableau;
        str = string;
    }

    public void Affichage() {
        for (String[] strings : tab) {
            System.out.println(" ");
            for (String string : strings) {
                System.out.print(string + " ");

            }
        }
    }

    public Boolean estAsynchrone() {
        boolean Asynchrone = false;
        for (int j = 1; j < tab.length; j++) {
            if (!Objects.equals(tab[j][2], "-")) {
                Asynchrone = true;

                break;
            }

        }
        return Asynchrone;
    }


    public String[][] espacer() {

        for (int i7 = 0; i7 < tab[2].length - 1; i7++) {
            int NBRMAX = 2;
            for (String[] strings : tab) {  //PERMET D ETABLIR LA PLUS GRANDE LIGNE DE LA COLONNE POUR LES ESPACES
                if (NBRMAX < strings[i7].length()) {
                    NBRMAX = strings[i7].length();
                }
            }
            for (int i5 = 0; i5 < tab.length; i5++) {
                int nbractuelle = tab[i5][i7].length();               // nbractuelle = nombre actuelle de caractere dans la case
                int NbrEspace = NBRMAX + 1 - nbractuelle;                 // formule pour établir le nombre d'espace optimal
                for (int i6 = 0; i6 < NbrEspace; i6++) {
                    tab[i5][i7] = tab[i5][i7] + " ";
                }
            }
        }
        return tab;
    }

    public String[][] RemplirAutomateTXT() {
        String[] alphabet = new String[26];
        int ascii = 97;


        for (int h = 0; h <= 25; h++) {
            alphabet[h] = String.valueOf((char) ascii);
            ascii++;
        }
        /// Permet mettre des tirets a la place de null
        for (String[] strings : tab) {
            Arrays.fill(strings, "-");
        }
        tab[0][2] = " *";

        for (int i3 = 2; i3 < tab[0].length - 1; i3++)  /// Permet de mettre les symboles en focntion du nombre de symboles
        {
            tab[0][i3 + 1] = " " + alphabet[i3 - 2];
        }
        int nb = 0;

        for (int i4 = 1; i4 < Integer.parseInt((str[1])) + 1; i4++) // mettre les entrees
        {
            tab[i4][1] = "" + nb;
            nb++;
        }


        for (int i5 = 0; i5 < Character.getNumericValue(str[2].charAt(0)); i5++) {  // AFFICHAGE DE E

            tab[Character.getNumericValue(str[2].charAt(2 + 2 * i5) + 1)][0] = " E  ";
        }

        for (int i5 = 0; i5 < Character.getNumericValue(str[3].charAt(0)); i5++) { //AFFICHAGE DES SE OU DES S

            if (tab[Character.getNumericValue(str[3].charAt(2 + 2 * i5) + 1)][0].equals(" E  ")) { //SI LA CASE EST REMPLIS PAR E, CA LA REND SE
                tab[Character.getNumericValue(str[3].charAt(2 + 2 * i5) + 1)][0] = "SE  ";
            } else {
                tab[Character.getNumericValue(str[3].charAt(2 + 2 * i5) + 1)][0] = " S  ";//SINON  ÇA LA REMPLIS PAR S
            }
        }

        int ligne = 4;
        for (int i5 = 0; i5 < Integer.parseInt((str[4])); i5++) {
            ligne = ligne + 1;
            int transition1 = Character.getNumericValue(str[ligne].charAt(0));
            char transitionLettre = str[ligne].charAt(1);
            int transition2 = Character.getNumericValue(str[ligne].charAt(2));

            //Si transition = epsilon
            if (transitionLettre == '*') {
                if (tab[transition1 + 1][2].equals("-")) {
                    tab[transition1 + 1][2] = "" + transition2 + "";

                } else {
                    tab[transition1 + 1][2] = tab[transition1 + 1][2] + "," + transition2 + "";
                }
            }

            //Si transition est une lettre allant de a à z
            for (int i10 = 0; i10 < Integer.parseInt((str[0])); i10++) {
                if (transitionLettre == alphabet[i10].charAt(0)) {
                    if (tab[transition1 + 1][3 + i10].equals("-")) {
                        tab[transition1 + 1][3 + i10] = "" + transition2;

                    } else {
                        tab[transition1 + 1][3 + i10] = tab[transition1 + 1][3 + i10] + "," + transition2 + "";
                    }
                }
            }

        }
        return tab;
    }


    public Boolean estDeterministe() {

        int count = 0;
        for (int i10 = 0; i10 < Integer.parseInt((str[1])) + 1; i10++) {
            if (tab[i10][0].equals(" E  ") || tab[i10][0].equals("SE  ")) {
                count++;
            }

        }
        if (count != 1) {
            return false;
        } else {

            for (int i10 = 1; i10 < tab.length; i10++) {
                for (int i11 = 2; i11 < tab[0].length; i11++) {
                    for (int i12 = 1; i12 < tab.length; i12++) {
                        if (!Objects.equals(tab[i10][i11], tab[i12][1])) {
                            return false;

                        }
                    }

                }
            }


        }
        return true;
    }


    public Boolean estComplet() {
        for (int i10 = 1; i10 < tab.length; i10++) {               //Ca remplis les cases null en " -  "
            for (int i11 = 3; i11 < tab[0].length; i11++) {
                if (Objects.equals(tab[i10][i11], "-")) {
                    return false;
                }

            }
        }
        return true;

    }


    public void SupprDoublons() {
        int onject=0;
        for(int i=1; i<tab.length; i++){
            for(int i1=2; i1<tab[0].length; i1++){

                for(int i2=0;i2<tab[i][i1].length();i2++){
                    for(int i3=0;i3<tab[i][i1].length();i3++){//
                        if(tab[i][i1].charAt(i2)==tab[i][i1].charAt(i3) && tab[i][i1].length()>1 ){
                            System.out.print("JOUNA"+tab[i][i1].charAt(i2));


                            System.out.println("test : "+ String.valueOf(tab[i][i1].charAt(i2)));
                           tab[i][i1]=tab[i][i1].replaceAll(String.valueOf(tab[i][i1].charAt(i2)),"");

                            //System.out.print("=>"+tab[i][i1]);

                        }
                    }


                }

            }

            }


    }

}






