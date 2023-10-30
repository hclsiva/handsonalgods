package codility.ericsson._06_oct_2023;

public class LongestSymmetricInStringWithoutGeneration {
    public int isSymmetric(String S) {
        int max = 0;
        for(int i = 0; i < S.length(); i ++){
            for (int j = i +1; j <= S.length(); j++){
                String t = S.substring(i,j);
                if(t.length()%2 == 0){
                    int k = 0, l = t.length()-1;
                    boolean isSym = true;
                    while(k < l && isSym){
                        if(!(t.charAt(k) == '<' || t.charAt(k) == '?') && (t.charAt(l) == '>' || t.charAt(l) == '?')){
                            isSym = false;
                        }
                        k++;
                        l--;
                    }
                    if(isSym){
                        max = Math.max(max,t.length());
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSymmetricInStringWithoutGeneration l = new LongestSymmetricInStringWithoutGeneration();
        String input = "<><??>>";
        int max = l.isSymmetric(input);
        System.out.println(max);
        input = "??????";
        max = l.isSymmetric(input);
        System.out.println(max);
        input = "<<?";
        max = l.isSymmetric(input);
        System.out.println(max);
    }
}
