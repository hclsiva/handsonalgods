package leetcode;

public class DecimalToBinary {
    public String toBinaryString(int n){
        StringBuffer buffer = new StringBuffer();
        while(n > 0){
            buffer.insert(0,n%2);
            n = n/2;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecimalToBinary().toBinaryString(15));
        System.out.println(new DecimalToBinary().toBinaryString(16));
    }
}
