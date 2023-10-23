package leetcode.cheatsheet;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MostRepeaterCharacter {
    public char solution (String t){
        Map<Character,Integer> f = new HashMap<>();
        t.chars().mapToObj(i -> (char)i).forEach(c -> {
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z' )) {
                f.putIfAbsent(c, 0);
                f.computeIfPresent(c, (k, v) -> v + 1);
            }
        });
        return Collections.max(f.entrySet(),Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        MostRepeaterCharacter m = new MostRepeaterCharacter();
        System.out.println(m.solution("abcddefda111113333333"));
        System.out.println(m.solution("AA0AB0BB0ccc0aa00aw00wOoBBBW123123"));
    }
}
