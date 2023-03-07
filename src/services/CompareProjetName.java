package services;

import entity.Rendez_vous;

import java.util.Comparator;

public class CompareProjetName implements Comparator<Rendez_vous> {
    @Override
    public int compare(Rendez_vous o1, Rendez_vous o2) {
        return 1 ;//o1.getprojet().gettitre().compareTo(o2.getprojet().gettitre());
    }
}
