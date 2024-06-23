package application;

import java.time.LocalDate;

import bibliotheque.Abonne;
import bibliotheque.Auteur;
import daoBiblio.DAO_Abonne;
import daoBiblio.DAO_Auteur;
import datasource.SourceDeDonnees;
import facade.Facade_Biblio;

public class Application {

	Facade_Biblio guichet;

	public Application() {
		guichet = new Facade_Biblio();
	}

	public void afficherAuteur(String nom) {
		Auteur[] auteurs = this.guichet.chercherAuteur(nom);

		if (auteurs != null) {
			for (Auteur auteur : auteurs) {
				auteur.afficher();
			}
		} else {
			System.out.println("Nous n'avons pas d'auteurs à ce nom");
		}
	}

	public void afficherAbonnes(String nom) {
		Abonne[] qui = this.guichet.chercherAbonne(nom);
		if (qui != null)
			for (Abonne abonne : qui) {
				abonne.afficher();
			}
		else {
			System.out.println("pas d'abonnés avec cette partie du nom");
		}

	}

	public void afficherAbonnesBanni() {
		Abonne[] qui = this.guichet.chercherBannis();
		if (qui != null)
			for (Abonne abonne : qui) {
				abonne.afficher();
			}
		else {
			System.out.println("pas d'abonnés Banni ");
		}
	}

	public void afficherAbonnesAmnistiable() {
		Abonne[] qui = this.guichet.amnistiable();
		if (qui != null)
			for (Abonne abonne : qui) {
				abonne.afficher();
			}
		else {
			System.out.println("Pas d'abonnés Amnistiable ");
		}

	}

	public void inscrire(Abonne abonne) {
		this.guichet.ajouterAbonne(abonne);
	}

	public static void main(String[] args) {

		Application monAppli = new Application();

		// monAppli.afficherAuteur("bobby"); //monAppli.afficherAbonnes("hat");
		// monAppli.afficherAbonnesBanni(); // monAppli.afficherAbonnesAmnistiable();
		Abonne abonne = new Abonne("Dorian", "Pascal", "D38", "pascal13", "dodo13", "13 rue des platane",
				"dodo@gmail.com", LocalDate.now(), null);
		monAppli.inscrire(abonne);
	}

}
