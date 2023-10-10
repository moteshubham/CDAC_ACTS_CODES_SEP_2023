package tester;

import java.util.Scanner;

import points.Points2D;

public class TestPoint {

	/*
	 * Options 1. Plot a point Inputs : array index , x ,y Check boundary conditions
	 * , check if point is already plotted , if not then store the point details In
	 * case of any errors , display suitable error message.
	 * 
	 * 2. Display x,y co-ordinates of all the points plotted so far ,using for-each
	 * loop.
	 * 
	 * 3. Accept 2 indices from user . Find out if the points at these indices are
	 * same or different (Hint : isEqual) Print the message accordingly. If points
	 * are not same , display distance between these 2 points. (Draw mem diagram for
	 * your clarity, if needed/)
	 * 
	 * 0. Exit
	 */
	public static void main(String[] args) {
		
		int counter = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many points to plot : ");
		Points2D[] points = new Points2D[sc.nextInt()];
		

		boolean exit = false;
		while (!exit) {
			System.out.println("1. Plot a Point\n2. Display all points \n3. Enter 2 indices \n0.Exit");
			
			switch (sc.nextInt()) {
			case 1:
				if (counter >= 0 && counter < points.length) {
					System.out.println("Enter co ords x & y :");
					points[counter++] = new Points2D(sc.nextDouble(), sc.nextDouble());
					System.out.println("\n");
				}
				else
					System.out.println("Array size reached");
				break;
				
			case 2:
				for(Points2D p : points) {
					System.out.println(p.show());
				}
				break;
				
			case 3:
				System.out.println("Enter two indices : ");
				int p1 = sc.nextInt()-1;
				int p2 = sc.nextInt()-1;
				if (p1 >= 0 && p2 < points.length) {
					if (points[p1].isEqual(points[p2]))
						System.out.println("Same");
					else
						System.out.println("Distance between points is : " + points[p1].distance(points[p2]));
				}
				else
					System.out.println("Enter in boud indices : ");
				break;
				
			default:
				System.out.println("byeeeeeeeeeee");
				break;
			}
		}
		/*
		 * if(p1.isEqual(p2)) System.out.println("Same"); else
		 * System.out.println("Distance between points is : "+ p1.distance(p2));
		 */
	}
	/*
	 * public static void main2(String[] args) {
	 * 
	 * Scanner sc = new Scanner(System.in);
	 * System.out.println("Enter details for 2 points : "); Points2D p1 = new
	 * Points2D(sc.nextDouble(), sc.nextDouble()); System.out.println(p1.show());
	 * Points2D p2 = new Points2D(sc.nextDouble(), sc.nextDouble());
	 * if(p1.isEqual(p2)) System.out.println("Same"); else
	 * System.out.println("Distance between points is : "+ p1.distance(p2)); }
	 */

}
