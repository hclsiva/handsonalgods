package leetcode.cheatsheet;

public class ReverseAStringExcludeSpaces {

    public String reverseWords(String s) {
        System.out.println(s);
        if( s == null || s.isBlank() || s.isEmpty()){
            return s;
        }
        String[] words = s.split(" ");
        int j = words.length-1;
        StringBuffer buffer = new StringBuffer();
        while(j >= 0 ){
            if(words[j].isBlank() || words[j].isEmpty() ){
                j--;
                continue;
            }
            buffer.append(words[j]).append(" ");
            j--;
        }
        return buffer.toString().trim();
    }
    public static void main(String[] args) {
        ReverseAStringExcludeSpaces r = new ReverseAStringExcludeSpaces();
        System.out.println(r.reverseWords("the sky is blue"));
        System.out.println(r.reverseWords("  hello world  "));
        System.out.println(r.reverseWords("a good   example"));
    }
}
