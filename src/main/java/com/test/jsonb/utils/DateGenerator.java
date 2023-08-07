package com.test.jsonb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateGenerator {

    private static final String MIN_DATE_STR = "2023-01-01";
    private static final String MAX_DATE_STR = "2023-07-30";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date generateRandomStartDate() throws ParseException {
        Date minDate = dateFormat.parse(MIN_DATE_STR);
        Date maxDate = dateFormat.parse(MAX_DATE_STR);
        long randomTime = minDate.getTime() + (long) (Math.random() * (maxDate.getTime() - minDate.getTime()));
        return new Date(randomTime);
    }

    public static Date generateRandomEndDate(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DATE, (int) (Math.random() * 7)); // Add 0 to 6 days
        Date endDate = calendar.getTime();

        // Ensure that endDate is not greater than maxDate
        try {
            Date maxDate = dateFormat.parse(MAX_DATE_STR);
            if (endDate.after(maxDate)) {
                endDate = maxDate;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return endDate;
    }
}
