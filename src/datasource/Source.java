package datasource;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Source {
	
	private String url;
	private String login;
	private String mdp;
	private Connection cnx;
	
	
	public Source(String url, String login, String mdp) {
		this.url = url;
		this.login = login;
		this.mdp = mdp;
	}
	
	
	public ResultSet doSearch(String requete) {
		// envoyer une requête vers la base, récupérer le résultat et le renvoyer

		ResultSet resultat=null; 
		try {
			Statement stmt = cnx.createStatement();
			resultat = stmt.executeQuery(requete);				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;				
	}
	
	public int doUpdate(String requete) {
		
		int nbT=0; // nombre de tuples effectivement modifiés par la requete 
		try {
			Statement stmt = cnx.createStatement();
			nbT=stmt.executeUpdate(requete);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			nbT = -2;
		}
		return nbT;	
	}
	

	public void doSearchOld(String requete) {
		try {
			Statement stmt = cnx.createStatement();
			ResultSet res = stmt.executeQuery(requete);
			if(res == null) {
				System.err.println("erreur executionn");
			}else {
				if(res.next() == false) {
					System.out.println("aucun resultat");
				}else {
					do {
						int id = res.getInt("id");
						System.out.println("id = "+requete);
					}while(res.next()!=false);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void doConnection() {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			this.cnx=DriverManager.getConnection(this.login,this.mdp,this.url);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (InstantiationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		
		public PreparedStatement getPreparedStatement(String requete) {
			PreparedStatement ps =null;
			try {
				ps=this.cnx.prepareStatement(requete);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return ps;
		}
	

	

}
