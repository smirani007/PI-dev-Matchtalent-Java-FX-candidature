package services;

import entity.Demande;


import java.util.Comparator;

public class CompareNom implements Comparator<Demande> {
    public int compare(Demande o1, Demande o2) {
        return  (o1.getUtilisateur().getNom().compareTo(o2.getUtilisateur().getNom()));
    }
}
