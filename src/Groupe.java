

import java.util.*;

public class Groupe{
	private String nom;
	private Vector lesCases;

	public Groupe(String nom){
		this.nom=nom;
		lesCases=new Vector();
	}

	public int nbTerrain(Joueur j){
		int compteur=0;

		for (int i=0; i<lesCases.size();i++){
			if( (((CaseTerrain)(lesCases.elementAt(i))).getProprietaire()).equals(j) )
				compteur++;
		}
		return (compteur);
	}

	public boolean uniqueProprietaire(Joueur j){
		return( nbTerrain(j)==lesCases.size() );
	}

	public void ajouterCase(CaseTerrain ct){
		lesCases.addElement(ct);
	}

	public String getNom(){
		return (nom);
	}
}