
public class Gare extends CaseTerrain{

	public Gare(int p, int l, Joueur j,Groupe g, String nom, int num){
		super(p,l,j,g,nom,num);
	}

	public int calculerLoyer(){
		int nbGare= nomGroupe.nbTerrain(proprio);
		return (nbGare*loyer);
	}
}