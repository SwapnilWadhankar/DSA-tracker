import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiPracticeQuestions {
    public static void main(String[] args) {
        String s = "This is is Swapnil from Capgemini india pvt ltd";
        String s1 = "abbadabbacddfgdcvdsac";

        //to print the word with the highest length
        String maxString = Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length)).get();
        System.out.println(maxString);

        //remove duplicates from the string
        Arrays.stream(s1.split("")).distinct().forEach(System.out::print);
        System.out.println();

        //print word with second-highest length
        String secondHighest = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
        System.out.println(secondHighest);

        //Count the occurrence of a word in string
        Map<String,Long> ans = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.print(ans);
        System.out.println();

        //print the words with exact 2 vowels in it
        Arrays.stream(s.split(" ")).filter(x->x.replaceAll("[^aeiouAEIOU]","").length()==2).forEach(System.out :: println);
    }
}
