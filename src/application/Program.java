package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exeptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int num = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Initial balance:");
		double iB = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double wL = sc.nextDouble();
		
		Account x = new Account(num, name, iB, wL);
		System.out.println();
		System.out.print("Enter amount for withdraw:");
		double amount = sc.nextDouble();
		try {
			x.withdraw(amount);
			System.out.println("New balance: "+ String.format("%.2f", x.getBalance()));
		}
		catch (DomainException error) {
			System.out.println("Withdraw error: "+ error.getMessage());
			
		}
		sc.close();

	}

}
