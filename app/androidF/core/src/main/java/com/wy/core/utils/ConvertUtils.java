package com.wy.core.utils;


import java.text.SimpleDateFormat;
import java.util.Date;


public class ConvertUtils {

    private static final int ERRORVALUE = 0;

    public static double covertDouble(String content) {
        try {
            return Double.parseDouble(content);
        } catch (NullPointerException e) {
            return ERRORVALUE;
        } catch (NumberFormatException e) {
            return ERRORVALUE;
        }
    }

    public static float covertFloat(String content) {
        try {
            return Float.parseFloat(content);
        } catch (NullPointerException e) {
            return ERRORVALUE;
        } catch (NumberFormatException e) {
            return ERRORVALUE;
        }
    }

    public static int covertInteger(String content) {
        try {
            return Integer.parseInt(content);
        } catch (NullPointerException e) {
            return ERRORVALUE;
        } catch (NumberFormatException e) {
            return ERRORVALUE;
        }
    }

    public static long covertLong(String content) {
        try {
            return Long.parseLong(content);
        } catch (NullPointerException e) {
            return ERRORVALUE;
        } catch (NumberFormatException e) {
            return ERRORVALUE;
        }
    }

    public static Date covertDate(String validity, String formate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(formate);
            Date data = format.parse(validity);
            return data;
        } catch (Exception e) {
            Date data = new Date();
            return data;
        }
    }

    public static Date covertDate(long validity) {
        try {
            Date data = new Date(validity);
            return data;
        } catch (Exception e) {
            Date data = new Date();
            return data;
        }
    }

    public static String covertDateString(Date date, String formate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formate);
            String str = sdf.format(date);
            return str;
        } catch (Exception e) {
            return "";
        }
    }
    public static String covertDateString(long time, String formate) {
        try {
            Date date=new Date(time);
            SimpleDateFormat formatter=new SimpleDateFormat(formate);

            return  formatter.format(date);
        } catch (Exception e) {
            return "";
        }
    }
    public static long covertDateTime(String date, String formate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formate);
            Date d = sdf.parse(date);
            return d.getTime();

        } catch (Exception e) {
            return 0;
        }
    }
}