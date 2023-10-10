package points;
import java.lang.Math;

public class Points2D {

	private double x;
	private double y;

	public Points2D() {
		this.x = 0.0;
		this.y = 0.0;
	}

	public Points2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String show() {
		return "Point co -ords are : x=" +this.x + ", y="+ this.y;
	}
	
	public boolean isEqual(Points2D p) {
		return (this.x==p.x && this.y==p.y);
	}
	
	public double distance(Points2D p) {
		return Math.sqrt((p.x-this.x)*(p.x-this.x) + (p.y-this.y)*(p.y-this.y));
	}
	public String toString() {
		return "pachka";
	}
}
