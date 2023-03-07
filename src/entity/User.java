/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ounis
 */
public class User {
    int id_user ;
    String nom ;
    String prénom;
    String mail;
    String password;
    int numéroTéléphone ;
    String role ;
    int grad ;
    String adresse ;
    String image ;

    public User() {

    }
    public User(int id_user) {
        this.id_user=id_user;
    } public User(int id_user,String nom) {
        this.nom=nom;
    }

   public User(String nom, String prénom, String mail, String password, int numéroTéléphone, String role, int grad, String adresse, String image) {
        this.nom = nom;
        this.prénom = prénom;
        this.mail = mail;
        this.password = password;
        this.numéroTéléphone = numéroTéléphone;
        this.role = role;
        this.grad = grad;
        this.adresse = adresse;
        this.image = image;
    }
    public User(int id_user, String nom, String prénom, String mail, int numéroTéléphone,String adresse, int grad,String role ) {
        this.id_user = id_user;
        this.nom = nom;
        this.prénom = prénom;
        this.mail = mail;
        //this.password = password;
        this.numéroTéléphone = numéroTéléphone;
        this.role = role;
        this.grad = grad;
        this.adresse = adresse;
        this.image = image;
    }

    public User(int id_user, String nom, String prénom, String mail, int numéroTéléphone, int grad, String addresse) {
        this.id_user = id_user;
        this.nom = nom;
        this.prénom = prénom;
        this.mail = mail;
       this.numéroTéléphone= numéroTéléphone;
        this.grad = grad;
        this.adresse = addresse;
        this.image = image;
    }



    public int getId_user() {
        return id_user;
    }

    public String getNom() {
        return nom;
    }

    public String getprénom() {
        return prénom;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public int getNuméroTéléphone() {
        return numéroTéléphone;
    }

    public String getRole() {
        return role;
    }

    public int getGrad() {
        return grad;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getImage() {
        return image;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setprénom(String prénom) {
        this.prénom = prénom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNuméroTéléphone(int numéroTéléphone) {
        this.numéroTéléphone = numéroTéléphone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id_user + ", nom=" + nom + ", prenom=" + prénom + ", mail=" + mail + ", password=" + password + ", numéroTéléphone=" + numéroTéléphone + ", role=" + role + ", grad=" + grad + ", adresse=" + adresse + ", image=" + image + '}';
    }


}
