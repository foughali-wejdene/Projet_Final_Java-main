

import java.io.*;
import java.util.*;
import java.lang.Math.*;
import java.lang.String.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Partie{
	private Plateau p;
	private Vector tabJoueur;

        public Joueur cour;

        public Partie(int nbJoueur){
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension dimension = toolkit.getScreenSize();

		p=new Plateau();
		p.init();
		tabJoueur=new Vector();
		for(int i=0; i<nbJoueur;i++){
                        String ret;

                        IB dlg = new IB(null,"Entrer le nom du joueur numéro " + String.valueOf(i+1));

                        Dimension dlgSize = dlg.getPreferredSize();

                        dlg.setLocation((dimension.width - dlgSize.width) / 2 , (dimension.height - dlgSize.height) / 2 );
                        dlg.setModal(true);
                        dlg.show();
                        ret= dlg.Res.getText() ;
                        Joueur j=new Joueur(ret);
			tabJoueur.addElement(j);
                  }


	}

	public void tour(int i){ //deroulement du tour de joueur dont l'indice est i ds le vecteur
		int de =(int)(10*Math.random())+2;

		cour=(Joueur)(tabJoueur.elementAt(i));

                System.out.println("Debut du tour de "+cour.getNom()+"\nVous avez tire un "+de+"\n");

		int prevpos=cour.getPos();
		cour.setPos(de+prevpos);

		CaseTerrain ct= (CaseTerrain)((p.getVec()).elementAt(de+prevpos));
		//System.out.println(ct.afficher());

		if (ct.aVendre()){ //le joueur peut acheter la carte
			System.out.println("Voulez vous acheter (o/n)?: ");
			if( (testES.LireMot()).equals("o") || (testES.LireMot()).equals("O") ){
				cour.acheter(ct);
				System.out.println("le joueur "+cour.getNom()+" a achete la carte "+ct.getNom()+"\n");
				Joueur j=(Joueur)(tabJoueur.remove(i));
				tabJoueur.addElement(cour);
			}
			else{Joueur j=(Joueur)(tabJoueur.remove(i));
			tabJoueur.addElement(cour);
			} //si le joueur n'achete pas la carte, on le met qd meme a la fin du vecteur pour passer o joueur suivant
		}
		else{ //le joueur doit payer s'il n'est pas deja proprietaire de la carte
			int loy=ct.calculerLoyer();
			Joueur p=ct.getProprietaire();
			if(!p.equals(cour)){
				System.out.println("le joueur "+cour.getNom()+" doit payer "+loy+" au joueur "+p.getNom());
				cour.paye(loy);
				p.recoit(loy);

				Joueur j=(Joueur)(tabJoueur.remove(i));
				tabJoueur.addElement(cour);

				int x=tabJoueur.indexOf(p);
				Joueur y=(Joueur)(tabJoueur.remove(x));
				tabJoueur.add(x,p);
			}
			else{
				System.out.println("le joueur "+cour.getNom()+"possede cette carte");
			}
		}
		System.out.println("le tour du joueur "+cour.getNom()+" est fini");
	}

	public Vector getVec(){
		return (tabJoueur);
	}

	public boolean puDArgent(int i){ //retourne true si le joueur d'indice i ds le vecteur n'a plus d'argent
		Joueur cour=(Joueur)(tabJoueur.elementAt(i));
		return(cour.getCredit()<= 0);
	}

	public boolean gagnant(){
		if (tabJoueur.size()>1)
			return(false);
		else{
			Joueur j=(Joueur)(tabJoueur.elementAt(0));
			System.out.println("La partie est finie\nle gagnant est le joueur: "+j.getNom());
			return (true);
		}
	}

}

	/*public static void main(String args[]){
		System.out.println("Bienvenue au Monopoly\nDonner le nombre de joueurs :");
		int nbJoueur=testES.LireEntier();
		Partie monopoly=new Partie(nbJoueur);
		int i=0;
		do{
			monopoly.tour(i);
			if (monopoly.puDArgent( (monopoly.getVec()).size()-1 )){
				Joueur j=(Joueur)((monopoly.getVec()).elementAt( (monopoly.getVec()).size()-1 ));
				System.out.println("le joueur "+ j.getNom()+" n'a plus d'argent, vous etes le maillon faible, au revoir");
				Joueur faible=(Joueur)((monopoly.getVec()).remove( (monopoly.getVec()).size()-1 ));
			}
		}while(!monopoly.gagnant());
	}
}*/


