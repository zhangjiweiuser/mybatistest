package com.zhang.mybatis.tdd;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName TDDTest
 * @Author zhangjiwei
 * @Date 2019/8/5 10:48
 * @Description
 */
public class TDDTest {

    private final static double VOWEL_PERCENT = 0.3;
    private final static String REPLACE_CONSTANT = "mommy";

    @Test
    public void test() {
        String inputStr = "h";
        String result = tddTest(inputStr);
        assertEquals("h", result);
    }

    @Test
    public void testVowel() {
        String inputStr = "a";
        String result = tddTest(inputStr);
        assertEquals("mommy", result);
    }

    @Test
    public void testVowelMore30PercentInStr() {
        String inputStr = "ab";
        String result = tddTest(inputStr);
        assertEquals("mommyb", result);
    }

    @Test
    public void testContinuousVowelMore30PercentInStr() {
        String inputStr = "fjdsooewqe";
        String result = tddTest(inputStr);
        assertEquals("fjdsmommywqmommy", result);
    }

    @Test
    public void testContinuousVowelMore30PercentInStr2() {
        String inputStr = "aff";
        String result = tddTest(inputStr);
        assertEquals("mommyff", result);
    }
    @Test
    public void testContinuousVowelMore30PercentInStr3() {
        String inputStr = "aoff";
        String result = tddTest(inputStr);
        assertEquals("mommyff", result);
    }

    @Test
    public void testContinuousVowelMore30PercentInStr4() {
        String inputStr = "a";
        String result = tddTest(inputStr);
        assertEquals("mommy", result);
    }
    public String tddTest(String inputStr) {
        char[] charArray = inputStr.toCharArray();
        int sum = 0;
        String vowelStr = "aeiou";
        String str = "";
        if (inputStr.length() == 1){
            if (validVowelIsExist(vowelStr, charArray[0])) {
                return REPLACE_CONSTANT;
            } else {
                return inputStr;
            }
        }else if (inputStr.length() > 1) {
            sum = getVowelCountInStr(charArray, sum, vowelStr);
            boolean flag = judgeVowelPercentInStr(charArray, sum);
            if (flag) {
                str = replaceVowelWithConstant(charArray, vowelStr, str);
            } else {
                return inputStr;
            }
            return str;
        } else {
            return null;
        }
    }

    private static boolean validVowelIsExist(String vowelStr, char c) {
        return vowelStr.indexOf(c) >= 0;
    }

    private int getVowelCountInStr(char[] charArray, int sum, String vowelStr) {
        for (char c : charArray) {
            if (validVowelIsExist(vowelStr, c)) {
                sum++;
            }
        }
        return sum;
    }

    private static String replaceVowelWithConstant(char[] charArray, String vowelStr, String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        for (int i = 0; i < charArray.length; i++) {
            if (validVowelIsExist(vowelStr, charArray[i])) {
                if (i == 0) {
//                    if (!validVowelIsExist(vowelStr, charArray[i + 1])) {
                        strBuilder.append(REPLACE_CONSTANT);
//                    }
                } else {
                    if (!validVowelIsExist(vowelStr, charArray[i - 1])) {
                        strBuilder.append(REPLACE_CONSTANT);
                    }
                }
            } else {
                strBuilder.append(charArray[i]);
            }
        }

        str = strBuilder.toString();
        return str;
    }

    private static boolean judgeVowelPercentInStr(char[] charArray, int sum) {
        return (float) sum / (float) charArray.length >= VOWEL_PERCENT;
    }
}
