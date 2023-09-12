

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
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


    public class NewMain {
        private static Scanner scanInput;

        public static LocalDate getDateFromString(String dateString) {
            // Converting the string to date
            // in the specified format
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            try {
                return LocalDate.parse(dateString, format);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date: " + dateString);
                return null;
            }
        }

        public static void main(String[] args) {

            String firstName;
            String lastName;
            String phoneNumber;
            String sex;
            String dateOfBirth;
            LocalDate formattedDateOfBirth;


            Scanner scanInput = new Scanner(System.in);

            System.out.println("Welcome to Contacts details");
            System.out.println("Please enter 1 to continue or 0 to exit");
            int answer = scanInput.nextInt();


            while (true) {

                System.out.println("Enter your firstname:");
                firstName = scanInput.next();

                System.out.println("Enter your lastname:");
                lastName = scanInput.next();

                System.out.println("Enter your Phone Number:");
                phoneNumber = scanInput.next();

                System.out.println("Enter your sex:");
                sex = scanInput.next();

                System.out.println("Enter your date of birth. Follow this format [01-12-1970]:");
                dateOfBirth = scanInput.next();

                //  Date formattedDateOfBirth = new SimpleDateFormat(format).parse(DateOfBirth);
                formattedDateOfBirth = getDateFromString(dateOfBirth);

                System.out.println("Do you wish to enter another record");
                answer = scanInput.nextInt();

                if (answer == 0) {
                    break;
                }


            }
            Contact contact = new Contact(firstName, lastName, phoneNumber, sex, formattedDateOfBirth );
            int newContactId = ContactQuery.createQuery(contact);
            System.out.println("Newly saved contact ID is " + newContactId);

        }

    }