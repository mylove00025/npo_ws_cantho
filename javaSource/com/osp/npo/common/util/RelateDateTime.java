package com.osp.npo.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * <p>RelateDateTime</p>
 * 
 * @version $Revision: 20361 $
 * <BR>
 */
public class RelateDateTime {


    public static final String EMC_IS_NUMBER = "0123456789";


    public static final int[] baseStartDay = {2000, 1, 1, 0, 0, 0};


    public static final int[] baseEndDay = {2037, 12, 31, 23, 59, 59};


    public static final int ID_YEAR = 0;


    public static final int ID_MONTH = 1;


    public static final int ID_DAY = 2;


    public static final int ID_HOUR = 3;


    public static final int ID_MIN = 4;


    public static final int ID_SEC = 5;


    public static final String YYYYMMDDHHMISS = "yyyy-MM-dd-HH-mm-ss";


    public static final String YYYYMMDDHHMI = "yyyy/MM/dd HH:mm";
    
    public static final String DDMMYYYY = "dd/MM/yyyy";    


    public static Timestamp getTimeNow() {
        Calendar rightNow = Calendar.getInstance();
        Timestamp tmsp = new Timestamp(rightNow.getTimeInMillis());

        return tmsp;
    }



    public static Timestamp getTimeNowAddDay(int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);
        Timestamp tmsp = new Timestamp(cal.getTimeInMillis());

