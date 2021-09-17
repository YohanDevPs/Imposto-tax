package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Indiviual;
import entities.Taxpayers;


public class Program {

	public static void main(String[] args) throws ParseException  {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Taxpayers>list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 0; i<n; i++) {
			System.out.println("Tax payer #"+(i+1)+" data:");
			System.out.print("Individual or company (i/c)? ");
			char value = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();		
			
			if (value == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				
			list.add(new Indiviual(name, anualIncome, healthExpenditures));
			}
			
			else { 
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();

				list.add(new Company(name,anualIncome,numberOfEmployees));
					
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		double sum = 0.0;
		for (Taxpayers pay : list) {
			double tax = pay.tax();
			System.out.println(pay.getName()+ ": $ " +String.format("%.2f", pay.tax()));
			sum += tax;
			
		}
	
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	

	
	}


	
}
