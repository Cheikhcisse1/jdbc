package bibliotheque;

import java.time.LocalDate;

public class Livre {

	private String titre ;
	private LocalDate parution;
	private Auteur auteur;
	private String ISBN;
	
	public Livre(String titre, LocalDate parution, Auteur auteur, String iSBN) {
		super();
		this.titre = titre;
		this.parution = parution;
		this.auteur = auteur;
		ISBN = iSBN;
	}

	
	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", parution=" + parution + ", auteur=" + auteur + ", ISBN=" + ISBN + "]";
	}
	
	public void afficheDebug() {
		System.out.println(this.toString());
	}
	
	public void afficher() {
		
		System.out.println("Le titre du livre est : "+ this.titre);
		System.out.println("L'année de parution est : "+ this.parution);
		this.auteur.afficher();
		System.out.println("L'ISBN du livre est : "+ this.ISBN);
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public LocalDate getParution() {
		return parution;
	}

	public void setParution(LocalDate parution) {
		this.parution = parution;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	
	
	
	
	
	
	
	
	
}
