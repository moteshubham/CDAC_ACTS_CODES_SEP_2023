package tester;

import java.util.Scanner;

import com.app.core.BinarySearchTree;

public class BinarySearchTreeMain {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			BinarySearchTree bst = new BinarySearchTree();

			boolean exit = false;
			while (!exit) {
				System.out.println();
				System.out.println("1. Insert Data");
				System.out.println("2. InOrder Display");
				System.out.println("3. PreOrder Display");
				System.out.println("4. PostOrder Display");

				System.out.println("Choose an option : ");

				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();
						System.out.println("Enter element to add");
						bst.insertNode(sc.nextInt());
						sc.nextLine();
						break;

					case 2:
						sc.nextLine();
						System.out.println("Inorder Traversal : ");
						bst.inorderTraversal();
						break;

					case 3:
						sc.nextLine();
						System.out.println("Preorder Traversal : ");
						bst.preorderTraversal();
						break;

					case 4:
						sc.nextLine();
						System.out.println("Postorder Traversal : ");
						bst.postorderTraversal();
						break;

					case 0:
						exit = true;
						System.out.println("byeeeeeeeeeee");
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}
	}
}
