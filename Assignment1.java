import java.util.Date;
import java.util.Arrays;



public class Assignment1 {

    /*
     * A method to find the day-of-week for a date.
     *
     * Arguments:
     * `date` -- the SimpleDate for which the day-of-week is to be found.
     *
     * Return value:
     * A String representing the day of week. The day of week should be
     * expressed as a three-letter abbreviation; in other words, this method
     * returns one of:
     *   "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
     */
    public static String dayOfWeek( SimpleDate date ) {
        // Algorithm applied
        int m = date.getMonth();
        int d = date.getDay();
        int y = date.getYear();
        if (m < 3) {
            m = m + 12;
            y = y - 1;
        }
        int C = y % 100;
        int D = y / 100;
        int W = (13 * (m + 1)) / 5;
        int X = C / 4;
        int Y = D / 4;
        int Z = W + X + Y + d + C - 2 * D;
        int day = Z % 7;
        if (day < 0) {
            day = day + 7;
        }
        switch (day) {
            case 0:
                return "Sat";
            case 1:
                return "Sun";
            case 2:
                return "Mon";
            case 3:
                return "Tue";
            case 4:
                return "Wed";
            case 5:
                return "Thu";
            case 6: 
                return "Fri";
            default:
                return "Invalid day";
        }
    }

    /*
     * Given a set of dates, this method will count the number of dates in the
     * set that fall on a particular day-of-week.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     * `dayOfWeek` -- a String representing the day of week ("Mon" to "Sun")
     *
     * Return value:
     * An integer giving the number of dates that fell on `dayOfWeek`.
     */
    public static int countDatesOnDay( SimpleDate[] dates, String dayOfWeek ) {
        int count = 0;
        // Use count to count every occurance of the day and than return it.
        for (int i = 0; i < dates.length; i++) {
            if (dayOfWeek(dates[i]).equals(dayOfWeek)) {
                count = count + 1;
            }
        }
        return count;
    }

    /*
     * A method to find the most frequent day-of-week among a collection of
     * dates.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     *
     * Return value:
     * If the array `dates` is empty, then this method should return the null
     * reference. Otherwise, the method should return the three-letter
     * abbreviation ("Mon", "Tue", etc.) of the day-of-week that was most
     * frequent.
     * In the case that there is a tie for the most-frequent day-of-week,
     * priority should be given to the day-of-week that comes earliest in the
     * week. (For this method, "Mon" is assumed to be the first day of the
     * week.)
     * For example, if there were a tie between Tuesday, Wednesday, and Sunday,
     * the method should return "Tue".
     */
    public static String mostFrequentDayOfWeek( SimpleDate[] dates ) {
        // Make an array for frequency of days.
        int[] frequency_of_days = {0, 0, 0, 0, 0, 0, 0};
        // Use a loop to increment days if matched with dates array.
        for (int i = 0; i < dates.length; i++) {
            String day = dayOfWeek(dates[i]);
            switch (day) {
                case "Mon":
                    frequency_of_days[0] = frequency_of_days[0] + 1;
                    break;
                case "Tue":
                    frequency_of_days[1] = frequency_of_days[1] + 1;
                    break;
                case "Wed":
                    frequency_of_days[2] = frequency_of_days[2] + 1;
                    break;
                case "Thu":
                    frequency_of_days[3] = frequency_of_days[3] + 1;
                    break;
                case "Fri":
                    frequency_of_days[4] = frequency_of_days[4] + 1;
                    break;
                case "Sat":
                    frequency_of_days[5] = frequency_of_days[5] + 1;
                    break;
                case "Sun":
                    frequency_of_days[6] = frequency_of_days[6] + 1;
                    break;
         }
    }
    // Define a max value to find the highest value than use the max_value for storing the place corresponding with day.
    int max_value = 0;
    for (int i = 1; i < frequency_of_days.length; i++) {
        if (frequency_of_days[i] > frequency_of_days[max_value]) {
            max_value = i;
        }
    }
    // Use a switch case to return day.
    switch (max_value) {
        case 0:
            return "Mon";
        case 1:
            return "Tue";
        case 2:
            return "Wed";
        case 3:
            return "Thu";
        case 4:
            return "Fri";
        case 5:
            return "Sat";
        case 6:
            return "Sun";
        default:
            return "Not Found";
    }
}
    public static void main(String[] args) {
        //Testing part
        /*
        SimpleDate date = new SimpleDate(2023, 3, 01);
        SimpleDate date1 = new SimpleDate(2023, 3, 02);
        SimpleDate date2 = new SimpleDate(2023, 3, 03);
        SimpleDate date3 = new SimpleDate(2023, 3, 03);
        SimpleDate[] dates_list = {date3, date2, date1, date};
        System.out.println(dayOfWeek(date));
        System.out.println(countDatesOnDay(dates_list, "Sun"));
        System.out.println(mostFrequentDayOfWeek(dates_list));
        */
    }
}

