package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;

public class DisplayLastNamesOfEmpsByCity {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			AddressDao adrDao = new AddressDaoImpl();
			System.out.println("Enter city");

			System.out.println(adrDao.DisplayLastNamesOfEmpsByCity(sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
