package JavaProject78;
import JavaProject78.webscrapping;
import java.io.*;
import JavaProject78.Emploi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
public class db {
	 public static Statement connectToDB() throws ClassNotFoundException, SQLException {

	        Connection connect = null;
	        Statement statement = null;
	        String url = "jdbc:mysql://localhost:3306/projet";
	        String user = "root";
	        String password = "";

	        try {
	            // Definer notre driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // Initializer la connection
	            connect = DriverManager.getConnection(url, user, password);
	            // statements
	            statement = connect.createStatement();
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return statement;
	    }
	 public static void addJob(Emploi job) throws SQLException, ClassNotFoundException {

	        try {
	            Statement st = connectToDB();
	            Connection connect = null;
		        Statement statement = null;
		        String url = "jdbc:mysql://localhost:3307/projet";
		        String user = "root";
		        String password = "";
		     // Definer notre driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // Initializer la connection
	            connect = DriverManager.getConnection(url, user, password);
	            // statements
	            statement = connect.createStatement();
	          //  String sql = "select * from projet where titre='" + job.titre + "'and site ='" + job.sitename ;
	            //ResultSet rs = st.executeQuery(sql);

	            //if (rs.first()) {
	                // verifier si l'offre existe deja dans la base de donnes;
	              //  System.out.println(" cette Offre existe avec le meme title et company");
	            //} else {

	                //String requette = "INSERT INTO `projeet`(`titre`, `url`,`site_name`,`date_publication`,`date_post`,`adresse`,`description_entreprise`,`description_poste`,`profile`,`seccteur`,`metier`,`niveau_etude`,`experience`,`trait_personnalite`,`contrat`,`mode_travail`,`competences`) 
	            //VALUES ('" + job.titre+ "','" + job.url + "','" + job.sitename + "','" + job.erf1 + "','" + job.datepost1 + "','" + job.adresse1 + "','" + job.entreprise1 + "','" + job.post1 + "','"+ job.profiler1 + "','" + job.secteur1 +"','"+ job.profiler1 + "','" + job.secteur1 +"','" + job.metier1+"','" + job.niveau1+"','" + job.exp1+"','" + job.trait1+"','" + job.contrat1+"','" + job.mode1+"','" + job.tech1+"')";
	                //st.executeUpdate(requette);
	            //st.executeUpdate("INSERT INTO `projeet`(`titre`, `url`,`site_name`,`date_publication`,`date_post`,`adresse`,`descption_entreprise`,`profile`,`secteur`,`metier`,`niveau_etude`,`experience`,`trait_personnalite`,`contrat`,`mode_travail`,`competences`)VALUES ('" + job.titre+ "','" + job.getUrl() + "','" + job.getSitename() + "','" + job.getErf1()+ "','" + job.getPost1() + "','" + job.getAdresse1() + "','" + job.getEntreprise1() + "','"+ job.getProfiler1() + "','" + job.getSecteur1() +"','"+ job.getProfiler1() + "','" + job.getSecteur1() +"','" + job.getMetier1()+"','" + job.getNiveau1()+"','" + job.getExp1()+"','" + job.getTrait1()+"','" + job.getContrat1()+"','" + job.getMode1()+"','" + job.getTech1()+"')");
	            
	            //st.executeUpdate("INSERT INTO `projeet`(`titre`, `url`,`site_name`,`date_publication`,`date_post`,`adresse`,`description_entreprise`,`description_poste`,`profile`,`seccteur`,`metier`,`niveau_etude`,`experience`,`trait_personnalite`,`contrat`,`mode_travail`,`competences`)VALUES ('" + job.getTitre()+ "','" + job.getUrl() + "','" + job.getSitename() + "','" + job.getErf1()+ "','" + job.getDatepost1() + "','" + job.getAdresse1() + "','" + job.getEntreprise1() + "','" + job.getPost1() + "','"+ job.getProfiler1() + "','" + job.getSecteur1() +"','"+ job.profiler1 + "','" + job.getMetier1() +"','" + job.getNiveau1()+"','" + job.getExp1()+"','" + job.getTrait1()+"','" + job.getContrat1()+"','" + job.getMode1()+"','" + job.getTech1()+"')");   
	            PreparedStatement ps=connect.prepareStatement("INSERT INTO `projeet`(`titre`, `url`,`site_name`,`date_publication`,`date_post`,`adresse`,`description_entreprise`,`description_poste`,`profil`,`secteur`,`metier`,`niveau_etude`,`experience`,`trait_personnalite`,`contrat`,`mode_travail`,`competences`)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            ps.setString(1,job.titre);
	            ps.setString(2,job.url); 
	            ps.setString(3,job.sitename); 
	            ps.setString(4,job.erf1); 
	            ps.setString(5,job.datepost1); 
	            ps.setString(6,job.adresse1); 
	            ps.setString(7,job.entreprise1); 
	            ps.setString(8,job.post1);
	            ps.setString(9,job.profiler1); 
	            ps.setString(10,job.secteur1); 
	            ps.setString(11,job.metier1); 
	            ps.setString(12,job.niveau1); 
	            ps.setString(13,job.exp1); 
	            ps.setString(14,job.trait1); 
	            ps.setString(15,job.contrat1); 
	            ps.setString(16,job.mode1); 
	            ps.setString(17,job.tech1); 
	            int i=ps.executeUpdate();  
	            System.out.println(i+" records inserted");  
	              
	            connect.close();
	            System.out.println("added");
	                
	           // }
	            
	            
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}
