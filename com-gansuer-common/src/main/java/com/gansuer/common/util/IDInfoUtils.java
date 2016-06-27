package com.gansuer.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 身份证相关处理
 * Created by Frank on 6/27/2016.
 */
public class IDInfoUtils {

    private static final String[] CODE = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
    private static final int[] WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     *
     * @param ID
     * @param areaCode, 6 位地區碼
     * @return
     */
    public static boolean isValidatedID(String ID, String areaCode) {
        validateEmptyString(ID, "ID");
        validateEmptyString(areaCode, "AreaCode");
        int len = ID.length();
        if (len != 15 && len != 18)
            throw new IllegalArgumentException("ID is illegal : " + ID);
        if (!validateAreaCode(areaCode))
            throw new IllegalArgumentException("AreaCode is illegal : " + areaCode);
        if (!ID.startsWith(areaCode))
            throw new IllegalStateException("this ID doesn't belong to the area specified by the AreaCode : ID :" + ID + ", AreaCode :" + areaCode);
        return len == 15 ? is15(ID) : is18(ID);
    }

    /**
     * @param ID
     * @return
     */
    public static Date getBirthDay(String ID) throws ParseException {
        validateEmptyString(ID,"ID");
        if (ID.length() == 15) {
            if (is15(ID)) return validateBirthday("19" + ID.substring(6, 12));
        } else if (ID.length() == 18) {
            if (is18(ID)) return validateBirthday(ID.substring(6, 14));
        }
        throw new IllegalArgumentException("this is not a validated ID number: " + ID);

    }

    private static boolean validateAreaCode(String areaCode) {
        return Pattern.compile("^[0-9]{6}$").matcher(areaCode).matches();
    }

    private static boolean is15(String ID) {
        Pattern pattern = Pattern.compile("^[0-9]{15}$");
        return pattern.matcher(ID).matches();
    }

    private static boolean is18(String ID) {
        Pattern pattern = Pattern.compile("^[0-9]{17}[0-9|X]$");
        if (pattern.matcher(ID).matches()) {
            int sum = 0;
            for (int i = 0; i < 17; i++) {
                sum += Integer.parseInt(String.valueOf(ID.charAt(i))) * WEIGHT[i];
            }
            return CODE[sum % CODE.length].equals(String.valueOf(ID.charAt(17)));
        }
        return false;
    }

    private static void validateEmptyString(String input, String name) {
        if (StringUtils.isEmpty(input))
            throw new IllegalArgumentException("String is empty : " + name);
    }

    private static Date validateBirthday(String birthday) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse(birthday);
    }
}
