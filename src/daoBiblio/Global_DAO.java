package daoBiblio;

import java.sql.ResultSet;
import java.sql.SQLException;

import datasource.SourceDeDonnees;

public class Global_DAO {

	protected SourceDeDonnees sdd;

	public Global_DAO(SourceDeDonnees sdd) {
		this.sdd = sdd;
	}

	// on retourne un indicateur du nombre de tuples resultat et -1 si null
	protected Integer initResult(ResultSet rs, String message) {
		Integer nbt = -1;

		if (rs != null) {
			try {
				if (rs.next() == false) {
					System.out.println(message);
					nbt = 0;
				} else {
					nbt = 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Problème dans l'exécution de la requète");
		}
		return nbt;
	}

}
