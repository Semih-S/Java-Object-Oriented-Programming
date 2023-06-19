import java.io.*;  
import java.util.Scanner; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.print.attribute.standard.DateTimeAtProcessing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class DateAppTextFile {
    public static List<SimpleDate> DateAppTextFile_input(String input) {
		// Create a list since lists can be added a new value directly
        List<SimpleDate> list_date = new ArrayList<SimpleDate>(); 
		BufferedReader reader;
		// Read the file with exeption handling line by line
		try {
			reader = new BufferedReader(new FileReader(input));
			String line = reader.readLine();

			while (line != null) {
				// Store values in the list created above
				list_date.add(DateApp.DateApp_input(line));
				// Read next line
				line = reader.readLine();
			}
			// Close the file after task has completed 
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Return a list of dates later to be used
		return (list_date);

	}

	public static String printDates(String input_args){
		// Converting list that holds input file data to an array
		List<SimpleDate> list_date = DateAppTextFile_input(input_args);
		SimpleDate[] array_date = new SimpleDate[list_date.size()];
		for (int i = 0; i < list_date.size(); i++) {
			array_date[i] = list_date.get(i);
		}
		// Return the most frequent day from Assignment1
		return (Assignment1.mostFrequentDayOfWeek(array_date));
	}


    public static void main(String[] args) {
		// args[0] used for command line input
        System.out.println(printDates(args[0]));
    }


}
