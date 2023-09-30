package codility;

public class BinaryGap {

  public BinaryGap() {
    // TODO Auto-generated constructor stub
  }
  
  public int solution(int N) {
    
    String binaryRepr = Integer.toBinaryString(N);
    char[] numbers = binaryRepr.toCharArray();
    int length=0,prevLength =0;
    
    int i = numbers.length-1;
    boolean gapStarted = false;
    while(i >0) {
      if(numbers[i] == '1' ) {
        if(gapStarted) {
          if(length > prevLength) {
            prevLength = length;
          }
          length = 0;
        }   else {
          gapStarted = true;
        }     
      } else {
        if(gapStarted) {
          length++;
        }
      }
      i--;
    }
    if(length > prevLength) {
      return length;
    }
    return prevLength;
    
  }

  public static void main(String[] args) {
    BinaryGap binaryGap = new BinaryGap();
    System.out.println("Binary Gap of 0 : " + binaryGap.solution(0) );
    System.out.println("Binary Gap of 9 : " + binaryGap.solution(9) );
    System.out.println("Binary Gap of 529 : " + binaryGap.solution(529) );
    System.out.println("Binary Gap of 20 : " + binaryGap.solution(20) );
    System.out.println("Binary Gap of 15 : " + binaryGap.solution(15) );
    System.out.println("Binary Gap of 32 : " + binaryGap.solution(32) );
    System.out.println("Binary Gap of 1041 : " + binaryGap.solution(1041) );

  }

}
