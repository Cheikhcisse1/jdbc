package bibliotheque;

import java.time.LocalDate;


public class Emprunt {
    private String id_abonne;
    private String id_Exemplaire;
    
    private LocalDate dds;
    private LocalDate ddRetour;
    private LocalDate ddRendu;
    
    
    public Emprunt(String id_abonne, String id_Exemplaire, LocalDate dds, LocalDate ddRetour,LocalDate ddRendu) {
        this.id_abonne = id_abonne;
        this.id_Exemplaire = id_Exemplaire;
        this.dds = dds;
        this.ddRetour = ddRetour;
        this.ddRendu = ddRendu;
    }
    
    public Emprunt() {
        
    }
    
    public void afficherDebug() {       
        System.out.println(this.toString());
    }
        
    public void afficher() {
        System.out.println("L'id de l'abonne : " + this.id_abonne);
        System.out.println("L'id de l'exemplaire : " + this.id_Exemplaire);
        System.out.println("Date de sortie : " + this.dds);
        System.out.println("Date de retour: "+this.ddRetour);
        System.out.println("date de rendu: "+this.ddRendu);
    }

    @Override
    public String toString() {
        return "Emprunt [id_abonne=" + id_abonne + ", id_Exemplaire=" + id_Exemplaire
                + ", dds=" + dds + ", ddRetour=" + ddRetour + ", ddRendu=" + ddRendu + "]";
    }

    

    public String getId_abonne() {
        return id_abonne;
    }

    public void setId_abonne(String id_abonne) {
        this.id_abonne = id_abonne;
    }

    public String getId_Exemplaire() {
        return id_Exemplaire;
    }

    public void setId_Exemplaire(String id_Exemplaire) {
        this.id_Exemplaire = id_Exemplaire;
    }

    public LocalDate getDds() {
        return dds;
    }

    public void setDds(LocalDate dds) {
        this.dds = dds;
    }

    public LocalDate getDdRetour() {
        return ddRetour;
    }

    public void setDdRetour(LocalDate ddRetour) {
        this.ddRetour = ddRetour;
    }

    public LocalDate getDdRendu() {
        return ddRendu;
    }

    public void setDdRendu(LocalDate ddRendu) {
        this.ddRendu = ddRendu;
    }
    
}