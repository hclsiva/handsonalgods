package leetcode.cheatsheet;

public class ReverseInteger {
    public int reverse(int x) {
        StringBuffer b = new StringBuffer(String.valueOf(Math.abs(x)));
        Integer y = 0;
        try{
            b = b.reverse();
            y = Integer.valueOf(b.toString());
            if(x <0 )
                y = -y;

        }catch(Exception e){
            return 0;
        }
        return y;

    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(Integer.MIN_VALUE));
        System.out.println(r.reverse(Integer.MAX_VALUE));
        System.out.println(r.reverse(120));
        System.out.println(r.reverse(123));
        System.out.println(r.reverse(-123));
    }
}
