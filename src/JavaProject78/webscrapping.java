package JavaProject78;
import JavaProject78.Emploi;


import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Node;
import JavaProject78.db;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class webscrapping {
	
		
		public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
			try {
					int nbrpage= 55;
					for(int i=1;i<=nbrpage;i++) {
						Document doc= Jsoup.connect("https://www.rekrute.com/offres.html?s=1&p="+i+"&o=1&positionId%5B0%5D=13").get( );
					    Element element = doc.getElementById("post-data");
					    ArrayList<Element>  titre= element.getElementsByClass("titreJob");
					   // List<Node> children = ((Element)titre).childNodes();
					    
					    Element erf = doc.select("em.date span").first();
						 
					    //System.out.println(titre.text());
					    //String link = titre.attr("href");
					    //System.out.println(link);
					    //System.out.println("\n");
					   // for(int i2=0; i2<((NodeList) children).getLength(); i2++) 
					    for(Element e:titre){
					    	 String link = e.attr("href");
						     //System.out.println(((Node) e).outerHtml() );
					    	 Document doc1= Jsoup.connect("https://www.rekrute.com/"+link).get( );
					    	 Elements content= doc.getElementsByTag("title");
					    	 String content1=content.text();
					    	 Elements metier= doc1.select("div.col-md-10.col-sm-12.col-xs-12 h1");
							 System.out.println(metier.text());
					    	 System.out.println(content.text());
					    	 String url="https://www.rekrute.com/"+link;
					    	 Emploi job=new Emploi();
					    	 System.out.println("URL est :https://www.rekrute.com/"+link);
					    	 System.out.println("Rekrute");
					    	 String sitename="Rekrute";
					    	 System.out.println(erf.text());
					    	 String erf1=erf.text();
					    	 Elements datepost= doc1.select("span.newjob b");
							 System.out.println(datepost.text());
							 String datepost1=datepost.text();
							 Elements adresse= doc1.select("span#address");
					    	 System.out.println(adresse.text());
					    	 String adresse1=adresse.text();
					    	 Elements entreprise= doc1.select("div#recruiterDescription p");
					 		 System.out.println(entreprise.text());
					 		 String entreprise1=entreprise.text();
					 		 Element post= doc1.select("div.col-md-12.blc:nth-of-type(4)").first();
							 System.out.println(post.text());
							 String post1=post.text();
							 Element profiler= doc1.select("div.col-md-12.blc:nth-of-type(5)").first();
							 System.out.println(profiler.text());
							 String profiler1=profiler.text();
							 Elements secteur= doc1.getElementsByClass("h2italic");
					    	 System.out.println(secteur.text());
					    	 String secteur1=secteur.text();
							 String metier1=metier.text();
							 Element niveau = doc1.select("ul.featureInfo:nth-child(3) li").last();
					    	 System.out.println(niveau.text());
					    	 String niveau1=niveau.text();
					    	 //Elements diplome = profiler.select("p:nth-of-type(2)");
					    	 //System.out.println(diplome.text()); 
					    	 Element exp = doc1.select("ul.featureInfo:nth-child(3) li").first();
					    	 System.out.println(exp.text());
					    	 String exp1=exp.text();
					    	 Element trait = doc1.select("div.col-md-12.blc  p").first();
					    	 System.out.println(trait.text());
					    	 String trait1=trait.text();
							 Element contrat = doc1.select("span.tagContrat").first();
					    	 System.out.println(contrat.text());
					    	 String contrat1=contrat.text();
							 Element mode = doc1.select("span.tagContrat").last();
							 System.out.println(mode.text());
							 String mode1=mode.text();
							 Elements tech = profiler.select("p strong");
					    	 System.out.println(tech.text());
					    	 String tech1=tech.text();
					    	 System.out.println("\n");
					    	 System.out.println("\n");
					    	 job.titre=content1;
					    	 job.url=url;
					    	 job.sitename=sitename;
					    	 job.erf1=erf1;
					    	 job.datepost1=datepost1;
					    	 job.adresse1=adresse1;
					    	 job.entreprise1=entreprise1;
					    	 job.post1=post1;
					    	 job.profiler1=profiler1;
					    	 job.secteur1=secteur1;
					    	 job.metier1=metier1;
					    	 job.niveau1=niveau1;
					    	 job.exp1=exp1;
					    	 job.trait1=trait1;
					    	 job.contrat1=contrat1;
					    	 job.mode1=mode1;
					    	 job.tech1=tech1;
					    	 db.addJob(job);					    	 
						   }
					}
					}catch (IOException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
				
					}
		}
	}
	

