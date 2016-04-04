import java.awt.*;
import javax.swing.*;


public class SimpleLogo extends JPanel{

	
	private static Tortue tortue;// la tortue graphique

	
	private static int indiceTrace; // indice du tracé courant dans le tab

	
	private Trace[] tabTrace; // le tableau des tracés

	private static final int MAXTAILLE = 10000; // taille max du tab des tracés


	

	
	public SimpleLogo(){
		tabTrace = new Trace[MAXTAILLE];
		indiceTrace = 0;
		
	}
	
	//récupère l'indice du tracé
	public static int getIndiceTrace() {
		return indiceTrace;
	}

	// affecte l'indice du tracé
	public static void setIndiceTrace(int indiceTrace) {
		SimpleLogo.indiceTrace = indiceTrace;
	}
	
	//retourne la tortue
	public Tortue getTortue() {
		return tortue;
	}

	//retourne le tableau des tracés
	public Trace[] getTrace(){
		return tabTrace;
	}
	
	//crée une tortue dont coordonnées sont milieu fenetre graphique
	public void initialiserTortue(){
		tortue= new Tortue(this.getWidth()/2, this.getHeight()/2, Color.black);
	}
	
	//insère un tracé passé en paramètre
	public void insererTrace(Trace t){
		tabTrace[indiceTrace] = t;
		indiceTrace++;
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		this.setBackground(Color.white);
		Trace tr;

		for(int i=0;i<indiceTrace;i++){
			tr = tabTrace[i];
			if (!tr.getLeve()){ //Si le crayon n'est pas levé			 
				g.setColor(tr.getCouleur());
				g.drawLine((int)tr.getP1().getX(), (int)tr.getP1().getY(), (int)tr.getP2().getX(), (int)tr.getP2().getY());
			}
		}

		if(tortue.etreVisible())
			placerTortue((int)tortue.getX(),(int)tortue.getY(), tortue.getAngle(),g);
		
		repaint();
	}

	
	

	
	public void placerTortue(int x, int y, int ang, Graphics gr){
		int vx[] = new int[4];
		int vy[] = new int[4];
		
		double angle = Math.toRadians(ang); 
		
		vx[0] =  (int)(x + 15f * Math.cos(angle));
		vy[0] = (int)(y + 15f * Math.sin(angle));
		angle += 2 * Math.PI / 3.0;
		
		vx[1] =  (int)(x + 10f * Math.cos(angle));
		vy[1] =  (int)(y + 10f * Math.sin(angle));
		angle += 2f * Math.PI / 3f;
		
		vx[2] =  (int)(x + 10f * Math.cos(angle));
		vy[2] =  (int)(y + 10f * Math.sin(angle));
		
		vx[3] = vx[0];
		vy[3] = vy[0];

		gr.setColor(tortue.getCouleur());
		gr.fillPolygon(vx,vy,4);
		gr.setColor(Color.red);
		gr.drawPolygon( vx, vy, 4 );
	}

}

