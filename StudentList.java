import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

		//Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
					new InputStreamReader(new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");			
				for(String j : i) { System.out.println(j.trim()); }
			} catch (Exception e){}

			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
					new InputStreamReader(new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");	
				Random x = new Random();
				int y = x.nextInt(4);
				System.out.println(i[y].trim());
			} catch (Exception e){}

			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter s = new BufferedWriter(
					new FileWriter("students.txt", true));
				String t = args[0].substring(1);
	        	Date d = new Date();
	        	String df = "dd/MM/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(df);
	        	String fd = dateFormat.format(d);
				s.write(", " + t + "\nList last updated on " + fd);
				System.out.println(t + " is added to students.txt");
			s.close();
			} catch (Exception e){}

			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
					new InputStreamReader(new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");	
				boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx < i.length && !done; idx++) {
					if(i[idx].trim().equals(t)) {
						System.out.println("We found it!");
						done = true;
					}
				}
				if(done == false) {
					System.out.println("We didn't found it");
				}
			} catch (Exception e){}

			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
					new InputStreamReader(new FileInputStream("students.txt"))); 
				String D = s.readLine();
				char a[] = D.toCharArray();			
				int count = 0;
				for(char c : a) {
					if(c == ',') 
					{
						count++;			
					}
				}
				count++;
				System.out.println(count + " word(s) found ");
			} catch (Exception e){}

			System.out.println("Data Loaded.");				
		}
	}
}
