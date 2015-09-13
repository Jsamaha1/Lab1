package lab1;
// Imports the scanner and FinanceLib
import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class Main {

	public static void main(String[] args) {
		// Prompts the user for the years they would like to work
		System.out.println("How many years would you like to work: ");
		
		// Creates the scanner object and asks for the first value
		Scanner input = new Scanner(System.in);
		
		int yearsToWork = input.nextInt();
		
		//Prompts the user for the rest of the fields
		
		System.out.println("What is your intrest rate: ");
		float interestRate = input.nextFloat();
		//Convert the interest rate into its decimal equivalent
		interestRate /= 100;
		
		System.out.println("How many years will you be retired: ");
		int yearsRetired = input.nextInt();
		
		System.out.println("What is your annual retirement rate: ");
		float annualReturn = input.nextFloat();
		//Convert Annual Return to its decimal equivalent
		annualReturn /= 100;
		
		System.out.println("What will your required income be: ");
		float requiredIncome = input.nextFloat();
		
		System.out.println("What is your expected monthly SSI: ");
		float monthlySSI = input.nextFloat();
		// Now all of the input has been received from the user
		// First convert the annual return and interest rates into monthly
		float monthlyReturn = annualReturn / 12;
		float monthlyRate = interestRate / 12;
		
		//Convert years retired and years worked to months
		float monthsRetired = yearsRetired * 12;
		float monthsWorked = yearsToWork * 12;
		//Difference between required income and monthly SSI
		float moneyNeeded = requiredIncome - monthlySSI;
		
		// Using the imported finance library, calculate the PV
		double PV = FinanceLib.pv(monthlyReturn, monthsRetired, moneyNeeded, 0, false);
		
		// Next use FinanceLib to calculate the PMT
		double PMT = FinanceLib.pmt(monthlyRate, monthsWorked, 0, PV, false);
		
		//Prints out the resulting PMT
		System.out.printf("You must save $%.2f every month.", PMT);
		input.close(); // Closes the scanner
	}
	
}
