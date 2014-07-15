package com.osp.npo.common.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.osp.npo.common.global.Constants;

/**
 *
 * <P>
 * String util function
 * </P>
 *
 * @author Nguyen Thanh Hai
 * @version $Revision: 20436 $ <BR>
 */
public class EditString {

    private static final String DASH = "-";

    /**
     * <p>
     * Display double number
     * </p>
     *
     * @param value
     * @return double number
     */
    public static String doubleDisp(Double value) {
        if (value == null) {
            return "0.00";
        }
        return new DecimalFormat("#.00").format(value);
    }

    /**
     * Check char input is number
     *
     * @param c
     *            char
     * @return true: char is number. false: char not number
     */
    public static boolean isDigit(char c) {
        int x = (int) c;
        if ((x >= 48) && (x <= 57)) {
            return true;
        }
        return false;
    }

    /**
     * Check String is null
     *
     * @param str
     *            String
     * @return true String input is null or length = 0
     */
    public static boolean isNull(String str) {
        return (str == null || str.length() <= 0);
    }

    /**
     * Check String input is number
     *
     * @param number
     *            String
     * @return true: String input is number. false: String input is not number
     */
    public static boolean isNumber(String number) {
        if (isNull(number)) {
            return false;
        }
        char[] c = number.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!isDigit(c[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check String input is telephone or fax number
     *
     * @param number
     *            String
     * @return true: String input is number. false: String input is not number
     */
    public static boolean isTelephoneOrfax(String str) {
        if (isNull(str)) {
            return true;
        }
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!isDigit(c[i]) && !DASH.equals(c[i])) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Remove CR char for display in Excel file
     * 
     * @param str
     * @return
     */
    public static String removeCR(String str) {
        if (str == null) {
            return null;
        }

        String rtnStr = str.replaceAll("\r", "");

        return rtnStr;

    }
    
    /**
     * Convert unicode string to ASCII
     * 
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String convertUnicodeToASCII(String str) throws UnsupportedEncodingException {
       
        if (str == null) {
            return null;
        }
        
        String rs = str.replace('\u0111', 'd');
        rs = rs.replace('\u0110', 'D');
        rs = rs.replace('\u00D0', 'D');
        rs = rs.replace('\u0089', 'D');
        
        rs = Normalizer.normalize(rs, Normalizer.Form.NFKD);
        String regex = "[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+";
        
        rs = new String(rs.replaceAll(regex, "").getBytes("ascii"), "ascii");
        
        return rs;
    }
    
    public static String cutString(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if ("".equals(str.trim())) {
            return "";
        }
        String temp = str.trim().toUpperCase();
        temp = Constants.SPACE + temp;
        int i=0;
        String rs = ""; 
        while (i < temp.length()) {
            if((temp.charAt(i) == ' ') && (temp.charAt(i+1) != ' ')) {
                rs = rs + temp.charAt(i+1);
            }
            i++;
        }
        return rs;
    }
    
    /**
     * 
     * @return
     */
    public static String getDisp(String input, int count) {
        if (input.length() > count ) {
            int index = count;
            while (index < input.length() && input.charAt(index) != ' ') {
                index++;
            }
            String  titleReturn = (index == input.length()) ? input.substring(0, index) : input.substring(0, index) + " ... ";
            return titleReturn;
        }
        return input;
    }
    
    /**
     * Parse Data For Search
     * 
     * @param text
     * @return
     */
    public static String parseDataForSearch(String text) {
        String[] delimiters = {",", ";", "\\.", "-", "_", "\\?", "!", ":"};
        for (int i = 0; i < delimiters.length; i++) {
            text = text.replaceAll(delimiters[i], Constants.SPACE + delimiters[i] + Constants.SPACE);
        }
        
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(" ");
        
        return text;
    }
}