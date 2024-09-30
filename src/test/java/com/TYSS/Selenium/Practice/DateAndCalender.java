package com.TYSS.Selenium.Practice;

import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateAndCalender {

    @Test
    public void dateAndCalenderOne() {
        String date = LocalDateTime.now().toString();
        System.out.println(date);
    }
}
