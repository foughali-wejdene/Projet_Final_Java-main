

public class Joueur{
	String nom;
	String password;
	int credit;
	int pos;

	public Joueur(String nom, String password){
		this.nom=nom;
		credit=20000;
		pos=-1;
		this.password=password;
		credit=20000;
		pos=-1;
	}

	public String getNom(){
		return(nom);
	}
	public String getpassword(){
		return(password);
	}

	public int getPos(){
		return(pos);
	}

	public void setPos(int pos){
		this.pos=pos;
	}

	public int getCredit(){
		return (credit);
	}

	public void acheter(CaseTerrain ct){
		if ( ct.aVendre() && credit>=ct.getPrix() ){
			credit-=ct.getPrix();
			ct.setProprietaire(this);
		}
	}

	public boolean equals(Joueur j){
		return (nom.equals(j.nom) && (password.equals(j.password) &&credit==j.credit));
	}

	public void paye(int loyer){
		credit-=loyer;
	}

	public void recoit(int loyer){
		credit+=loyer;
	}
}