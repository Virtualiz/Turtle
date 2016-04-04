import java.awt.*;

public class Tortue{

	
	private double x; // abscisse de la position de la tortue
	
	private double y; // ordonnée de la position de la tortue
	
	private int orientation; // orientation de la tortue en degrés
	
	private Color couleur; // couleur du crayon de la tortue
	
	private boolean leve; // indique si le crayon est levé
	
	private boolean tAffiche; // indique si la tortue est affichée

	public Tortue(int abs, int ord, Color c){
		this.x = abs;
		this.y = ord;

		this.couleur = c;
		this.orientation = -90;
		this.tAffiche=true;
	}

	
	public void afficheTortue(){
		this.tAffiche = true;
	}

	
	public void cacheTortue(){
		this.tAffiche=false;
	}

	
	public boolean etreVisible(){
		return this.tAffiche;
	}

	
	public int getAngle(){
		return this.orientation;
	}

	
	public void setAngle(int a){
		this.orientation=a;
	}

	
	public double getX(){
		return x;
	}

	
	public double getY(){
		return y;
	}

	
	public void setPosition(double abs, double ord){
		x= abs;
		if(x<=0) x=0;
		y= ord;
		if(y<=0) y=0;
	}

	
	public void setCouleur(Color c){
		this.couleur = c;
	}

	
	public Color getCouleur(){
		return this.couleur;
	}


	
	public void leverCrayon(){
		leve = true;
	}

	
	public void baisserCrayon(){
		leve = false;
	}

	
	public boolean etreLeve(){
		return leve;
	}


}
