package leetcode;

public class BinaryToInt {
    public int binaryToInt(String s){
        if (s == null || s.isBlank()){
            return 0;
        }
        int len = s.length()-1;
        int sum = 0;
        for(int i = len ; i >= 0; i--){
            switch (s.charAt(i)){
                case '1':
                    sum+= power(len -i);
            }
        }
        return sum;
    }

    private int power(int k){
        if (k == 0){
            return 1;
        }
        int product = 1;
        for(int j = 0; j < k;j++){
            product *= 2;
        }
        return product;
    }

    public static void main(String[] args) {
        BinaryToInt bt = new BinaryToInt();
        System.out.println(bt.binaryToInt("1000"));
    }
}
