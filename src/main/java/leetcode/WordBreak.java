package leetcode;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(0,s,wordDict);
    }
    private boolean wordBreak(int i, String s, List<String> wordDict) {
        if(i >= s.length()){
            return true;
        }
        for(int j = i ; j <= s.length();j++){
            String temp = s.substring(i,j);

            if(wordDict.contains(temp)){
                if(wordBreak(j+1,s,wordDict)){
                    return true;
                }   else{
                    break;
                }

            }
        }
        return false;
    }
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        boolean check = wb.wordBreak("aaaaaaa", List.of("aaaa","aaa"));
        System.out.println(check);
        check = wb.wordBreak("leetcode", List.of("leet","code"));
        System.out.println(check);

        /*
        check = wb.wordBreak("applepenapple", List.of("apple","pen"));
        System.out.println(check);
        check = wb.wordBreak("catsandog", List.of("cats","dog","sand","and","cat"));
        System.out.println(check);

         */
    }
}
