import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.print.attribute.standard.DateTimeAtProcessing;
import java.util.ArrayList;
import java.util.Arrays;


public class DateApp {
    public static SimpleDate DateApp_input(String input) {
        // Appropriate formats below for dates
        String inputDate = input;
        Date date = null;
        SimpleDateFormat[] formats = {
                new SimpleDateFormat("d'st' MMMM yyyy"),
                new SimpleDateFormat("d'nd' MMMM yyyy"),
                new SimpleDateFormat("d'rd' MMMM yyyy"),
                new SimpleDateFormat("d'th' MMMM yyyy"),
                new SimpleDateFormat("dd/MM/yyyy"),
                new SimpleDateFormat("dd-MM-yyyy")
        };
        // Exception handling for correct date format
        for (SimpleDateFormat format : formats) {
            try {
                date = format.parse(inputDate);
                break;
            } catch (ParseException e) {
                // Try the next format
            }
        }
        // Error message if an invalid format entered
        if (date == null) {
            System.out.println("Invalid date format. Please check the specification again.");
            return null;
        }
        // Convertion of SimpleDateFormat to SimpleDate class defined.
        SimpleDateFormat outputDateSimpleDate_day = new SimpleDateFormat("dd");
        SimpleDateFormat outputDateSimpleDate_month = new SimpleDateFormat("MM");
        SimpleDateFormat outputDateSimpleDate_year = new SimpleDateFormat("yyyy");
        // Covert each part to a string value first
        String stringDay = outputDateSimpleDate_day.format(date);
        String stringMonth = outputDateSimpleDate_month.format(date);
        String stringYear = outputDateSimpleDate_year.format(date);
        // Cast the Strings into integer to allow SimpleDate to work
        SimpleDate date1 = new SimpleDate(Integer.parseInt(stringYear),  Integer.parseInt(stringMonth), Integer.parseInt(stringDay));
        // Return the date
        return date1;
    }




    public static void main(String[] args) {
        // Basic check if user has entered more than or less than one value
        if (args.length > 1) {
            System.out.println("You have entered more than one date. Please try again.");
            return;
        } else if (args.length < 1) {
            System.out.println("You haven't given an input date. Please try again.");
            return;
        }
        // args[0] used for command line input
        System.out.println(DateApp_input(args[0]));
    }
}