import java.awt.Color;
import java.util.*;

public class Dialogue {

	private static Tortue tortue;

	private static SimpleLogo logo;
	
	public static boolean executerCommande(SimpleLogo l, String com){
		
		Scanner sc = new Scanner(com);
		
		String commande;
		
		String couleur;
		
		int reponse;
		
		boolean fini=!sc.hasNext();
		
		logo = l;
		
		tortue = l.getTortue();
		
		while(!fini){
			commande = sc.next();
			switch(commande){
				
			case "av":
				System.out.print("La tortue va avancer de ");
				if(sc.hasNextInt()){
					reponse = sc.nextInt();
					System.out.println(""+ reponse + ".");
					avancer(reponse);
					
				}
				else System.out.print(" ! Mauvais argument.");
				
				break;
			case "re":
				System.out.print("La tortue va reculer de ");
				if(sc.hasNextInt()){
					reponse = sc.nextInt();
					System.out.println(""+ reponse + ".");
					reculer(reponse);
					
				}
				else System.out.print(" ! Mauvais argument.");
				break;
			case "td":
				System.out.print("La tortue va tourner de ");
				if(sc.hasNextInt()){
					reponse = sc.nextInt();
					System.out.println(""+ reponse + " degrés.");
					tournerDroite(reponse);
					
				}
				else System.out.print(" ! Mauvais argument.");
				break;
			case "tg":
				System.out.print("La tortue va tourner de ");
				if(sc.hasNextInt()){
					reponse = sc.nextInt();
					System.out.println("-"+ reponse + ".");
					tournerGauche(reponse);
					
				}
				else System.out.print(" ! Mauvais argument.");
				break;
			case "lc":
				System.out.println("La tortue lève son crayon.");
				leverCrayon();
				break;
			case "bc":
				System.out.println("La tortue baisse son crayon.");
				baisserCrayon();
				break;
			case "ct":
				System.out.println("La tortue est cachée.");
				cacherTortue();
				break;
			case "mt":
				System.out.println("La tortue n'est plus cachée.");
				afficherTortue();
				break;
			case "c":
				if(sc.hasNext()){
					couleur = sc.next();
					System.out.println("La tortue prend le crayon "+ couleur +".");
					changerCouleur(couleur);
				}else{
					System.out.println("Pas d'argument.");
				}
				break;
			case "eff":
				effacer();
				break;
			case "rep":
				String ncom = "";
				String borne = "";
				int nb=0;
				int nbborne = 0;
				
				if (sc.hasNextInt()) nb = sc.nextInt();
				else System.out.println("Mauvais argument");
				
				if(sc.hasNext()) borne = sc.next();
				else System.out.println("Mauvais argument");
				
				if (borne.equals("[")) nbborne ++;
				
				if(nbborne == 1){
					while(nbborne > 0){
						if(sc.hasNext()) borne = sc.next();
						if(borne.equals("]")) nbborne --;
						if (borne.equals("[")) nbborne ++;
						if(nbborne > 0) ncom += borne + " ";
						
					}
				}
				else System.out.println("Mauvais argument");
				
				rep(l,nb,ncom);
				
				break;
			case "quitter":
				return quitter();
			default:
				System.out.println("Commande inconnue.");
			}
			fini=!sc.hasNext();
		}
		sc.close();
		return !fini;
	}
	
	public static void avancer(int d){
		
		double angle = Math.toRadians(tortue.getAngle());
		
		double sinAngle = Math.sin(angle);
		double cosAngle = Math.cos(angle);
		
		double x2 = cosAngle*d+tortue.getX();
		double y2 = sinAngle*d+tortue.getY();
		
		
		Trace tr = new Trace(((int)tortue.getX()),((int)tortue.getY()), ((int)x2) ,((int)y2), tortue.getCouleur(), tortue.etreLeve());
		
		logo.insererTrace(tr);
		
		tortue.setPosition(x2,y2);
	}
	
	public static void reculer(int d){
			avancer(-d);
	}
	
	public static void tournerDroite(int a){
		
		int angle = (tortue.getAngle() + a)%360;
		tortue.setAngle(angle);
	}
	
	public static void tournerGauche(int a){
		
		int angle = (tortue.getAngle() - a)%360;
		//if (angle<0) angle *=-1;
		tortue.setAngle(angle);
	}
	
	public static void baisserCrayon(){
		
		tortue.baisserCrayon();
	}
	
	public static void leverCrayon(){
		
		tortue.leverCrayon();
	}
	
	public static void afficherTortue(){
		
		tortue.afficheTortue();
	}
	
	public static void cacherTortue(){
		
		tortue.cacheTortue();
	}
	
	public static void changerCouleur(String s){
		
		s.toLowerCase();
		switch(s){
		case "noir":
			tortue.setCouleur(Color.black);
			break;
		case "bleu":
			tortue.setCouleur(Color.blue);
			break;
		case "cyan":
			tortue.setCouleur(Color.cyan);
			break;
		case "vert":
			tortue.setCouleur(Color.green);
			break;
		case "magenta":
			tortue.setCouleur(Color.magenta);
			break;
		case "orange":
			tortue.setCouleur(Color.orange);
			break;
		case "rouge":
			tortue.setCouleur(Color.red);
			break;
		case "rose":
			tortue.setCouleur(Color.pink);
			break;
		case "jaune":
			tortue.setCouleur(Color.yellow);
			break;
		default:
			System.out.println("Couleur inconnue.");
		}
	}
	
	
	public static void effacer(){
		SimpleLogo.setIndiceTrace(0);
		tortue.setAngle(-90);
		tortue.setPosition(logo.getWidth()/2.0, logo.getHeight()/2.0);

	}
	
	public static boolean quitter(){
		
		return false;
	}
	
	public static void rep(SimpleLogo l, int n, String s){
		for(int i = 0; i<n;i++){
			executerCommande(l,s);
		}
	}
	
	
}

