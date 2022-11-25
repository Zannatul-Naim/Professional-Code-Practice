import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if (args.length != 1) {
			System.out.println("\nUsage: a | r | c | +Student | ?Student\n");
		} else {
			if (args[0].equals("a")) {
				System.out.println("Loading data ...");
				String line = readLineFromFile("students.txt");
				String names[] = line.split(",");
				for (String name : names) {
					System.out.println(name.trim());
				}
				System.out.println("Data Loaded.");
			} else if (args[0].equals("r")) {
				System.out.println("Loading data ...");
				String line = readLineFromFile("students.txt");
				String names[] = line.split(",");
				Random random = new Random();
				int randomNumber = random.nextInt(4);
				System.out.println(names[randomNumber].trim());
				System.out.println("Data Loaded.");
			} else if (args[0].contains("+")) {
				System.out.println("Loading data ...");
				try {
					BufferedWriter bufferedWriter = writeFile("students.txt");
					String newStudent = args[0].substring(1);
					Date date = new Date();
					String dateTimeFormat = "dd/MM/yyyy-hh:mm:s a";
					DateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
					String dateToday = dateFormat.format(date);
					bufferedWriter.write(", " + newStudent + "\nList last updated on " + dateToday);
					System.out.println(newStudent + " is added to Students.txt");
					bufferedWriter.close();
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else if (args[0].contains("?")) {
				System.out.println("Loading data ...");
				String line = readLineFromFile("students.txt");
				String names[] = line.split(",");
				boolean done = false;
				String student = args[0].substring(1);
				for (int index = 0; index < names.length && !done; index++) {
					if (names[index].trim().equals(student)) {
						System.out.println("We found it!");
						done = true;
					}
				}
				if (done == false) {
					System.out.println("We didn't found it");
				}
				System.out.println("Data Loaded.");
			} else if (args[0].contains("c")) {
				System.out.println("Loading data ...");
				String line = readLineFromFile("students.txt");
				char charArray[] = line.toCharArray();
				int count = 0;
				for (char character : charArray) {
					if (character == ',') {
						count++;
					}
				}
				count++;
				System.out.println(count + " word(s) found ");
				System.out.println("Data Loaded.");
			}
		}

	}

	static String readLineFromFile(String fileName) {
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(fileName)));
			return bufferedReader.readLine();
		} catch (Exception e) {
			return null;
		}
	}

	static BufferedWriter writeFile(String fileName) {
		try {
			return new BufferedWriter(new FileWriter(fileName, true));
		} catch (Exception e) {
			return null;
		}
	}
}