package com.company;

public class Affichage {
    boolean Asyn;
    boolean Det;
    boolean Comp;
    Affichage(boolean Asynchrone, boolean det, boolean Complet){
        Asyn=Asynchrone;
        Det=det;
        Comp=Complet;

    }
    public void Asynch (){
        if (Asyn){
            System.out.print("\nL'automate est asynchrone");
        }
        else{
            System.out.print("\nL'automate est synchrone");
        }
    }
    public void Det(){
        if (Det){
            System.out.print("\nL'automate est Deterministe");
        }
        else{
            System.out.print("\nL'automate n'est pas Deterministe");
        }
    }
    public void Complet(){
        if (Comp){
            System.out.print("\nL'automate est complet");
        }
        else{
            System.out.print("\nL'automate n'est pas complet");
        }
    }

}
