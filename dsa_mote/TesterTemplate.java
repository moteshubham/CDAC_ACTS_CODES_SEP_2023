
import java.util.Scanner;

public class TesterTemplate {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the size of : ");

			int size = sc.nextInt();

			boolean exit = false;
			while (!exit) {
				System.out.println("\n1. Enqueue");
				System.out.println("2. Dequeue");
				System.out.println("3. Front");
				System.out.println("4. Rear");
				System.out.println("5. ");
				System.out.println("6. ");
				System.out.println("Choose an option : ");
			
				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();

						break;

					case 2:
						sc.nextLine();
						break;

					case 3:
						break;

					case 4:

						break;

					case 5:

						break;

					case 6:

						break;

					case 0:
						exit = true;
						System.out.println("byee");
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}
		}

	}

}
