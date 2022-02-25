/**
 * testES.java
 *
 * Created: Thu Feb  7 15:52:35 2002
 *
 * @author Vassiliki SPATHIS
 * @version
 */

import java.io.*;

public class testES{

	// utiliser la classe InputStream

	/**
	 * Retourne un mot lu sur l'entrée standard.
	 */
	public static String LireMot (){
		String s = "";
		char c;
		try {
			do { c = (char) System.in.read();}
			while(Character.isWhitespace(c));

			while (!Character.isWhitespace(c)) {
				s=s+c; c= (char)System.in.read();
			}
		}
		catch(IOException e){
			System.out.println("Erreur lecture :"+e.getMessage());
		}
		return s;
	}

	/**
	 * Retourne une ligne lue sur l'entrée standard.
	 */
	public static String LireLigne (){
		String s = "";
		char c;
		// readLine() n'existe pas pour les InputStream
		// Version TRES discutable car dépendante du système
		// Fin de ligne pour DOS : 13 10   (i.e. \r puis \n)
		// Fin de ligne pour UNIX : 10  (i.e. \n)
		try {
			c = (char) System.in.read();
			while (c != '\n') {
				s=s+c; c= (char)System.in.read();
			}
		}
		catch(IOException e){
			System.out.println("Erreur Lecture Ligne :"+e.getMessage());
		}
		return s;

	}

	// utiliser la classe BufferedReader

	/**
	 * Retourne une ligne lue sur l'entrée standard.
	 */
	public static String LireLine (){
		String s = "";
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = entree.readLine();
		}
		catch(IOException e){
			System.out.println("Erreur lecture Ligne :"+e.getMessage());
		}
		return s;
	}

	/**
	 * Retourne un entier lu sur l'entrée standard.
	 */
	public static int LireEntier (){
		try {
			return Integer.parseInt(LireLine()); // Essayer egalement la LireLigne
		}
		catch(NumberFormatException e){
			System.out.println("Erreur lecture entier :"+e.getMessage());
			return -1;
		}
	}

	public static float LireFlottant (){
		try {
			return (new Float(LireLine()).floatValue());
		}
		catch(NumberFormatException e){
			System.out.println("Erreur lecture entier: "+e.getMessage());
			return -1;
		}
	}

	public static long LireLong (){
		try {
			return (new Long(LireLine()).longValue());
		}
		catch(NumberFormatException e){
			System.out.println("Erreur lecture entier :"+e.getMessage());
			return -1;
		}
	}

	public static double LireDouble (){
		try {
			return (new Double(LireLine()).doubleValue());
		}
		catch(NumberFormatException e){
			System.out.println("Erreur lecture entier :"+e.getMessage());
			return -1;
		}
	}

	public static void main(String [] argv){
		System.out.println("Donnez une ligne");
		String ligne = LireLigne();
		System.out.println("la ligne est "+ ligne);

		System.out.println("Donnez un mot");
		String s = LireMot();
		System.out.println("le mot est "+ s);

		System.out.println("Donnez un entier");
		int i = LireEntier();
		System.out.println("l'entier est "+ i);

		System.out.println("Donnez un flottant");
		float fl = LireFlottant();
		System.out.println("le flottant est "+ fl);

		System.out.println("Donnez un double");
		double dou = LireDouble();
		System.out.println("le double est "+dou);

		System.out.println("Donnez un long");
		long lo = LireLong();
		System.out.println("le long est "+lo);
	}
} // testES
