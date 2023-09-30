package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseTheWords {
    public static String reverseWords(String s) {
        if(s == null){
            return null;
        }
        s = s.trim();
        String[] words = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for(int i = words.length-1; i >=0; i--){
            if(!words[i].equals("") && !words[i].equals(" ") && !words[i].equals("\t")){
                buffer.append(words[i].trim());
                buffer.append(" ");
            }
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(ReverseTheWords.reverseWords("a good   example"));
    }
}
