package org.example;

import lombok.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Data

public class Friend {
    private String name;
    private int yearOfBirth;
    private int monthOfBirth;
    private int dayOfBirth;
    private final ZonedDateTime birthday;


    public Friend(String name, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;

        // Set up a LocalDate using the attributes initialized prior to this
        LocalDate birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);

        // Convert the LocalDate object into a ZonedDateTime by adding the (default / universal) timezone "UTC"
        this.birthday = ZonedDateTime.of(birthDate.atStartOfDay(), ZoneId.of("UTC"));
    }

    public long calculateDaysUntilNextBirthday() {
        // Check the current ZonedDateTime for right now
        ZonedDateTime now = ZonedDateTime.now();
        /*
            Now, use the birthday that was initialized,
            set its original year to the current one,
            and save it as this year's supposed bday:
         */
            ZonedDateTime supposedNextBirthday = birthday.withYear(now.getYear());

        // Check if the resulting birthday has already taken place within the current year (or even is today):
        if (supposedNextBirthday.isBefore(now) || supposedNextBirthday.isEqual(now)) {
            // ... if so, add another year on top of the supposedNextBirthday
            supposedNextBirthday = supposedNextBirthday.plusYears(1);
        }

        // Based on that, calculate the resulting time difference in days
        // (no matter if regularly within this year, or next year)
        return ChronoUnit.DAYS.between(now, supposedNextBirthday);
    }
}
