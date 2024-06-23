package daoBiblio;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;

import bibliotheque.*;
import datasource.SourceDeDonnees;

public class DAO_Abonne extends Global_DAO {

	// constructeur
	public DAO_Abonne(SourceDeDonnees sdd) {
		super(sdd);
	}

	// on retourne un indicateur du nombre de tuples resultat et -1 si null

	private Abonne peuplementAbonne(ResultSet resultat) {
		Abonne monAbonnee = null;
		try {
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom");
			String code = resultat.getString("code");
			String login = resultat.getString("login");
			String password = resultat.getString("password");
			String adresse = resultat.getString("adresse");
			String email = resultat.getString("email");
			LocalDate ddi = resultat.getDate("Date_Inscription").toLocalDate();
			LocalDate ddp = null;
			Date penalite = resultat.getDate("Date_penalite");
			if (penalite != null) {
				ddp = penalite.toLocalDate();
			}
			monAbonnee = new Abonne(nom, prenom, code, login, password, adresse, email, ddi, ddp);
		} catch (SQLException e) {
			e.printStackTrace();
		} // fin du catch
		return monAbonnee;
	}

	private Abonne[] peuplementAbonnes(ResultSet rs) {
		Abonne[] resultat = new Abonne[0];
		// parcourir l'ensemble du resultSet l'ensemble des tuples
		// l'ensemble des abonnés qu'il a trouvé et pourt chacun d'eux
		// je crée un objet abonné et je l'ajoute dans le tableau
		// en ayant au préalable ajouté une case

		// pour tous les tuples résultats que j'ai dans mon resultSet
		try {
			do {
				// si je suis là c'est que il y a un nouvel abonné à extraire
				// donc je dois créer une nouvelle case dans le tableau
				resultat = Arrays.copyOf(resultat, resultat.length + 1);
				Abonne abo = this.peuplementAbonne(rs);
				resultat[resultat.length - 1] = abo;
			} while (rs.next() != false);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public Abonne getAbonneByCode(String code) {
		Abonne reponse = null;

		// requete correspondante
		String req = "Select * from abonnes where code='" + code + "'";
		ResultSet resultat = this.sdd.doSearch(req);

		if (this.initResult(resultat, "aucun abonne ne correspond a cette requete") > 0) {
			reponse = this.peuplementAbonne(resultat);
		}
		return reponse;
	}

	public Abonne[] getAbonneBanni() {

		Abonne[] reponse = null;
		LocalDate ddj = LocalDate.now();

		// requete correspondante
		String req = "Select * from abonnes where Date_Penalite > '" + ddj + "'";
		System.out.println(req);
		ResultSet resultat = this.sdd.doSearch(req);

		if (this.initResult(resultat, "aucun abonne ne correspond a cette requete") > 0) {
			reponse = this.peuplementAbonnes(resultat);
		}
		return reponse;
	}

	public Abonne[] getAbonneByName(String name) {
		Abonne[] reponse = null;

		// requete correspondante
		String req = "Select * from abonnes where nom Like '%" + name + "%'";
		ResultSet resultat = this.sdd.doSearch(req);

		if (this.initResult(resultat, "aucun abonne ne correspond a cette requete") > 0) {
			reponse = this.peuplementAbonnes(resultat);
		}
		return reponse;
	}

	public int creerAbonne(Abonne abonne) {
		String sql = "INSERT INTO `abonnes`(`Nom`, `Prenom`, `Code`, `login`, `password`, `Adresse`, `email`, `Date_Inscription`, `Date_Penalite`) VALUES "
				+ "('" + abonne.getNom() + "'," + "'" + abonne.getPrenom() + "'," + "'" + abonne.getCode() + "'," + "'"
				+ abonne.getLogin() + "'," + "'" + abonne.getPassword() + "'," + "'" + abonne.getAdresse() + "'," + "'"
				+ abonne.getEmail() + "'," + "'" + abonne.getInscription() + "'," + "" + abonne.getPenalite() + ")";

		int codeRetour = this.sdd.doUpdate(sql);
		switch (codeRetour) {
		case 0:
			System.err.println("pas d'insertion faite");
			break;
		case -2:
			System.err.println("Code déja utilisé");
			break;
		}
		System.out.println(sql);
		return codeRetour;
	}

}
