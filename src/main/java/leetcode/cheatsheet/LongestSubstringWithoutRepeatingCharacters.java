package leetcode.cheatsheet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int maxLength = 0;
        StringBuffer b = new StringBuffer();
        int i = 0, j = i;
        while(i < s.length()){
            b.append(s.charAt(j++));
            if( j > s.length()-1 || (j <= s.length()-1 && b.indexOf(String.valueOf(s.charAt(j))) >=0)  ){
                maxLength = Math.max(b.length(),maxLength);
                b.setLength(0);
                i++;
                j = i;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }
}
