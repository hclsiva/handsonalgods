package leetcode.cheatsheet;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneNumberCombinations {
    Map<String,String> n = new HashMap<>();
    public PhoneNumberCombinations(){
        populateMap();
        System.out.println(n);
    }

    private void populateMap(){
        n.put("2","abc");
        n.put("3","def");
        n.put("4","ghi");
        n.put("5","jkl");
        n.put("6","mno");
        n.put("7","pqrs");
        n.put("8","tuv");
        n.put("9","wxyz");

    }
    public List<String> letterCombinations(String digits) {
        List<String> r = new ArrayList<>();
        if(digits == null || digits.isEmpty() || digits.isBlank()){
            return r;
        }
        char[] d = digits.toCharArray();
        String l = n.get(String.valueOf(d[0]));
        l.chars().mapToObj(c -> (char) c).sorted().forEach(c -> r.add(String.valueOf(c)));
        for(int i = 1;i < digits.length(); i++) {
            populateCombos(r, n.get(String.valueOf(d[i])));
        }
        return r;
    }
    private void populateCombos(List<String> r, String letters){
        char[] c = letters.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < r.size();i++){
            String v = r.get(i);
            for (char d: c) {
                char[] sorted = (v+d).toCharArray();
                Arrays.sort(sorted);
                result.add(String.valueOf(sorted));
            }
        }
        r.clear();
        r.addAll(result);
    }
    public static void main(String[] args) {
        PhoneNumberCombinations c = new PhoneNumberCombinations();
        System.out.println(c.letterCombinations("234"));
    }
}
