import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if (args.length != 1) {
			System.out.println(Constants.INPUT_ERROR_MESSAFE);
		} else {
			if (args[0].equals(Constants.SHOW_ALL)) {
				System.out.println(Constants.LOAD_DATA);
				String line = readLineFromFile(Constants.FILE_NAME);
				String names[] = line.split(Constants.COMMA);
				for (String name : names) {
					System.out.println(name.trim());
				}
				System.out.println(Constants.LOAD_DATA);
			} else if (args[0].equals("r")) {
				System.out.println(Constants.DATA_LOADED);
				String line = readLineFromFile(Constants.FILE_NAME);
				String names[] = line.split(Constants.COMMA);
				Random random = new Random();
				int randomNumber = random.nextInt(4);
				System.out.println(names[randomNumber].trim());
				System.out.println(Constants.LOAD_DATA);
			} else if (args[0].contains(Constants.ADD_STUDENT)) {
				System.out.println(Constants.LOAD_DATA);
				try {
					BufferedWriter bufferedWriter = writeFile(Constants.FILE_NAME);
					String newStudent = args[0].substring(1);
					Date date = new Date();
					String dateTimeFormat = Constants.DATE_TIME_FORMAT;
					DateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
					String dateToday = dateFormat.format(date);
					bufferedWriter.write(Constants.COMMA + newStudent + Constants.LIST_UPDATE_MESSAGE + dateToday);
					System.out.println(newStudent + Constants.ADDED_MESSAGE);
					bufferedWriter.close();
				} catch (Exception e) {
				}
				System.out.println(Constants.LOAD_DATA);
			} else if (args[0].contains(Constants.FILE_NAME)) {
				System.out.println(Constants.LOAD_DATA);
				String line = readLineFromFile(Constants.FILE_NAME);
				String names[] = line.split(Constants.COMMA);
				boolean done = false;
				String student = args[0].substring(1);
				for (int index = 0; index < names.length && !done; index++) {
					if (names[index].trim().equals(student)) {
						System.out.println(Constants.FOUND_MESSAGE);
						done = true;
					}
				}
				if (done == false) {
					System.out.println(Constants.NOT_FOUND_MESSAGE);
				}
				System.out.println(Constants.LOAD_DATA);
			} else if (args[0].contains(Constants.COUNT_STUDENT)) {
				System.out.println(Constants.LOAD_DATA);
				String line = readLineFromFile(Constants.FILE_NAME);
				char charArray[] = line.toCharArray();
				int count = 0;
				for (char character : charArray) {
					if (character == ',') {
						count++;
					}
				}
				count++;
				System.out.println(count + Constants.WORD_COUNT_MESSAGE);
				System.out.println(Constants.LOAD_DATA);
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