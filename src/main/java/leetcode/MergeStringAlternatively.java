package leetcode;

public class MergeStringAlternatively {
    public static String mergeAlternately(String word1, String word2) {
        if(word1 == null && word2 == null ){
            return null;
        } else if (word1 == null){
            return word2;
        } else if(word2 == null){
            return word1;
        }
        StringBuffer buffer = new StringBuffer();
        int i =0;int j= 0;
        while (i < word1.length() || j < word2.length()){
            if(i < word1.length())
                buffer.append(word1.charAt(i++));
            if(j < word2.length())
                buffer.append(word2.charAt(j++));
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","pqr"));
        System.out.println(mergeAlternately("ab","pqrs"));
        System.out.println(mergeAlternately("abcd","pq"));

    }
}
