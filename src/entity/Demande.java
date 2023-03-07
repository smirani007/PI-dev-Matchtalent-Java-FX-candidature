package entity;

public class Demande {
    private  int id_demande;
    private entity.User utilisateur;
    private Projet projet;
    private String reponse;
    

    public Demande(int id_demande, User utilisateur, Projet projet, String reponse) {
        this.id_demande = id_demande;
        this.utilisateur = utilisateur;
        this.projet = projet;
        this.reponse = reponse;
    }

    public int getid_demande() {
        return id_demande;
    }

    public void setid_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }


}
