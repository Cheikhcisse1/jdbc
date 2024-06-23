package bibliotheque;

import java.time.LocalDate;

public class Auteur {	

	private String nom;
	private String prenom;
	private LocalDate ddn;
	private LocalDate ddd;
	
	public Auteur(String nom, String prenom, LocalDate ddn, LocalDate ddd) {
		this.nom = nom;
		this.prenom = prenom;
		this.ddn = ddn;
		this.ddd = ddd;
	}

	public Auteur() {
	}

	public void afficherDebug() {		
		System.out.println(this.toString());
	}
		
	public void afficher() {
		System.out.println("Le nom de l'auteur est : " + this.nom);
		System.out.println("Le prenom de l'auteur est : " + this.prenom);
		System.out.println("La date de naissance de l'auteur est : " + this.ddn);
		System.out.println("La dte de décès de l'auteur est : " + this.ddd);
	}
	
	@Override
	public String toString() {
		return "Auteur [nom=" + this.nom + ", prenom=" + this.prenom + ", ddn=" + ddn + ", ddd=" + ddd + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDdn() {
		return ddn;
	}

	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}

	public LocalDate getDdd() {
		return ddd;
	}

	public void setDdd(LocalDate ddd) {
		this.ddd = ddd;
	}
	
	
	

	
	
	
	

	
	
	
	
	
}
