package daoBiblio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import bibliotheque.Auteur;
import bibliotheque.Livre;
import datasource.SourceDeDonnees;

public class DAO_Livre extends Global_DAO{
	
	private DAO_Auteur dao_auteur;

	public DAO_Livre(SourceDeDonnees sdd) {
		super(sdd);
	}
	
	
	private Livre peuplementLivre(ResultSet resultat) {
        Livre monLivre = null;
        try {
            String titre = resultat.getString("titre");
            LocalDate parution = resultat.getDate("Date_Parution").toLocalDate();
            Integer id = resultat.getInt("ident");
            Auteur auteur = dao_auteur.getAuteurById(id);
            String ISBN = resultat.getString("ISBN");
            monLivre = new Livre(titre, parution, auteur, ISBN);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // fin catch
        return monLivre;
    }
	
	private Livre[] peuplementLivres(ResultSet resultat) {
		Livre[] livre = new Livre[0];
		try {
			do {
				livre = Arrays.copyOf(livre, livre.length + 1);
				livre[livre.length - 1] = this.peuplementLivre(resultat);
			} while (resultat.next() != false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livre;
	}
	
	
	public Livre getLivreById(String ident) {
		Livre res=null;
		String req = "Select * from Livre where ident='" + ident + "'";
		ResultSet resultat = this.sdd.doSearch(req);

		if (this.initResult(resultat, "aucun livre ne correspond a cette requete") > 0) {
			res=this.peuplementLivre(resultat); 

		}
		return res;
	}
	
	
	public Livre[] getLivreByTitle(String titre) {

		Livre[] livres = new Livre[0];
		String requete = "select * from Auteurs where title like '%" + titre + "%'";
		ResultSet resultat = this.sdd.doSearch(requete);
		if (this.initResult(resultat, "aucun auteur ne correspond a cette requete") > 0) {
			livres = this.peuplementLivres(resultat);
		}
		
		return livres;
	}	
	
	public Livre getQuickLivreByTitre(String MotDuTitre)
    {
        Livre reponse = null;
        String req="Select * from Livres where titre like?";
        
        try {
            PreparedStatement ps= this.sdd.getPreparedStatement(req);
            ps.setString(1,"%" + MotDuTitre +"%");
            ResultSet resultat=ps.executeQuery();
            if(initResult(resultat, "aucun resultat ne correspond a votre requete")>0)
            {
                reponse=this.peuplementLivre(resultat);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reponse;
    }
}
