package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author kanglo
 * @create 2022-06-2022/6/29 23:24
 */
public class StreamTest {
    public static void main2(String[] args) {
        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer>newStream = stream.filter(s-> s > 5).distinct().skip(2).limit(2);
        newStream.forEach(System.out::println);
    }

    public static void main1(String[] args) {
        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        Stream<String>stream = list.stream().map(s->s.replace(",",""));
//        stream.forEach(System.out::println);
        Stream<String>s3 = list.stream().flatMap(s->{
         String[]split = s.split(",");
         Stream<String>s2 = Arrays.stream(split);
         return s2;
        });
//        s3.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String>list = Arrays.asList("1","2","3","4","5");
        System.out.println(String.join(",",list));
    }
}
