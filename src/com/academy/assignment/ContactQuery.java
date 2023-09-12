package com.academy.assignment;

import java.nio.channels.SelectableChannel;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class ContactQuery {

    static final String DB_URL = "jdbc:sqlserver://;servername=ISW-211201-256;database=Training1;instanceName=SQLEXPRESS;encrypt=false;integratedSecurity=true";

    static final String INSERT_QUERY =
            "INSERT INTO Contacts (FirstName,LastName,PhoneNumber," +
                    "Sex,DateOfBirth) VALUES (?,?,?,?,?)";

    static final String SQL = "Select TOP 1 ContactID from Contacts order by ContactID DESC";

    public static int createQuery(Contact contact) {

        int contactID;
        int addressID;
        int refereeAddressID;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Scanner scanInput = new Scanner(System.in);
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY);
             PreparedStatement statement = conn.prepareStatement(SQL))

        {

            // Execute a query
            stmt.setString(1, contact.getFirstName());
            stmt.setString(2, contact.getLastName());
            stmt.setString(3, contact.getPhoneNumber());
            stmt.setString(4, contact.getSex());
            stmt.setDate(5, Contact.formatDate(contact.getDateOfBirth()));
            int result = stmt.executeUpdate();
            if (result == 1) System.out.println(result + " product added successfully.");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                contactID =  rs.getInt("ContactID");
                System.out.println("ID: " + contactID);
                //return contactID;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    }



