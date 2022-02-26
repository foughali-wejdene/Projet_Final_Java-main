

import javax.swing.UIManager;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.Math.*;
import java.lang.String.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * <p>Titre : Monopoly Simplifié</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2002</p>
 * <p>Société : </p>
 * @author MAVROMATIS Christos, MONTEIL Sébastien
 * @version 1.0
 */

public class monopoly {
  boolean packFrame = false;
  private Plateau p;
  private Vector tabJoueur;
  public  Joueur cour;
  public int nbJoueur;
  public CaseTerrain ct;
  public Principal frame;
  public int val;

  //Construire l'application
  public monopoly() {
     frame = new Principal();

    //Valider les cadres ayant des tailles prédéfinies
    //Compacter les cadres ayant des infos de taille préférées - ex. depuis leur disposition
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }

    //Centrer la fenêtre
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();

    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();

    IB dlg = new IB(null,"Entrer le nombre de joueurs");

    //Centre la PoPup
    Dimension dlgSize = dlg.getPreferredSize();
    dlg.setLocation((dimension.width - dlgSize.width) / 2 , (dimension.height - dlgSize.height) / 2 );
    dlg.setModal(true);
    dlg.show();

    nbJoueur= Integer.parseInt(dlg.Res.getText()) ;//Recupere l'info de la popup

    p=new Plateau();//Déclaration des cases
    p.init();
    tabJoueur=new Vector();//Tableau de joueur

    for(int i=0; i<nbJoueur;i++){
           String ret;//Valeur de retour
	   //nouvelle InputBox
           IB dlg2 = new IB(null,"Entrer le nom du joueur numéro " + String.valueOf(i+1));
	   //Centrer la PopUp
           dlg2.setLocation((dimension.width - dlgSize.width) / 2 , (dimension.height - dlgSize.height) / 2 );
           dlg2.setModal(true);
           dlg2.show();
           ret= dlg2.Res.getText() ;//Récupere la Valeur
           Joueur j=new Joueur(ret);//Nouveau Joueur
	   tabJoueur.addElement(j);//L'ajoute
        }
        val=0;
	tour(val);
	//Ajoute un listener sur le bouton de passage de tour
	frame.jButtonTourSuiv.addActionListener(new java.awt.event.ActionListener(){

	public void actionPerformed(ActionEvent e) {
	  Object source=e.getSource();//Objet appelant
	  if (source==frame.jButtonTourSuiv )
             {if (!gagnant())tour(val);}
	     //Verifie si il y a un gagnant
	      if (puDArgent( (getVec()).size()-1 )){
		  Joueur j=(Joueur)((getVec()).elementAt( (getVec()).size()-1 ));
		  Joueur faible=(Joueur)((getVec()).remove( (getVec()).size()-1 ));
		}
	}});//Fin Listener

	//Nouveau Listener Bouton Acheter
	frame.jButtonBuy.addActionListener(new java.awt.event.ActionListener() {

	public void actionPerformed(ActionEvent e) {
         Object source=e.getSource();
         if (source==frame.jButtonBuy){
	    if (cour.getCredit()>ct.getPrix()){
             cour.acheter(ct);//AChete la case
	     frame.jLabelRSolde.setText(Integer.toString(cour.getCredit()));
	     frame.jButtonBuy.setEnabled(false);}//Bloquer le bouton
	     Msgbox.affMsg(frame,"Vous avez acheté " + ct.afficher_case() + " pour " + Integer.toString(ct.getPrix())+ " FF") ;}
	    else Msgbox.affMsg(frame,"Vous n'avez pas les moyens :) ");

	   }
	});
	    }

        public void  tour(int i)
        {       val=i;

		int de =(int)(10*Math.random())+2;//dés

                frame.jButtonBuy.setEnabled(false);//cache par défaut le bouton acheter
		cour=(Joueur)(tabJoueur.elementAt(i));
		frame.jLabelPropNom.setText("LIBRE");

		int prevpos=cour.getPos();
		if (prevpos==-1)prevpos=0;

		int temp=de+prevpos;
		if (temp>40){
		    temp=temp-40;
		    cour.recoit(20000);
		    Msgbox.affMsg(frame,"Vous passez par le case Départ et recevez 20000 F") ;
		    }

		cour.setPos(temp);
		ct= (CaseTerrain)((p.getVec()).elementAt(temp));
		frame.jLabelPrixCase.setText(Integer.toString(ct.getPrix()));
                frame.jLabelRNC.setText(ct.afficher_case());
  		frame.jLabelLoyer.setText(Integer.toString(ct.loyer));
		frame.jLabelGroupe.setText(ct.afficher_groupe());

		if (prevpos>0)
		  {
                CaseTerrain ctPrev=(CaseTerrain)((p.getVec()).elementAt(prevpos));
                frame.jLabelCaseWere.setText(ctPrev.afficher_case() );
		  }
                else frame.jLabelCaseWere.setText("Case départ");

		if (ct.aVendre()){ //le joueur peut acheter la carte
                        frame.jButtonBuy.setEnabled(true);
                        Joueur j=(Joueur)(tabJoueur.remove(i));
			tabJoueur.addElement(cour);

		}
		else{ //le joueur doit payer s'il n'est pas deja proprietaire de la carte
			int loy=ct.calculerLoyer();
			frame.jLabelPropNom.setText(ct.getProprietaire().getNom());
			Joueur p=ct.getProprietaire();
			if(!p.equals(cour)){
				if (loy>0){

				Msgbox.affMsg(frame,"Vous devez payer " +loy + " FF à " + p.getNom()) ;
				cour.paye(loy);
				p.recoit(loy);

				if  (p.getNom()!="Etat"){
				Joueur j=(Joueur)(tabJoueur.remove(i));
				tabJoueur.addElement(cour);

				int x=tabJoueur.indexOf(p);
				Joueur y=(Joueur)(tabJoueur.remove(x));
				tabJoueur.add(x,p);}}
			}

		}
		System.out.println("le tour du joueur "+cour.getNom()+" est fini");

		frame.jLabelRSolde.setText(Integer.toString(cour.getCredit()));
                frame.jLabelNJ.setText(cour.nom);
                frame.jLabelLDR.setText(Integer.toString(de));


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
			Msgbox.affMsg(frame,"Le joueur " + j.getNom() + " à gagné la partie");
			//System.out.println("La partie est finie\nle gagnant est le joueur: "+j.getNom());
			frame.jButtonTourSuiv.setEnabled(false);
			frame.jButtonBuy.setEnabled(false);
			return (true);
		}
	}

	public void start(){
	    tour(val);
	}


  //Méthode principale
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new monopoly();
  }
}



