package com.gansuer.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.log4j.Logger;

/**
 * Created by Frank on 7/28/15.
 */
public class PinyinConverter {

    protected final Logger logger = Logger.getLogger(this.getClass());

    private static PinyinConverter pinyinConverter = new PinyinConverter();

    /**
     * @param chinese
     * @param type    0:全拼 1:首字母
     * @return
     */
    public static String[] chinese2Pinyin(String chinese, int type) {
        if (chinese != null && !chinese.trim().equalsIgnoreCase("")) {
            char[] src = chinese.trim().toCharArray();

            HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
            hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

            String[][] temp = new String[chinese.length()][];
            for (int i = 0; i < src.length; i++) {
                char c = src[i];

                if (String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")) {
                    try {
                        temp[i] = PinyinHelper.toHanyuPinyinStringArray(c, hanyuPinyinOutputFormat);
                        if (type == 1) {
                            temp[i] = firstLetter(temp[i]);
                        }
                    } catch (BadHanyuPinyinOutputFormatCombination e) {
                        pinyinConverter.logger.error(e);
                        temp[i] = new String[]{""};
                    }
                } else if (((int) c >= 65 && (int) c <= 90) || ((int) c >= 97 && (int) c <= 122)) {
                    temp[i] = new String[]{String.valueOf(c)};
                } else {
                    temp[i] = new String[]{""};
                }
            }

            return exchange(temp);
        }
        return null;
    }

    private static String[] firstLetter(String[] arr) {
        String[] res = null;
        if (arr != null) {
            res = new String[arr.length];
            for (int i = 0; i < arr.length; i++) {
                res[i] = String.valueOf(arr[i].charAt(0));
            }
        }
        return res;
    }

    private static String[] exchange(String[][] temp) {
        String[][] res = doExchange(temp);

        return res[0];
    }

    private static String[][] doExchange(String[][] arr) {
        int len = arr.length;
        if (len >= 2) {
            int len1 = arr[0].length;
            int len2 = arr[1].length;
            int newLen = len1 * len2;
            String[] temp = new String[newLen];
            int index = 0;
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    temp[index] = arr[0][i] + arr[1][j];
                    index++;
                }
            }
            String[][] newArray = new String[len - 1][];
            for (int i = 2; i < len; i++) {
                newArray[i - 1] = arr[i];
            }
            newArray[0] = temp;
            return doExchange(newArray);
        }
        return arr;
    }
}
