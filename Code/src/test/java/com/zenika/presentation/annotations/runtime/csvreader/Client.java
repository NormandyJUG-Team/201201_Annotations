package com.zenika.presentation.annotations.runtime.csvreader;

/**
 * @author Olivier Croisier
 * @version $Id: Client.java 1924 2010-12-14 16:05:55Z OlivierCroisier $
 */
public class Client {

    @CSVField(position = 1)
    private String id;

    @CSVField(position = 2)
    private String firstName;

    @CSVField(position = 3)
    private String lastName;

    @CSVField(position = 4)
    private String phone;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
