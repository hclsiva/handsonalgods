package codility;

public class CroppingMessage {

  public CroppingMessage() {
    // TODO Auto-generated constructor stub
  }
  
  public String solution(String message, int K) {
    
    String solution = "";
    if(K ==0 || message == null || message.equals("")) {
      return solution;
    }
    if(message.length() <= K) {
      return message;
    }
    if(message.charAt(K) == ' ') {
      return message.substring(0, K).trim();
    }
    int n = K-1;
    while(n > 0 && message.charAt(n) != ' ' ) {
      n--;
    }
    return message.substring(0, n).trim();
    
    
  }
  
  public static void main(String[] args) {
    CroppingMessage c = new CroppingMessage();
    String m = "Codility We test coders";
    String message = c.solution(m, 14);
    System.out.println(m +" = " + message  );
    message = c.solution("Why not", 100);
    System.out.println("Why not = " + message  );
    message = c.solution("The quick brown fox jumps over the lazy dog", 39);
    System.out.println("The quick brown fox jumps over the lazy dog = " + message  );
    message = c.solution("To crop or not to crop", 21);
    System.out.println("To crop or not to crop = " + message  );
    
    
    m = "Codility";
    message = c.solution(m, 1);
    System.out.println(m +" = " + message  );
  }

}
