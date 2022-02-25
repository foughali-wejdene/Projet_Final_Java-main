
public class CaseTerrain extends Case{
	protected int prix;
	protected int loyer;
	protected Joueur proprio;
	protected Groupe nomGroupe;

	public CaseTerrain(int p, int l, Joueur j, Groupe g, String nom, int num){
		super(nom,num);
		prix=p;
		loyer=l;
		proprio=j;
		nomGroupe=g;
	}

	public int getPrix(){
		return (prix);
	}

	public Joueur getProprietaire(){
		return (proprio);
	}

	public void setProprietaire(Joueur j){
		proprio=j;
	}

	public boolean aVendre(){
		return (proprio==null);
	}

	public boolean aLouer(){
		return(proprio!=null);
	}

	public int calculerLoyer(){
		return (loyer);
	}

	public String afficher_case(){
		return (nom);
	}

        public String afficher_groupe(){
		return (nomGroupe.getNom());
	}
}