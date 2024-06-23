package facade;

import java.time.LocalDate;
import java.util.Arrays;

import bibliotheque.*; // import de tout ce qui est dans le package
import daoBiblio.*;
import datasource.SourceDeDonnees;

public class Facade_Biblio {

	private String url; // url de connexion
	private String login; // de connexion
	private String password; // de connexion
	
	private SourceDeDonnees sdd;
	
	Global_DAO gdao;
	DAO_Auteur monDAO_Auteur;
	DAO_Abonne monDao_Abonne;
	
	public Facade_Biblio() {
		this.url = "jdbc:mariadb://localhost:3306/Bibliotheque";
		this.login = "root";
		this.password= "";
		
		// creation de la source de données
		this.sdd = new SourceDeDonnees(url,login, password);
		this.sdd.doConnection();		
		
		this.gdao = new Global_DAO(sdd);
		this.monDAO_Auteur = new DAO_Auteur(sdd);
		this.monDao_Abonne = new DAO_Abonne(sdd);
	}
	
	public Auteur[] chercherAuteur(String nom) {
		return monDAO_Auteur.getAuteursByName(nom);
	}

	public Abonne[] chercherAbonne(String nom) {
		return monDao_Abonne.getAbonneByName(nom);
	}
	
	public Abonne[] chercherBannis(){
		return monDao_Abonne.getAbonneBanni();
	}
	
	public Abonne[] amnistiable() {
		Abonne [] amnistiable = new Abonne[0];
		Abonne [] candidats = this.chercherBannis();
		LocalDate ddj = LocalDate.now();
		for (Abonne abonne : candidats) {
			if ( ddj.plusDays(4).isAfter(abonne.getPenalite())) {
				amnistiable = Arrays.copyOf(amnistiable, amnistiable.length+1);
				amnistiable[amnistiable.length-1]=abonne;
			     }
		}
		
		return amnistiable;
	}
	
	public int ajouterAbonne(Abonne abonne) {
		return this.monDao_Abonne.creerAbonne(abonne);
	}
}
