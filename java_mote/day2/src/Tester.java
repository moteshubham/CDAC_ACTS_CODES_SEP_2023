import java.lang.*;


class Tester
{
	public static void main(String [] args)
	{
		Point2D point1 = new Point2D(1, 2);
		Point2D point2 = new Point2D(1,2);
		System.out.println(point1.showPoint());
		System.out.println(point1.isEqual(point2));
	}
}