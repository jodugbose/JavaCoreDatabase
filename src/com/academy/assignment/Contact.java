package com.academy.assignment;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Contact {

     private String FirstName;
    private String LastName;

     private String PhoneNumber;


    private String Sex;
    private LocalDate DateOfBirth;

    @Override
    public String toString() {
        return "Contact{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Sex='" + Sex + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                '}';
    }

    public Contact(String firstName, String lastName, String phoneNumber, String sex, LocalDate dateOfBirth) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.PhoneNumber = phoneNumber;
        this.Sex = sex;
        this.DateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getSex() {
        return Sex;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public static Date formatDate(LocalDate date){
        return Date.valueOf(date);
    }

}
