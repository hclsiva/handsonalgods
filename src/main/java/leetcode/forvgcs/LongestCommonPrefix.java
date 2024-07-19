package leetcode.forvgcs;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("Longest Common Prefix = " +longestCommonPrefix(new String[]{"flower", "flow"}));
    }
    private static String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder("");
        String shortString = Arrays.stream(strs).min((o1, o2) -> (o1.length() -o2.length())).get();
        int shortestStringLength = shortString.length();
        System.out.println(shortString);
        for (int i = 0; i < shortestStringLength; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if(str.charAt(i) != c) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(c);
        }
        return commonPrefix.toString();
    }
}
