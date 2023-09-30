package hackerrank;

import java.util.stream.Stream;

public class FizzBuzz {


    public static void fizzBuzz(int n) {
        Stream.iterate(1,i -> i <=n , i ->i +1)
                .map((i)-> (i%15) == 0 ? "FizzBuzz":(i%5 == 0) ? "Buzz":(i%3 ==0)?"Fizz":i)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        FizzBuzz.fizzBuzz(30);
    }
}
