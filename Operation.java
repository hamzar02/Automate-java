package com.company;

import java.util.Objects;


public class Operation {
    String[][] tabAmodifier;
    String[][] tab;
    String[] str;

    Operation(String[][] tab, String[][] tabC, String[] string) {
        this.tab = tab;
        tabAmodifier = tabC;
        str = string;
    }

    public String[][] Completer() {
        for (int i10 = 0; i10 < Integer.parseInt((str[1])) + 1; i10++) {               //RECOPIAGE DE L AUTOMATE TAB
            if (Integer.parseInt((str[0])) + 3 >= 0)
                System.arraycopy(tab[i10], 0, tabAmodifier[i10], 0, Integer.parseInt((str[0])) + 3);
        }
        tabAmodifier[Integer.parseInt((str[1])) + 1][0] = "-";
        tabAmodifier[Integer.parseInt((str[1])) + 1][1] = "P";
        tabAmodifier[Integer.parseInt((str[1])) + 1][2] = "-";
        for (int i10 = 3; i10 < tabAmodifier[2].length; i10++) {
            tabAmodifier[Integer.parseInt((str[1])) + 1][i10] = "P";
        }


        for (int i10 = 1; i10 <= Integer.parseInt((str[1])); i10++) {
            for (int i11 = 3; i11 < Integer.parseInt((str[0])) + 3; i11++) {
                if (tab[i10][i11].equals("-")) {
                    tabAmodifier[i10][i11] = "P";
                }


            }
        }
        return tabAmodifier;
    }


    public String[][] Determiniser() {



        //COPIER PREMIERE LIGNE DE TAB NORMAL
        if (Integer.parseInt((str[0])) + 3 >= 0)
            System.arraycopy(tab[0], 0, tabAmodifier[0], 0, Integer.parseInt((str[0])) + 3);
        for (int i10 = 0; i10 < Integer.parseInt((str[1])) + 1; i10++) {                    //RASSEMBLER LES E ET SE ENSEMBLE SI IL YA QUE DES E CA MET E MAIS SI IL YA AU MOINS UN SE CA MET SE
            if (Objects.equals(tab[i10][0], " E  ") || Objects.equals(tab[i10][0], "SE  ")) {

                System.out.print(tab[i10][0]);

                if (tab[i10][0].equals("SE  ")) {
                    tabAmodifier[1][0] = "SE  ";
                } else {
                    tabAmodifier[1][0] = " E  ";
                }

                if (tabAmodifier[1][1] == null) {
                    tabAmodifier[1][1] = tab[i10][1];
                } else {
                    tabAmodifier[1][1] += tab[i10][1];
                }

                for (int o = 2; o < Integer.parseInt(str[0]) + 3; o++) {
                    if (tabAmodifier[1][o] == null && !Objects.equals(tab[i10][o], "-")) {
                        tabAmodifier[1][o] = tab[i10][o];
                    } else if (tabAmodifier[1][o] != null && !Objects.equals(tab[i10][o], "-")) {
                        {
                            tabAmodifier[1][o] += tab[i10][o];
                        }
                    }
                }

                for (int o = 2; o < Integer.parseInt(str[0]) + 3; o++) {
                    if (tabAmodifier[1][o] != null) {
                        tabAmodifier[1][o] += ",";
                    }
                }
            }
        }








        int indice=1;
        for (int i10 = 1; i10 < tabAmodifier.length; i10++){
            for (int i12 = 3; i12 < tabAmodifier[0].length; i12++){
                if(tabAmodifier[i10][i12]!=null){
                    indice++;
                    tabAmodifier[indice][1]=tabAmodifier[i10][i12];
                    int taille=(tabAmodifier[i10][i12].length()-1)/2;
                    for (int i13=1;i13<tab.length;i13++){
                        for(int t=0;t<=taille ;t++){    //chaque lettre de chaque mot
                            if(tabAmodifier[i10][i12].charAt(t*2)==tab[i13][1].charAt(0) && indice<5 ){
                                if(tabAmodifier[2][3]==null){
                                    System.out.print("\n"+indice);
                                    tabAmodifier[indice][3]=tab[i13][3];   ////// BELEC
                                }
                                else{
                                    tabAmodifier[indice][3]+=tab[i13][3];
                                }

                                System.out.print("==="+tab[i13][1]);


                            }
                        }
                    }

                }
            }

        }



        for (int i10 = 0; i10 < Integer.parseInt((str[1])) + 2; i10++) {               //Ca remplis les cases null en " -  "
            for (int i11 = 0; i11 < Integer.parseInt((str[0])) + 3; i11++) {
                if (tabAmodifier[i10][i11] == null) {
                    tabAmodifier[i10][i11] = "-";
                }
            }
        }

        return tabAmodifier;
    }

}
