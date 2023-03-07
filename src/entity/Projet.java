package entity;

public class Projet {
    private int id_projet;
    private String titre;
    private String description;
    private float budget;
    private String categorie;
    private String competences_requises ;



    public Projet() {
    }
    public Projet(int id_projet)      {
        this.id_projet = id_projet;
    }

    public Projet(int id_projet,String titre,String categorie,String description) {
        this.id_projet = id_projet;
        this.titre = titre;
        this.description = description;
        this.budget = budget;
        this.categorie = categorie;
    }public Projet(int id_projet,String titre,String description,float budget,String categorie ) {
        this.id_projet = id_projet;
        this.titre = titre;
        this.description = description;
        this.budget = budget;
        this.categorie = categorie;
    }
    public Projet(String titre,String description,float budget,String categorie,String competences_requises ) {

        this.titre = titre;
        this.description = description;
        this.budget = budget;
        this.categorie = categorie;
        this.competences_requises=competences_requises;




    }

    public int getId_projet() {
        return id_projet;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCompetences_requises() {
        return competences_requises;
    }

    public void setCompetences_requises(String competences_requises) {
        this.competences_requises = competences_requises;
    }




    @Override
    public String toString() {
        return "Projet{  " + "id_projet=" + id_projet + " , titre=" + titre +" , description"+description  +" , budget=" + budget + " , categorie=" + categorie + ", competences_requises=" + competences_requises + '}';
    }





}
