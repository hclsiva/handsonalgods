package codility;

public class StrSymmetryPoint {
    public int solution(String S) {
        if(S == null || S.isEmpty()){
            return -1;
        }
        int mid = S.length()/2;
        String left = S.substring(0,mid);

        StringBuffer buffer = new StringBuffer(S.substring(mid+1,S.length()));
        String right = buffer.reverse().toString();
        return (left.equals(right))?mid:-1;
    }

    public static void main(String[] args) {
        StrSymmetryPoint instance = new StrSymmetryPoint();
        System.out.println(instance.solution("racecar"));
    }
}
