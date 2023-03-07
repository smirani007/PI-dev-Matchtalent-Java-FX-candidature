package services;

import entity.Demande;
import entity.Projet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DemandeService implements IService<Demande> {
    Connection cnx;
    public DemandeService() {
        cnx = MyDB.getInstance().getCnx();
    }




    @Override
    public void ajouter(Demande o) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("INSERT INTO Demande(id_projet,id_user,reponse) VALUES(?,?,?)");
            s.setInt(1, o.getProjet().getId_projet());
            s.setInt(2, o.getUtilisateur().getId_user());
            s.setString(3, o.getReponse());
             s.executeUpdate();
            System.out.println("succesful ");

        }

    @Override
    public void modifier(Demande o) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("update  Demande set reponse=? where  id_projet=? and id_user=? ");
            s.setString(1, o.getReponse());
            s.setInt(2, o.getProjet().getId_projet());
            s.setInt(3, o.getUtilisateur().getId_user());
             s.executeUpdate();
            System.out.println("succesful ");

    }

    @Override
    public void supprimer( Demande p) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("delete from Demande where  id_Demande=?");
            s.setInt(1, p.getid_demande());
            s.executeUpdate();
            System.out.println("succesful ");
    }

    @Override
    public List recuperer() throws SQLException {
        /*PreparedStatement s = cnx.prepareStatement("select * from demande,user, projet  where demande.id_user=user.id_user  ");
        ObservableList<Demande> DemandeListe= FXCollections.observableArrayList();
        ResultSet resultat = s.executeQuery();

        while (resultat.next()) {
            //         public Postulaion(entities.annonce annonce, entities.utilisateur utilisateur, String etat, String cv, String lettre_motivation) {
            resultat.getInt("id_projet");
            System.out.println(resultat.getInt("id_user"));
            DemandeListe.add(new Demande( resultat.getInt("id_Demande"), new entity.User(resultat.getInt("id_user"),resultat.getString("nom"),resultat.getString("prénom"),resultat.getString("mail"),resultat.getInt("numéroTéléphone"),resultat.getInt("grad"),resultat.getString("addresse")),new Projet(resultat.getInt( "id_projet")),resultat.getInt("nom"),resultat.getString("budget")));
        }
        return DemandeListe;
    */
    return null ;}

    public List recupererSuivantProjet(Projet project) throws SQLException {
        System.out.println("salem"+project.getId_projet());
        PreparedStatement s = cnx.prepareStatement("select * from Demande,user,projet where Demande.id_projet =projet.id_projet  and Demande.id_user=user.id_user  and Demande.id_projet=? and Demande.id_user not in(select id_user from rendez_vous where id_projet=?)");
        s.setInt(1,1);
        s.setInt(2, 1);

        ObservableList<Demande> DemandeListe= FXCollections.observableArrayList();

        ResultSet resultat = s.executeQuery();

        while (resultat.next()) {
            DemandeListe.add(new Demande( resultat.getInt("id_Demande"), new entity.User(resultat.getInt("id_user"),resultat.getString("nom"),resultat.getString("prénom"),resultat.getString("mail"),resultat.getInt("numéroTéléphone"),resultat.getString("adresse"),resultat.getInt("grad"),resultat.getString("role")),new Projet(resultat.getInt( "id_projet"),resultat.getString("titre"),resultat.getString("description"),resultat.getFloat("budget"),resultat.getString("categorie")),resultat.getString("reponse")));
        }
        return DemandeListe;
    }
}
