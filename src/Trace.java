import java.awt.*;


public class Trace {
	
	private Point p1; //départ du tracé
	
	private Point p2; // arrivée du tracé
	
	private Color couleur; // couleur du tracé
	
	private boolean leve; // indique si le crayon est levé

	
	public Trace(Point p1, Point p2, Color c, boolean b){
		this.p1=p1;
		this.p2=p2;
		this.couleur=c;
		leve=b;
	}

	// constructeur à partir des coordonnées des points
	public Trace(int x1, int y1, int x2, int y2, Color c,boolean b){
		this.p1=new Point(x1,y1);
		this.p2=new Point(x2,y2);
		this.couleur=c;
		leve=b;
	}

	
	public Point getP1() {
		return p1;
	}

	
	public void setP1(Point p1) {
		this.p1 = p1;
	}

	
	public Point getP2() {
		return p2;
	}

	
	public void setP2(Point p2) {
		this.p2 = p2;
	}

	
	public Color getCouleur() {
		return couleur;
	}

	
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	
	public boolean getLeve() {
		return leve;
	}

	public void setLeve(boolean leve) {
		this.leve = leve;
	}

}