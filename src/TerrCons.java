
import java.io.*;

public class TerrCons extends CaseTerrain{
	private String couleur;
	private int nbMaison;

	public TerrCons(int p, int l, Joueur j, Groupe g, String nom, int num, String c, int nb){
		super(p,l,j,g,nom,num);
		couleur=c;
		nbMaison=nb;
	}

	public int calculerLoyer(){
		if( (nomGroupe.uniqueProprietaire(proprio))&& (nomGroupe.getNom()!="Autres")){
			System.out.println(nomGroupe.getNom());
			if (nbMaison==0)return (2*loyer);
			else return(loyer*nbMaison);
		}
		else
			return(loyer);
	}

	public String afficher(){
		String s=super.afficher_case();
		return (s+"il y a actuellement "+nbMaison+" maison(s)\n");
	}


}