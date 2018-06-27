package ru.kulikovman.exchangerates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DataHelper {

    public static String convertLongToDateForList(long date) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);

        return dateFormat.format(calendar.getTime());
    }

    public static String convertLongToDateForApi(long date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);

        return "XML_daily.asp?date_req=" + dateFormat.format(calendar.getTime());
    }
}
