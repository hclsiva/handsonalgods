package codility;

import javax.swing.*;
import java.util.List;

public class DisappearingPairs {
    public String solution(String S){
        StringBuffer sb = new StringBuffer();
        for(char c : S.toCharArray()){
            int size = sb.length();
            if(size > 0 && sb.charAt(size-1) == c){
                sb.deleteCharAt(size-1);
            }   else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DisappearingPairs disappearingPairs = new DisappearingPairs();
        System.out.println(disappearingPairs.solution("ACCAABBC"));
        System.out.println(disappearingPairs.solution("ABCBBCBA"));
    }
}
