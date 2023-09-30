package utils;

public class TestClient extends Thread{

	private int x = 2;
	public TestClient() {
		x = 5;
	}
	public void makeItGo() throws Exception{
		join();
		x =x-1;
		System.out.println(x);
	}
	public void run() {
		x*=2;
	}
	public void go(int x,String...y ) {

	}
	public static void main(String[] args) throws Exception{

		String str = "Hello World";
		char[] chars = new char[7];
		str.getChars(0, 7, chars, 0);
		System.out.println(chars);
		if(true ^ true) {
			
		}
	}
}
