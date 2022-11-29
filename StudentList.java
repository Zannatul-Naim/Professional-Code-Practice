import java.io.*;
import java.lang.constant.Constable;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
		if (args.length != 1) { // Check number of arguments
			System.out.println(Constants.warningMessage);
		} else {
			if (args[0].equals(Constants.showAll)) { // Show all students name in student.txt file
				System.out.println(Constants.loadData);
				String names[] = readFromFile(Constants.studentList);
				for (String name : names) {
					System.out.println(name.trim());
				}
				System.out.println(Constants.dataLoaded);

			} else if (args[0].equals(Constants.randomName)) { // Show a random student name
				System.out.println(Constants.loadData);
				String names[] = readFromFile(Constants.studentList);
				Random random = new Random();
				System.out.println(names[random.nextInt(4)].trim());
				System.out.println(Constants.dataLoaded);

			} else if (args[0].contains(Constants.addName)) { // Add a new student
				System.out.println(Constants.loadData);
				String newStudentName = args[0].substring(1);
				DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormat);
				String formatedDate = dateFormat.format(new Date());
				deleteUpdateMessage(Constants.studentList);
				writeFile(Constants.studentList,
						Constants.comma + newStudentName + Constants.listUpdateMessage + formatedDate);
				System.out.println(newStudentName + Constants.addedMessage);
				System.out.println(Constants.dataLoaded);

			} else if (args[0].contains(Constants.findName)) { // find a name along with its occurrances
				System.out.println(Constants.loadData);
				String[] names = readFromFile(Constants.studentList);
				int count = 0;
				for (int i = 0; i < names.length; i++) {
					if (names[i].trim().equals(args[0].substring(1))) {
						count++;
					}
				}
				if (count == 0) {
					System.out.println(args[0].substring(1) + Constants.notFoundMessage);
				} else {
					System.out.println(args[0].substring(1) + Constants.foundMessage + " " + count + " time(s)");
				}
				System.out.println(Constants.dataLoaded);

			} else if (args[0].equals(Constants.countStudents)) { // count total number of students
				System.out.println(Constants.loadData);
				String[] names = readFromFile(Constants.studentList);
				System.out.println(names.length + Constants.wordFoundMessage);
				System.out.println(Constants.dataLoaded);
			} else {
				System.out.println(Constants.warningMessage); // Warning: when argument is invalid
			}
		}
	}

	static String[] readFromFile(String fileName) {
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
			String students[] = bufferedReader.readLine().split(Constants.comma);
			bufferedReader.close();
			return students;

		} catch (Exception e) {
			return null;
		}
	}

	public static void writeFile(String fileName, String studentName) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
			bufferedWriter.write(studentName);
			bufferedWriter.close();
		} catch (Exception e) {
		}
	}

	public static void deleteUpdateMessage(String fileName) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String studentList = bufferedReader.readLine();
			bufferedReader.close();
			File newFile = new File("temp.txt");
			File oldFile = new File("students.txt");
			newFile.createNewFile();
			writeFile("temp.txt", studentList);
			oldFile.delete();
			newFile.renameTo(oldFile);
		} catch (Exception e) {
		}
	}
}
