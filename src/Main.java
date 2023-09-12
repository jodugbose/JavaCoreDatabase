import com.academy.assignment.Contact;
import com.academy.assignment.ContactQuery;
import com.academy.assignment.DatabasePractice;
import com.microsoft.sqlserver.jdbc.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    private static Scanner scanInput;
   // static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMMM, yyyy");

    public static LocalDate getDateFromString(String dateString) {
        // Converting the string to date
        // in the specified format
        var formatBuilder = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .parseLenient()
                .appendPattern("d MMMM yyyy")
                .appendPattern("dd MMMM yyyy")
                .appendPattern("d MMM yyyy")
                .appendPattern("dd MMM yyyy")
                .appendPattern("dd-MMMM-yyyy");
        var format = formatBuilder.toFormatter(Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, format);

        // Returning the converted date
        return date;
    }

    public static void main(String[] args) {

        String FirstName;
        String LastName;
        String PhoneNumber;
        String Sex;
        String DateOfBirth;
        LocalDate formattedDateOfBirth;


        Scanner scanInput = new Scanner(System.in);

        System.out.println("Welcome to Contacts details");
        System.out.println("Please enter 1 to continue or 0 to exit");
        int answer = scanInput.nextInt();


        while (true) {

            System.out.println("Enter your firstname:");
            FirstName = scanInput.next();

            System.out.println("Enter your lastname:");
            LastName = scanInput.next();

            System.out.println("Enter your Phone Number:");
            PhoneNumber = scanInput.next();

            System.out.println("Enter your sex:");
            Sex = scanInput.next();

            System.out.println("Enter your date of birth:");
            DateOfBirth = scanInput.next();

            //  Date formattedDateOfBirth = new SimpleDateFormat(format).parse(DateOfBirth);
            formattedDateOfBirth = getDateFromString(DateOfBirth);
            System.out.println("Do you wish to enter another record");
            answer = scanInput.nextInt();
            if (answer == 0) {
                break;
            }


        }
        Contact contact = new Contact(FirstName, LastName, PhoneNumber, Sex, formattedDateOfBirth );
        ContactQuery.createQuery(contact);


    }
}