package tester;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.core.Publications;

import custom_exception.PublicationException;
import custom_ordering.PublishDateComparator;
import custom_ordering.RatingComparator;

import static publicationUtils.PublicationValidationRules.validateBook;
import static publicationUtils.PublicationValidationRules.validateTape;
import static publicationUtils.PublicationValidationRules.Item5YrsOld;
import static publicationUtils.PopulateData.populateData;

public class PublicationsTester {

	public static void main(String[] args) throws PublicationException {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)) {
			List<Publications> publicationList = new ArrayList<>();
			publicationList = populateData(); //sampleData
			boolean exit = false;
			
			while(!exit) {
				System.out.println("Welcome to Publications");
				try {
					System.out.println("1. Publish new book \n2. Publish new tape "
							+ "\n3. List all books ordered by publish date in dscending order "
							+ "\n4. List top 5 publications of current year based on rating "
							+ "\n5. Remove all publications which are 5 yrs old \n6. display all \n0. Exit");
					System.out.print("Choose an option : ");
					int choice = sc.nextInt();
					
					
					switch(choice) {
						case 1 : 
							System.out.println("Enter Name of Book, Price, Publish Date(yyyy-MMM-dd),"
									+ " Ratings(1-10), No. of pages");
							Publications book = validateBook(sc.next(), sc.nextDouble(), sc.next(),
									sc.nextInt(), sc.nextInt(), publicationList);
							publicationList.add(book);
							System.out.println("Book added!");
							break;
							
						case 2 : 
							System.out.println("Enter Name of Tape, Price, Publish Date(yyyy-MMM-dd),"
									+ " Ratings(1-10), length of tape(in minutes) : ");
							Publications tape = validateTape(sc.next(), sc.nextDouble(), sc.next(),
									sc.nextInt(), sc.nextInt(), publicationList);
							publicationList.add(tape);
							System.out.println("Tape added!");
							break;
							
						case 3 : 
							PublishDateComparator pc = new PublishDateComparator();
							Collections.sort(publicationList, pc);
							System.out.println("publish date in descending order : ");
							for(Publications p : publicationList) {
								System.out.println(p);
							}
							break;
							
						case 4 : 
							RatingComparator rc = new RatingComparator();
							Collections.sort(publicationList, rc);
							System.out.println("Top 5 publications : ");
							for(int i = 0; i < 5; i++) {
								System.out.println(publicationList.get(i));
							}
							break;
							
						case 5 : 
							for(int i = 0; i < publicationList.size(); i++) {
								if(Item5YrsOld(publicationList.get(i).getPublish()))
									publicationList.remove(i);
							}
							System.out.println("Items 5 years old Removed!");
							break;
						
						case 6 :
							for(Publications p : publicationList) {
								System.out.println(p);
							}
							break;
							
						case 0 :
							exit = true;
							System.out.println("Byee...:)");
							break;
					}
				}
				catch(Exception e) {
					System.out.println("Please retry..:(");
					sc.nextLine();				
				}
			}
		}
	}
}
