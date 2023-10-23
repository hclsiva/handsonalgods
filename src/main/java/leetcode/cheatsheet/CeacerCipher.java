package leetcode.cheatsheet;

import java.util.HashMap;
import java.util.Map;

public class CeacerCipher {
    static Map<Character, Integer> a = new HashMap<Character,Integer>();
    static{
        a.put('a',1);
        a.put('b',2);
        a.put('c',3);
        a.put('d',4);
        a.put('e',5);
        a.put('f',6);
        a.put('g',7);
        a.put('h',8);
        a.put('i',9);
        a.put('j',10);
        a.put('k',11);
        a.put('l',12);
        a.put('m',13);
        a.put('n',14);
        a.put('o',15);
        a.put('p',16);
        a.put('q',17);
        a.put('r',18);
        a.put('s',19);
        a.put('t',20);
        a.put('u',21);
        a.put('v',22);
        a.put('w',23);
        a.put('x',24);
        a.put('y',25);
        a.put('z',26);
    }
    public static String caesarCipher(String s, int k) {
        // Write your code here
        if (s == null || k == 0 || s.isEmpty() || s.isBlank()){
            return s;
        }
        StringBuffer b = new StringBuffer();
        int r = k % 26;
        for(int i = 0; i < s.length();i++){
            if(!isLetter(s.charAt(i))){
                b.append(s.charAt(i));
                continue;
            }
            if(s.charAt(i)>= 'a' && s.charAt(i) <= 'z'){
                if(r == 0)
                    b.append(s.charAt(i));
                else {
                    int p = ((a.get(s.charAt(i))+r)%26 == 0 ? 26: ((a.get(s.charAt(i))+r)%26));
                    b.append(a.entrySet().stream().filter(e-> e.getValue() == (p)).findFirst().get().getKey());
                }
            }
            if(s.charAt(i)>= 'A' && s.charAt(i) <= 'Z'){
                if(r == 0)
                    b.append(s.charAt(i));
                else {
                    int p = (a.get((char)(s.charAt(i)+32)) + r) % 26 == 0 ? 26: (a.get((char)(s.charAt(i)+32)) + r)%26;
                    b.append((char) (a.entrySet().stream().filter(e -> e.getValue() == (p)).findFirst().get().getKey() - 32));
                }
            }
        }
        return b.toString();
    }
    private static boolean isLetter(char c){
        return (c>= 'a' && c <= 'z') || (c>= 'A' && c <= 'Z');
    }
    public static void main(String[] args) {
        System.out.println(caesarCipher("middle-Outz",2));
        System.out.println(caesarCipher("1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M",27));
    }
}
