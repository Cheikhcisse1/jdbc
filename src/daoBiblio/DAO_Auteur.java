package daoBiblio;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

import bibliotheque.Auteur;
import datasource.SourceDeDonnees;

public class DAO_Auteur extends Global_DAO{

	public DAO_Auteur(SourceDeDonnees sdd) {
		super(sdd);
	}

	

	private Auteur peuplementAuteur(ResultSet resultat) {
		Auteur auteur = null;
		try {
			Integer ident = resultat.getInt("Ident");
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom");
			LocalDate ddn = resultat.getDate("DDN").toLocalDate();
			LocalDate ddd = null;
			Date dateDeces = resultat.getDate("DDD");
			if (dateDeces != null) {
				ddd = resultat.getDate("DDD").toLocalDate();
			}
			auteur = new Auteur(nom, prenom, ddn, ddd);
		} catch (SQLException e) {
			e.printStackTrace();
		} // fin du catch
		return auteur;
	}

// fonction qui retourne un tableau d'auteurs suite à une requète 
// peut contenir plusieurs auteurs	
	private Auteur[] peuplementAuteurs(ResultSet resultat) {
		Auteur[] auteurs = new Auteur[0];

		try {
			do {
				auteurs = Arrays.copyOf(auteurs, auteurs.length + 1);
				auteurs[auteurs.length - 1] = this.peuplementAuteur(resultat);
			} while (resultat.next() != false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auteurs;
	}

	public Auteur getAuteurById(Integer id) {
		Auteur reponse = null;

		// requete correspondante
		String req = "Select * from Auteurs where ident='" + id + "'";
		ResultSet resultat = this.sdd.doSearch(req);

		if (this.initResult(resultat, "aucun auteur ne correspond a cette requete") > 0) {
			reponse = this.peuplementAuteur(resultat);
		}
		return reponse;
	} // fin de la méthodes

	public Auteur getAuteurByName(String name) {
		Auteur reponse = null;

		// requete correspondante
		String req = "Select * from Auteurs where nom='" + name + "'";
		ResultSet resultat = this.sdd.doSearch(req);

		if (this.initResult(resultat, "aucun auteur ne correspond a cette requete") > 0) {
			reponse = this.peuplementAuteur(resultat);
		}
		return reponse;
	}

	public Auteur[] getAuteursByName(String name) {

		Auteur[] auteurs = new Auteur[0];
		String requete = "select * from Auteurs where nom like '%" + name + "%'";

		ResultSet resultat = this.sdd.doSearch(requete);
		if (this.initResult(resultat, "aucun auteur ne correspond a cette requete") > 0) {
			auteurs = this.peuplementAuteurs(resultat);
		}

		return auteurs;

	}

} // fin de la classe
