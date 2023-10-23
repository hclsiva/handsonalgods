package codility.ericsson._06_oct_2023;

import java.util.ArrayList;
import java.util.List;

public class LongestSymmetricInString {
    public static List<String> generateCombinations(String input) {
        List<String> l = new ArrayList<>();
        char[] chars = input.toCharArray();
        generateCombinationsHelper(chars, 0, l);
        return l;
    }
    private static List<String> generateCombinationsHelper(char[] chars, int index, List<String> l) {
        if (index == chars.length) {
            l.add(new String(chars));

            return l;
        }
        if (chars[index] == '?') {
            chars[index] = '<';
            generateCombinationsHelper(chars, index + 1, l);
            chars[index] = '>';
            generateCombinationsHelper(chars, index + 1, l);
            chars[index] = '?'; // Reset the character back to '?' for backtracking
        } else {
            generateCombinationsHelper(chars, index + 1, l);
        }
        return l;
    }
    public static boolean isSymmetric(String str) {
        int j = str.length();
        if(j%2 != 0) return false;
        if(!str.startsWith("<")) return false;
        for(int i=0;i<str.length()/2;i++) {
            if(str.charAt(i) != '<') return false;
            if(str.charAt(str.length()-1-i) != '>') return false;
        }
        return true;
    }
    public int solution(String S) {
        // Implement your solution here
        int max = 0;
        List<String> l = generateCombinations(S);
                for(String li : l) {
            for(int i=0; i<li.length();i++){
                for(int j=i+1; j<li.length();j++){
                    if(isSymmetric(li.substring(i,j+1)) & max < li.substring(i,j+1).length()) {
                        max = li.substring(i,j+1).length();
                    }
                }
            }

        }
        return max;
    }
    public static void main(String[] args) {
          String input = "<><??>>";
        //   String input = "??????";
        //String input = "<<?";
        LongestSymmetricInString l = new LongestSymmetricInString();
        int max = l.solution(input);

        System.out.println(max);
    }

}
