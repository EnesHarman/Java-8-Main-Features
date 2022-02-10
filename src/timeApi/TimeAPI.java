package timeApi;

import javax.swing.text.DateFormatter;
import java.time.*;

public class TimeAPI {
    /*There are 2 main classes under time API
    local : Simple date
    Zoned : Time zone requeired and more complex*/
    public static void main(String[] args) {

        //--Local--
        //---LocalDate---
        LocalDate localDate = LocalDate.now(); // returns date in (yyyy-mm-dd) format
        System.out.println("The current local date is: " +localDate);

        LocalDate birthDate = LocalDate.of(2000,1,15); //LocalDate.of or LocalDate.parse can use to parse a date to a localdate variable
        System.out.println("The variable type of parsed date is: "+ birthDate.getClass());

        LocalDate editedLocalDate = LocalDate.now()
                .withYear(2001)
                .withMonth(8)
                .withDayOfMonth(15);
        System.out.println("Edited LocalDate is: "+ editedLocalDate);

        LocalDate editedLocalDate2 = editedLocalDate
                .plusYears(1)
                .plusMonths(2)
                .plusDays(12);
        System.out.println("Edited LocalDate2 is: "+ editedLocalDate2);
        //LocalDate has many useful functions like .getDayOfMount() and atStartOfDay(). You can check them all from LocalDate class.
        System.out.println("----------------------------------");


        //---LocalTime---
        LocalTime localTime = LocalTime.now();//returns time in (hh:mm:ss) format
        System.out.println("The time without date is now : "+ localTime);

        LocalTime maxLocalTime = LocalTime.MAX; // It gives 23:59:59.999999999
        System.out.println("The MAX localtime is : "+ maxLocalTime);

        LocalTime wakeUpTime = LocalTime.of(9,30); //LocalTime.of or LocalTime.parse can use to parse a time to a localtime variable
        System.out.println("The variable type of parsed time is: "+wakeUpTime.getClass());

        System.out.println("----------------------------------");


        //---LocalDateTime---
        LocalDateTime localDateTime = LocalDateTime.now(); //It returns combination of LocalTime and LocalDate
        System.out.println("The current local date time is : "+localDateTime);

        LocalDateTime parsedLocalDateTime = LocalDateTime.parse("2020-02-10T12:07:00"); // LocalDateTime can parse given string to a variable too
        System.out.println("The variable type of parsed date time is: "+ parsedLocalDateTime);

        //LocalDateTime also let use many useful methods like .plusDate(), getMonth() etc. You can check them from class file.
        System.out.println("----------------------------------");

        //--Zoned--
        //We can use ZonedDateTime API when we need to specify time zone. To do this, we need to create a ZoneId object
        ZoneId zoneId = ZoneId.of("Asia/Tokyo");// You can get all available zoneIds with .getAvailableZoneIds() method.
        System.out.println("Tokyo' s ZoneId is : "+zoneId);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,zoneId); //LocalDateTime can convert to ZoneDateTime with zoneId object
        System.out.println("Converted zone date time is: "+ zonedDateTime);

        //Also .parse() and .of() methods can be used with ZonedDateTime to get variable.
    }
}
