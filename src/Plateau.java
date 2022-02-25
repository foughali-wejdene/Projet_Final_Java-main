

import java.util.*;

public class Plateau{
	private Vector tab;

	public Plateau(){
		tab=new Vector();
	}

	public Vector getVec(){
		return (tab);
	}

	public void init(){
		Groupe gare=new Groupe("Gare");
		Groupe compagnie=new Groupe("Compagnie");
		Groupe brun=new Groupe("Brun");
		Groupe bleuClair=new Groupe("Bleu Clair");
		Groupe violet=new Groupe("Violet");
		Groupe orange=new Groupe("Orange");
		Groupe rouge=new Groupe ("Rouge");
		Groupe jaune=new Groupe("Jaune");
		Groupe vert=new Groupe("Vert");
		Groupe Chance=new Groupe("Chance");
		Groupe Commun=new Groupe("Communaut�");
		Groupe bleuFonce=new Groupe("Bleu Fonce");
		Groupe Autres=new Groupe("Autres");
		String password = "";
		Joueur Etat=new Joueur("Etat", password);

		TerrCons c0=new TerrCons(0,-40000,null,brun,"Case D�part",0,"Autres",0);
		c0.setProprietaire(Etat);
		tab.addElement(c0);
		TerrCons c1=new TerrCons(6000,200,null,brun,"Belleville",1,"Brun",0);
		tab.addElement(c1);
		TerrCons c2=new TerrCons(0,0,null,Autres,"Case Communaut�",2,"Autres",0);
		c2.setProprietaire(Etat);
		tab.addElement(c2);
		TerrCons c3=new TerrCons(6000,400,null,brun,"Lecourbe",3,"Brun",0);
		tab.addElement(c3);
		TerrCons c4=new TerrCons(0,20000,null,Autres,"Impot sur le Revenu",4,"Autres",0);
		c4.setProprietaire(Etat);
		tab.addElement(c4);
		Gare c5=new Gare(20000,2500,null,gare,"Montparnasse",0);
		tab.addElement(c5);
		TerrCons c6=new TerrCons(10000,600,null,bleuClair,"Vaugirard",6,"Bleu Clair",0);
		tab.addElement(c6);
		TerrCons c7=new TerrCons(0,0,null,Chance,"Case Chance",7,"Chance",0);
		c7.setProprietaire(Etat);
		tab.addElement(c7);
		TerrCons c8=new TerrCons(10000,600,null,bleuClair,"Courcelles",8,"Bleu Clair",0);
		tab.addElement(c8);
		TerrCons c9=new TerrCons(12000,800,null,bleuClair,"Republique",9,"Bleu Clair",0);
		tab.addElement(c9);
		TerrCons c10=new TerrCons(0,0,null,Autres,"Prison",10,"Autres",0);
		c10.setProprietaire(Etat);
		tab.addElement(c10);
		TerrCons c11=new TerrCons(14000,1000,null,violet,"La Villette",11,"Violet",0);
		tab.addElement(c11);
		Compagnie c12=new Compagnie(15000,1000,null,compagnie,"Compagnie Electricit�",12);
		tab.addElement(c12);
		TerrCons c13=new TerrCons(14000,1000,null,violet,"Neuilly",13,"Violet",0);
		tab.addElement(c13);
		TerrCons c14=new TerrCons(16000,1200,null,violet,"Paradis",14,"Violet",0);
		tab.addElement(c14);
		Gare c15=new Gare(20000,2500,null,gare,"Lyon",0);
		tab.addElement(c15);
		TerrCons c16=new TerrCons(18000,1400,null,orange,"Mozart",16,"Orange",0);
		tab.addElement(c16);
		TerrCons c17=new TerrCons(0,0,null,Commun,"Case Communaut�",17,"Communaut�",0);
		c17.setProprietaire(Etat);
		tab.addElement(c17);
		TerrCons c18=new TerrCons(18000,1400,null,orange,"St-Michel",18,"Orange",0);
		tab.addElement(c18);
		TerrCons c19=new TerrCons(20000,1600,null,orange,"Pigalle",19,"Orange",0);
		tab.addElement(c19);
		TerrCons c20=new TerrCons(0,0,null,Autres,"Parc Gratuit",20,"Autres",0);
		c20.setProprietaire(Etat);
		tab.addElement(c20);
		TerrCons c21=new TerrCons(22000,1800,null,rouge,"Matignon",21,"Rouge",0);
		tab.addElement(c21);
		TerrCons c22=new TerrCons(22000,1800,null,Chance,"Case Chance",22,"Chance",0);
		c22.setProprietaire(Etat);
		tab.addElement(c22);
		TerrCons c23=new TerrCons(22000,1800,null,rouge,"Malesherbes",23,"Rouge",0);
		tab.addElement(c23);
		TerrCons c24=new TerrCons(24000,2000,null,rouge,"Henri-Martin",24,"Rouge",0);
		tab.addElement(c24);
		Gare c25=new Gare(20000,2500,null,gare,"Nord",0);
		tab.addElement(c25);
		TerrCons c26=new TerrCons(26000,2200,null,jaune,"St-Honore",26,"Jaune",0);
		tab.addElement(c26);
		TerrCons c27=new TerrCons(26000,2200,null,jaune,"La Bourse",27,"Jaune",0);
		tab.addElement(c27);
		Compagnie c28=new Compagnie(15000,0,null,compagnie,"G�nerale des eaux",28);
		tab.addElement(c28);
		TerrCons c29=new TerrCons(28000,2400,null,jaune,"La Fayette",29,"Jaune",0);
		tab.addElement(c29);
		TerrCons c30=new TerrCons(0,0,null,Autres,"Allez en Prison",30,"Autres",0);
		c30.setProprietaire(Etat);
		tab.addElement(c30);
		TerrCons c31=new TerrCons(30000,2600,null,vert,"Breteuil",31,"Vert",0);
		tab.addElement(c31);
		TerrCons c32=new TerrCons(30000,2600,null,vert,"Foch",32,"Vert",0);
		tab.addElement(c32);
		TerrCons c33=new TerrCons(0,0,null,Commun,"Caisse de Communaut�",33,"Communaut�",0);
		c33.setProprietaire(Etat);
		tab.addElement(c33);
		TerrCons c34=new TerrCons(32000,2800,null,vert,"Capucines",34,"Vert",0);
		tab.addElement(c34);
		Gare c35=new Gare(20000,2500,null,gare,"Saint Lazare",0);
		tab.addElement(c35);
		TerrCons c36=new TerrCons(0,0,null,Chance,"Chance",36,"Chance",0);
		c36.setProprietaire(Etat);
		tab.addElement(c36);
		TerrCons c37=new TerrCons(35000,3500,null,bleuFonce,"Champs-Elysees",37,"Bleu Fonce",0);
		tab.addElement(c37);
		TerrCons c38=new TerrCons(0,10000,null,Autres,"Taxe De luxe",38,"Autres",0);
		c38.setProprietaire(Etat);
		tab.addElement(c38);
		TerrCons c39=new TerrCons(40000,5000,null,bleuFonce,"La Paix",39,"Bleu Fonce",0);
		tab.addElement(c39);
	}

	public static void main(String args[]){
		Plateau p=new Plateau();
		p.init();
		System.out.println(p.tab.size());
	}
}