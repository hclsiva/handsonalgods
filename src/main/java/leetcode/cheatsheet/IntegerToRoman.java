package leetcode.cheatsheet;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (num > 0) {
            if (num >= values[i]) {
                sb.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        IntegerToRoman i = new IntegerToRoman();
        System.out.println(i.intToRoman(1892));
    }
}
