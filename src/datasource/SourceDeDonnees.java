package datasource;

import java.lang.Thread.State;
import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


public class SourceDeDonnees {
	
	private String url;
	private String login;
	private String mdp;
	private Connection cnx;
	
	
	
	public SourceDeDonnees(String url, String login, String mdp) {
		this.url = url;
		this.login = login;
		this.mdp = mdp;
	}
	
	
	public ResultSet doSearch(String requete) {
		ResultSet res = null;
		try {
			Statement stmt = cnx.createStatement();
			res = stmt.executeQuery(requete);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	public void doSarchOld(String requete) {
		try {
			Statement stmt = cnx.createStatement();
			ResultSet res = stmt.executeQuery(requete);
			if(res == null) {
				System.err.println("erreur execution");
			}else if(res.next() == false) {
				System.out.println("erreur requete"+requete);
			}else {
				do {
					int id = res.getInt("id");
					String nom = res.getString("nom");
					LocalDate ddj = res.getDate("ddj").toLocalDate();
					
					System.out.println("id:"+id);
					System.out.println("nom : "+nom);
					System.out.println("ddj"+ddj);
				}while(res.next() != false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public int doUpdate(String requete) {
		int nb = 0;
		try {
			Statement stmt = cnx.createStatement();
			nb = stmt.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO: handle exception
		nb=-2;	
		}
		return nb;
	}

	public PreparedStatement getPreparedStatement(String requete) {
		PreparedStatement ps = null;
		try {
			ps = this.cnx.prepareStatement(requete);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ps;
	}
	
	public void doConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			this.cnx = DriverManager.getConnection(this.url, this.login, this.mdp);
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	

	
	

	/*private Connection cnx; 
	
	private String url;
	private String password;
	private String login;	

	public SourceDeDonnees(String url,String login, String password) {
		this.url = url;
		this.login = login;
		this.password = password;
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
	
	
	
	
	public void doSearch_old(String requete) {
		// envoyer une requête vers la base, récupérer le résultat 
		// et l'afficher 
	
		try {
			Statement stmt = cnx.createStatement();
			// on execute la requete
			ResultSet resultat = stmt.executeQuery(requete);	
			
			if (resultat==null) {
				System.err.println("Problème dans l'execution de la requete");
			}
			else {
				if (resultat.next()==false) {
					System.out.println("Aucun résultat pour cette requete :  " + requete);
				}
				else {
					do 
					{
					// il y a du contenu en resultat dans le ResultSet
					Integer ident = resultat.getInt("Ident");
					String nom = resultat.getString("nom");
					String prenom = resultat.getString("prenom");
					
					Date ddn  = resultat.getDate("DDN");
					Date ddd  = resultat.getDate("DDD");
					
					System.out.println("L'identifiant de l'auteur est : " + ident);
					System.out.println("Le nom de l'auteur est : " + nom);
					System.out.println("Le prenom de l'auteur est : " + prenom);
					System.out.println("La date de naissance de l'auteur est : " + ddn);
					System.out.println("La dte de décès de l'auteur est : " + ddd);
					}
					while (resultat.next() != false);
					
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	
	
	
	 public PreparedStatement getPreparedStatement(String req) {
	        PreparedStatement ps = null;
	        try {
	             ps = this.cnx.prepareStatement(req);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return ps ;
	        
	    }
	 
	 public void doConnexion() {
			 try {
				Class.forName("org.maria.jdbc.driver").newInstance();
				this.cnx=DriverManager.getConnection(this.url,this.login,this.password);

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }*/
}