package leetcode.cheatsheet;

public class StringReverseWithOnlyAlphabets {

    private boolean isLetter(char c){

        return ((c >= 'a' && c <= 'z') || (c >='A' && c <= 'Z'));
    }
    public String reverseOnlyLetters(String s){
        if(s == null)
            return s;
        char[] a = s.toCharArray();
        int i = 0, j = a.length-1;
        while(i < j){
            if(!isLetter(a[i])){
                i++;
            }
            if(!isLetter(a[j])){
                j--;
            }
            if(isLetter(a[i]) && isLetter(a[j])) {
                char t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }
        return  new String(a);
    }
    public static void main(String[] args) {
        StringReverseWithOnlyAlphabets r = new StringReverseWithOnlyAlphabets();
        System.out.println(r.reverseOnlyLetters("ab-cd"));
        System.out.println(r.reverseOnlyLetters("a-bC-dEf=ghlj!!"));
    }
}
