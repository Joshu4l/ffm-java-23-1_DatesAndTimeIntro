package org.example;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        // Create a LocalDateTime representing right now
        LocalDateTime rightNow = LocalDateTime.now();
        System.out.println(rightNow);

        // Create a LocalDateTime representing right now in 2 weeks
        LocalDateTime rightNowIn2Weeks = rightNow.plusWeeks(2);
        System.out.println(rightNowIn2Weeks);

        // Use the .isBefore() method to compare the actuality of 2 LocalDateTime objects
        boolean isBefore = rightNow.isBefore(rightNowIn2Weeks);
        System.out.println(isBefore);

        // Use the .isBefore() method to compare the actuality of 2 LocalDateTime objects
        boolean isAfter = rightNow.isAfter(rightNowIn2Weeks);
        System.out.println(isAfter);

        // Calculate the time difference (in days) between to LocalDateTime objects
        long myTimeDifference =  ChronoUnit.DAYS.between(rightNow, rightNowIn2Weeks);
        System.out.println(myTimeDifference);


        System.out.println("----\n");


        // Instantiate a Friend object ...
        Friend myFriend = new Friend("Mishka", 1995, 12, 28);
        // And print based on its toString method
        System.out.println(myFriend);

        // Invoke its method to calculate the days until its next bday
        System.out.println(myFriend.calculateDaysUntilNextBirthday());


    }
}