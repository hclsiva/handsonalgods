package leetcode.cheatsheet;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
    IntStream.range(1,101).mapToObj(i ->
            {
                String s = Optional.of(i).map(j-> (((j % 3 == 0)?"Fizz":"")+((j%5==0)?"Buzz":"")))
                        .get();
                return i + " -> " +(s.isBlank()?String.valueOf(i):s);
            }
        ).forEach(s -> System.out.println(s));
    }

}
