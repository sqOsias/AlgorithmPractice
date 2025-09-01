package uesless;

import java.util.Arrays;
import java.util.List;

public class useless1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

}