        return tmsp;
    }



    public static String formatDate(String format, Timestamp date) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date.getTime());
    }

    public static Timestamp toTimestamp(boolean fromDateFlg, String txtShortTime) {
        String regex = "/";
        if (txtShortTime != null) {
            String timeSpilit[] = txtShortTime.split(regex);
            if (timeSpilit.length == 3 
                    && EditString.isNumber(timeSpilit[0]) 
                    && timeSpilit[0].length() <= 2
                    && EditString.isNumber(timeSpilit[1])
                    && timeSpilit[1].length() <= 2
                    && EditString.isNumber(timeSpilit[2])
                    && timeSpilit[2].length() <= 4) {
                Timestamp value = toTimestamp(fromDateFlg, timeSpilit[2], timeSpilit[1], timeSpilit[0], null, null, null);
                return value;
            }
        }
        return null;
    }

    public static Timestamp toTimestamp(boolean fromDateFlg, String txtYear,
            String txtMonth, String txtDay, String txtHour, String txtMin,
            String txtSec) {

        int[] editBaseDate = editBaseDate(fromDateFlg, txtYear, txtMonth,
                txtDay, txtHour, txtMin, txtSec);

        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.set(editBaseDate[0], editBaseDate[1] - 1, editBaseDate[2],
                editBaseDate[3], editBaseDate[4], editBaseDate[5]);
        if (fromDateFlg) {
            cal.set(Calendar.MILLISECOND, 0);
        } else {
            cal.set(Calendar.MILLISECOND, 999);
        }

        Timestamp time;
        try {
            time = new Timestamp(cal.getTimeInMillis());
        } catch (IllegalArgumentException e) {
            return null;
        }
        return time;
    }



    public static int[] editBaseDate(boolean fromDateFlg, String txtYear,
            String txtMonth, String txtDay, String txtHour, String txtMin,
            String txtSec) {

        int[] date = new int[6];
        if (fromDateFlg) {
            date[0] = baseStartDay[0];
            date[1] = baseStartDay[1];
            date[2] = baseStartDay[2];
            date[3] = baseStartDay[3];
            date[4] = baseStartDay[4];
            date[5] = baseStartDay[5];
        } else {
            date[0] = baseEndDay[0];
            date[1] = baseEndDay[1];
            date[2] = baseEndDay[2];
            date[3] = baseEndDay[3];
            date[4] = baseEndDay[4];
            date[5] = baseEndDay[5];
        }

        try {
            if (txtYear == null || txtYear.equals("")) {

            } else if (txtMonth == null || txtMonth.equals("")) {
                date[0] = Integer.parseInt(txtYear);
            } else if (txtDay == null || txtDay.equals("")) {
                date[0] = Integer.parseInt(txtYear);
                date[1] = Integer.parseInt(txtMonth);
                if (!fromDateFlg) {
                    int lastDay = getLastDay(date[0], date[1]);
                    date[2] = lastDay;
                }
            } else if (txtHour == null || txtHour.equals("")) {
                date[0] = Integer.parseInt(txtYear);
                date[1] = Integer.parseInt(txtMonth);
                date[2] = Integer.parseInt(txtDay);
            } else if (txtMin == null || txtMin.equals("")) {
                date[0] = Integer.parseInt(txtYear);
                date[1] = Integer.parseInt(txtMonth);
                date[2] = Integer.parseInt(txtDay);
                date[3] = Integer.parseInt(txtHour);
            } else if (txtSec == null || txtSec.equals("")) {
                date[0] = Integer.parseInt(txtYear);
                date[1] = Integer.parseInt(txtMonth);
                date[2] = Integer.parseInt(txtDay);
                date[3] = Integer.parseInt(txtHour);
                date[4] = Integer.parseInt(txtMin);
            } else {
                date[0] = Integer.parseInt(txtYear);
                date[1] = Integer.parseInt(txtMonth);
                date[2] = Integer.parseInt(txtDay);
                date[3] = Integer.parseInt(txtHour);
                date[4] = Integer.parseInt(txtMin);
                date[5] = Integer.parseInt(txtSec);
            }

        } catch (NumberFormatException e) {
            return null;
        }

        return date;
    }



    public static int getLastDay(int year, int month) {

        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);

        int lastDay = cal.getActualMaximum(Calendar.DATE);
        return lastDay;
    }

    
    /**
     * Get date by first day of the year
     *
     * @author HungPT
     * @param date Date object
     * @return Date by first day of the year, if date param invalid then return null
     */
    public static String getDateByFirstDayOfYear(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calResult = Calendar.getInstance();
        calResult.setTime(date);
        calResult.set(Calendar.DAY_OF_YEAR, calResult.getActualMinimum(Calendar.DAY_OF_YEAR));
        return toDayMonthYear(calResult.getTime());
    }
    
    /**
     * Get date by last day of the year
     *
     * @author HungPT
     * @param date Date object
     * @return Date by last day of the year, if date param invalid then return null
     */
    public static String getDateByLastDayOfYear(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calResult = Calendar.getInstance();
        calResult.setTime(date);
        calResult.set(Calendar.DAY_OF_YEAR, calResult.getActualMaximum(Calendar.DAY_OF_YEAR));
        return toDayMonthYear(calResult.getTime());
    }
    
    /**
     * Get date by last day of the month
     *
     * @author HungPT
     * @param date Date object
     * @return Date by last day of the month, if date param invalid then return null
     */
    public static String getDateByLastDayOfMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calResult = Calendar.getInstance();
        calResult.setTime(date);
        calResult.set(Calendar.YEAR, calResult.get(Calendar.YEAR));
        calResult.set(Calendar.MONTH, calResult.get(Calendar.MONTH));
        calResult.set(Calendar.DAY_OF_MONTH, calResult.getActualMaximum(Calendar.DAY_OF_MONTH));
        return toDayMonthYear(calResult.getTime());
    }

    /**
     * Get date by first day of the month
     *
     * @author HungPT
     * @param date Date object
     * @return Date by first day of the month, if date param invalid then return null
     */
    public static String getDateByFirstDayOfMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calResult = Calendar.getInstance();
        calResult.setTime(date);
        calResult.set(Calendar.YEAR, calResult.get(Calendar.YEAR));
        calResult.set(Calendar.MONTH, calResult.get(Calendar.MONTH));
        calResult.set(Calendar.DAY_OF_MONTH, calResult.getActualMinimum(Calendar.DAY_OF_MONTH));        
        return toDayMonthYear(calResult.getTime());
    }
    
    /**
     * Get date by first day of the week
     *
     * @author HungPT
     * @param date Date object
     * @return Date by first day of the week, if date param invalid then return null
     */
    public static String getDateByFirstDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calResult = Calendar.getInstance();
        calResult.setTime(date);
        calResult.setFirstDayOfWeek(Calendar.MONDAY);
        calResult.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return toDayMonthYear(calResult.getTime());
    }
    
    /**
     * Get date by last day of the week
     *
     * @author HungPT
     * @param date Date object
     * @return Date by last day of the week, if date param invalid then return null
     */
    public static String getDateByLastDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calResult = Calendar.getInstance();
        calResult.setTime(date);
        calResult.setFirstDayOfWeek(Calendar.MONDAY);
        calResult.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return toDayMonthYear(calResult.getTime());
    }
    
    /**
     * Convert a string date with format ddMMyyy
     *
     * @author HungPT
     * @param date Date object
     * @return Date
     */
    public static Date toDateTime(String strDate) {
        DateFormat formatter = new SimpleDateFormat(DDMMYYYY); 
        Date date = null;
        try {
            date = (Date)formatter.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
        
        return date;
    }
    
    /**
     * format specified Date to '31/12/2010' template
     *
     * @author HungPT
     * @param date specified Date
     * @return String formated Date in String ('31/12/2010')
     */
    public static String toDayMonthYear(Date date) {
        String result = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DDMMYYYY);
            result = sdf.format(date);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }
}