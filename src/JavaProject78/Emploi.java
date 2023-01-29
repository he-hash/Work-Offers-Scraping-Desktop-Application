package JavaProject78;


import JavaProject78.webscrapping;

public class Emploi {
		String titre;
	    String url;
	     String sitename;
	     String erf1;
	     String datepost1;
	     String adresse1;
	     String entreprise1;
	     String post1;
	     String profiler1;
	     String secteur1;
	     String metier1;
	     String niveau1;
	     String exp1;
	     String trait1;
	     String contrat1;
	     String mode1;
	     String tech1;
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getSitename() {
			return sitename;
		}
		public void setSitename(String sitename) {
			this.sitename = sitename;
		}
		public String getErf1() {
			return erf1;
		}
		public void setErf1(String erf1) {
			this.erf1 = erf1;
		}
		public String getDatepost1() {
			return datepost1;
		}
		public void setDatepost1(String datepost1) {
			this.datepost1 = datepost1;
		}
		public String getAdresse1() {
			return adresse1;
		}
		public void setAdresse1(String adresse1) {
			this.adresse1 = adresse1;
		}
		public String getEntreprise1() {
			return entreprise1;
		}
		public void setEntreprise1(String entreprise1) {
			this.entreprise1 = entreprise1;
		}
		public String getPost1() {
			return post1;
		}
		public void setPost1(String post1) {
			this.post1 = post1;
		}
		public String getProfiler1() {
			return profiler1;
		}
		public void setProfiler1(String profiler1) {
			this.profiler1 = profiler1;
		}
		public String getSecteur1() {
			return secteur1;
		}
		public void setSecteur1(String secteur1) {
			this.secteur1 = secteur1;
		}
		public String getMetier1() {
			return metier1;
		}
		public void setMetier1(String metier1) {
			this.metier1 = metier1;
		}
		public String getNiveau1() {
			return niveau1;
		}
		public void setNiveau1(String niveau1) {
			this.niveau1 = niveau1;
		}
		public String getExp1() {
			return exp1;
		}
		public void setExp1(String exp1) {
			this.exp1 = exp1;
		}
		public String getTrait1() {
			return trait1;
		}
		public void setTrait1(String trait1) {
			this.trait1 = trait1;
		}
		public String getContrat1() {
			return contrat1;
		}
		public void setContrat1(String contrat1) {
			this.contrat1 = contrat1;
		}
		public String getMode1() {
			return mode1;
		}
		public void setMode1(String mode1) {
			this.mode1 = mode1;
		}
		public String getTech1() {
			return tech1;
		}
		public void setTech1(String tech1) {
			this.tech1 = tech1;
		}
		@Override
		public String toString() {
			return "Emploi [url=" + url + ", sitename=" + sitename + ", erf1=" + erf1 + ", datepost1=" + datepost1
					+ ", adresse1=" + adresse1 + ", entreprise1=" + entreprise1 + ", post1=" + post1 + ", profiler1="
					+ profiler1 + ", secteur1=" + secteur1 + ", metier1=" + metier1 + ", niveau1=" + niveau1 + ", exp1="
					+ exp1 + ", trait1=" + trait1 + ", contrat1=" + contrat1 + ", mode1=" + mode1 + ", tech1=" + tech1
					+ "]";
		}
		public void Afficher() {
			System.out.println(this.toString());
		}
}