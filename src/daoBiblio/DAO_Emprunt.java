package daoBiblio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import bibliotheque.*;
import datasource.SourceDeDonnees;

public class DAO_Emprunt extends Global_DAO {

    // constructeur
    public DAO_Emprunt(SourceDeDonnees sdd) {
        super(sdd);
    }
    
    public Emprunt getEmpruntById(int id) {
        Emprunt res = null;

        // requete correspondante
        String req = "Select * from emprunts where Id_Emprunt='" + id + "'";
        ResultSet resultat = this.sdd.doSearch(req);

        if (this.initResult(resultat, "aucun emprunt ne correspond a cette requete") > 0) {
            res = this.peuplementEmprunt(resultat);
        }

        return res;
    }//getById
    
    
    private Emprunt peuplementEmprunt(ResultSet resultat) {
        Emprunt emprunt = null;
        try {
            String id_abonne = resultat.getString("id_abonne");
            String id_Exemplaire = resultat.getString("id_Exemplaire");
            LocalDate dds = resultat.getDate("Date_sortie").toLocalDate();
            LocalDate ddRetour = resultat.getDate("Date_retour").toLocalDate();
            LocalDate ddRendu=null;
            if (ddRendu != null) {
                ddRendu = resultat.getDate("Date_rendu").toLocalDate();
            }
            emprunt = new Emprunt(id_abonne, id_Exemplaire, dds, ddRetour, ddRendu);
        } catch (SQLException e) {
            e.printStackTrace();
        } // fin du catch
        return emprunt;
    }
    

	private Emprunt[] peuplementEmprunt1(ResultSet resultats) {
		
		Emprunt[] emprunt = new Emprunt[0];
		String requete = "select * from Auteurs where nom like '%" + resultats + "%'";

		ResultSet resultat = this.sdd.doSearch(requete);
		if (this.initResult(resultat, "aucun auteur ne correspond a cette requete") > 0) {
			emprunt = this.peuplementEmprunt1(resultat);
		}

		return emprunt;

	}
}