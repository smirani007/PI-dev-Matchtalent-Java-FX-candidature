package entity;


import java.util.Date;

public class Rendez_vous {
   private int id_rendez_vous;
    private User user ;
    private Date date_rendez_vous;
    private String Heure_rendez_vous;
    private entity.Projet Projet;

    public Rendez_vous(int id_rendez_vous, User user, Date date_rendez_vous, String heure_rendez_vous, entity.Projet Projet) {
        this.id_rendez_vous=id_rendez_vous;
        this.user = user;
        this.date_rendez_vous = date_rendez_vous;
        Heure_rendez_vous = heure_rendez_vous;
        this.Projet = Projet;
    } public Rendez_vous(User user, Date date_rendez_vous, String heure_rendez_vous, entity.Projet Projet) {
        this.user = user;
        this.date_rendez_vous = date_rendez_vous;
        Heure_rendez_vous = heure_rendez_vous;
        this.Projet = Projet;
    }
    public Rendez_vous(int id_rendez_vous) {
        this.id_rendez_vous=id_rendez_vous;


    }

    public Rendez_vous(int id_rendez_vous, Date date_rendez_vous, String heure_rendez_vous) {
        this.id_rendez_vous=id_rendez_vous;
        this.date_rendez_vous = date_rendez_vous;
        Heure_rendez_vous = heure_rendez_vous;

    }

    public Rendez_vous(Date date_rendez_vous, String heure_rendez_vous, entity.Projet Projet) {
        this.date_rendez_vous = date_rendez_vous;
        Heure_rendez_vous = heure_rendez_vous;
        this.Projet = Projet;
    }

    public int getId_rendez_vous() {
        return id_rendez_vous;
    }

    public void setId_rendez_vous(int id_rendez_vous) {
        this.id_rendez_vous = id_rendez_vous;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate_rendez_vous() {
        return date_rendez_vous;
    }

    public void setDate_rendez_vous(Date date_rendez_vous) {
        this.date_rendez_vous = date_rendez_vous;
    }

    public String getHeure_rendez_vous() {
        return Heure_rendez_vous;
    }

    public void setHeure_rendez_vous(String heure_rendez_vous) {
        Heure_rendez_vous = heure_rendez_vous;
    }

    public entity.Projet getProjet() {
        return Projet;
    }

    public void setProjet(entity.Projet Projet) {
        this.Projet = Projet;
    }
}
