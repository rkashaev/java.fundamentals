package courses.lesson12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {
    public static void main(String[] args) {
        Date date = new Date(); // Represents present moment

        Date date1 = new Date(0); // Jan 01 03:00:00 MSK 1970

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date2 = null;
        try {
            date2 = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2); //Tue Aug 31 10:20:56 SGT 1982
    }
}
