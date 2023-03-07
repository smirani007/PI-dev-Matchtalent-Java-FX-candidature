package services;

import entity.Demande;


import java.util.Comparator;

public class CompareNote implements Comparator<Demande> {
    @Override
    public int compare(Demande o1, Demande o2) {
        return (int) (o1.getUtilisateur().getNuméroTéléphone()-o2.getUtilisateur().getNuméroTéléphone());
    }
}
