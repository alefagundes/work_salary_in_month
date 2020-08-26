package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter with the name of departament:");
		String nameDepartment = sc.nextLine();
		System.out.println("Enter with a data Worker:");
		System.out.print("Name:");
		String workerName = sc.nextLine();
		System.out.println("Level:");
		String workerLevel = sc.nextLine();
		System.out.println("Base Salary:");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(nameDepartment));
		System.out.println("How many contracts this woker have:");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract #" + (i+1) + " data");
			System.out.print("Date(DD/MM/YYYY):");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per Hour:");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duration(hour):");
			int duration = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, duration);
			worker.addContract(contract);

		}
		System.out.println();
		
		System.out.println("Enter month and year to calculate income (MM/YYYY):");
		String dataAndYear = sc.next();
		int month = Integer.parseInt(dataAndYear.substring(0, 2));
		int year = Integer.parseInt(dataAndYear.substring(3));
		System.out.println("Name:" + worker.getName());
		System.out.println("Department:" + worker.getDepartment().getName());
		System.out.println("Income for " + dataAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
