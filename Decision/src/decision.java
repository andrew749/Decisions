import java.util.Random;
import java.util.Scanner;

//A Program from andrew749 productions
public class decision {
	// string that will capture the options
	public static int[] optionvalues = new int[100];
	public static Scanner scanner = new Scanner(System.in);
	public static int testtimes = 0;
	public static int valueof;
	public static int numberofoptionarrayvalues;
	public static String finalanwser;
	static String[] options = new String[100];

	// integer that will store the value that the user will enter to test

	// method to assign values to each variable based on what number is
	// generated
	public static void count(int position) {
		++optionvalues[position];
	}

	// method to run loop to generate numbers
	public static void runloop(int testnumber) {
		Random random = new Random();
		for (int i = 0; i < testnumber; i++) {
			valueof = random.nextInt(numberofoptionarrayvalues - 1);
			count(valueof);
		}
	}

	// gets input from the user to see the amount of times they want to test the
	// certain option
	final public static void gettesttimes() {
		System.out
				.println("Please enter the amount of times you want to test the options");
		testtimes = scanner.nextInt();
	}

	public static String[] getuserinput(String[] options) {
		int i = 0;
		do {
			numberofoptionarrayvalues = i + 1;
			options[i] = scanner.nextLine();
			if (options[i].equals("q")) {
				break;
			}
			System.arraycopy(options, 0, options, 0, i);
			i++;
		} while (i < options.length);
		return options;
	}

	// shows the results of the random loop
	// coded for any number of options as long as numberofoptionarrayvalues is
	// present
	public static String results(String anwser, String[] option) {
		String result = "The Results are in: ";
		for (int i = 0; i < numberofoptionarrayvalues; ++i) {
			result += option[i] + " has " + optionvalues[i] + " ";
			anwser = result;
		}
		;
		System.out.println(anwser);
		return anwser;
	}

	// main loop
	public static void main(String[] args) {
		System.out
				.println("Please enter your options and enter a \"q\" to stop entering items");
		options = getuserinput(options);
		gettesttimes();
		runloop(testtimes);
		results(finalanwser, options);
	}
}
