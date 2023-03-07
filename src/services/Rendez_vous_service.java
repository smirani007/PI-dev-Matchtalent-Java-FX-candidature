package services;

import entity.Projet;
import entity.Rendez_vous;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

import java.sql.*;
import java.util.List;

public class Rendez_vous_service implements IService<Rendez_vous> {
    Connection cnx;
    public Rendez_vous_service() {
        cnx = MyDB.getInstance().getCnx();
    }


    @Override
    public void ajouter(Rendez_vous rendez_vous) throws SQLException {
       try {

           java.sql.Date sqlDate = new java.sql.Date(rendez_vous.getDate_rendez_vous().getTime());

        PreparedStatement s = cnx.prepareStatement("INSERT INTO rendez_vous(id_user,date_rendez_vous,Heure_rendez_vous,id_projet) VALUES(?,?,?,?)");
        s.setInt(1, rendez_vous.getUser().getId_user());
        s.setDate(2,  sqlDate);
        s.setString(3, rendez_vous.getHeure_rendez_vous());
        s.setInt(4, rendez_vous.getProjet().getId_projet());
        s.executeUpdate();
        System.out.println("succesful ");
    }catch (Exception e){
           System.out.println(e);
       }
    }

    @Override
    public void modifier(Rendez_vous rendez_vous) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(rendez_vous.getDate_rendez_vous().getTime());

        PreparedStatement s = cnx.prepareStatement("update  rendez_vous set date_rendez_vous=?,Heure_rendez_vous=? where  id_rendez_vous=?  ");
        s.setDate(1, sqlDate);
        s.setString(2,rendez_vous.getHeure_rendez_vous());
        s.setInt(3, rendez_vous.getId_rendez_vous());
        s.executeUpdate();
        System.out.println("succesful ");

    }

    @Override
    public void supprimer(Rendez_vous rendez_vous) throws SQLException {
        try {
        PreparedStatement s = cnx.prepareStatement("delete from rendez_vous where  id_rendez_vous=?");
        s.setInt(1, rendez_vous.getId_rendez_vous());
        s.executeUpdate();
        System.out.println("succesful ");
    }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
        public List<Rendez_vous> recuperer() throws SQLException {
        PreparedStatement s = cnx.prepareStatement("select * from rendez_vous,user,projet where rendez_vous.id_user=user.id_user and projet.id_projet=rendez_vous.id_projet  ");
        ObservableList<Rendez_vous> rendez_vousListe= FXCollections.observableArrayList();
        ResultSet resultat = s.executeQuery();

        while (resultat.next()) {
            System.out.println("d5alt mara");
          rendez_vousListe.add(new Rendez_vous(resultat.getInt("id_rendez_vous"), new User(resultat.getInt("id_user"),resultat.getString("nom")),resultat.getDate("date_rendez_vous"),resultat.getString("Heure_rendez_vous"),new Projet(resultat.getInt("id_projet"),resultat.getString("titre"),resultat.getString("categorie"),resultat.getString("description"))));
        }
        return rendez_vousListe;
    }
    public List<Rendez_vous> getSpecified(Rendez_vous rdv) throws SQLException {
        PreparedStatement s = cnx.prepareStatement("select * from rendez_vous where date_rendez_vous=? and Heure_rendez_vous=? and  id_projet=? ");

        java.sql.Date sqlDate = new java.sql.Date(rdv.getDate_rendez_vous().getTime());

        s.setDate(1, sqlDate);
        s.setString(2,rdv.getHeure_rendez_vous());
        s.setInt(3, rdv.getProjet().getId_projet());




        ResultSet resultat = s.executeQuery();
        ObservableList<Rendez_vous> rendez_vousListe= FXCollections.observableArrayList();

        while (resultat.next()) {
           rendez_vousListe.add(new Rendez_vous(resultat.getInt("id_rendez_vous"),new User(resultat.getInt("id_user")),resultat.getDate("date_rendez_vous"),resultat.getString("Heure_rendez_vous"),new Projet(resultat.getInt("id_projet"))));
        }
        return rendez_vousListe;
    }
}
