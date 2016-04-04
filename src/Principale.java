import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleLogo logo = new SimpleLogo();
		
		boolean etat = false;
		
		Scanner sc  = new Scanner(System.in);
		
		JFrame fenetre = new JFrame("Dessin Tortue");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		logo.setPreferredSize(new Dimension(500,500));
		
		fenetre.setContentPane(logo);
		fenetre.pack();
		fenetre.setVisible(true);
		
		logo.initialiserTortue();
		
		String com = sc.nextLine();
		
		while(!etat){
			
			etat = Dialogue.executerCommande(logo ,com);
			com = sc.nextLine();
		}
		sc.close();
		
	}

}
