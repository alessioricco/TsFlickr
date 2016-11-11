package it.alessioricco.tsflickr.utils;

/**
 * String utility collection
 */
public class StringUtils {

    public static boolean isNullOrEmpty(final String s) {
        return (s == null) || (s.length() == 0);
    }

    /**
     * transform a date in format
     * 2016-11-09T17:14:36-08:00
     * yyyy-MM-dd'T'HH:mm:ss-XXX
     * in another format
     * @param date
     * @return
     */
    public static String trasformDate(final String date) {
        // todo: must be implemented
        return date;
    }
}
