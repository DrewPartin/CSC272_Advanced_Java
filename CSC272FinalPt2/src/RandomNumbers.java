import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
    public static void main(String[] args) {
        // Report your results from each run as number in range(1,10) and the number of samples of each that were recorded in each of the runs in pt (vi) above plotted in a graph.

        printStream();
        System.out.println();
        randomIntegers();
        System.out.println();
        frequency();
        System.out.println();
        frequencyOneLine();
        System.out.println();
        frequencyHundThousand();
        System.out.println();
        frequencyMillion();
        System.out.println();

    }

    // Create a stream that generates 20 randomly generated integers in the range 1-100
    public static void printStream() {
        IntStream stream = IntStream.generate(() -> (int) (Math.random() * 100) + 1).limit(20);
        // Implement a technique that uses a method reference for the println function to print the contents of the stream in (i) above.
        stream.forEach(System.out::println);
    }

    // Write a stream object that generates 100 random integers in the range 1 to 10
    public static void randomIntegers() {
        IntStream.generate(() -> (int) (Math.random() * 10 + 1)).limit(100).forEach(System.out::println);
    }

    // Take the stream above from (iii) and using  only functional interfaces, lambdas, mapping functions, collectors, reductions and groupings implement a processing pipe that: counts the frequency of occurrence of each number in that stream.
    public static void frequency() {
        IntStream.generate(() -> (int) (Math.random() * 10 + 1)).limit(100).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> System.out.println(k + " " + v));
    }

    // Apply an appropriate stream construct to display the frequency of occurrences calculated above all printed in one line.
    public static void frequencyOneLine() {
        IntStream.generate(() -> (int) (Math.random() * 10 + 1)).limit(100).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> System.out.print(k + " " + v + " "));
    }

    // Repeat the experiment in (iii) and (iv) above but increase the size of generated stream from 100, to 100,000, and 1,000,000 samples. 
    public static void frequencyHundThousand() {
        IntStream.generate(() -> (int) (Math.random() * 10 + 1)).limit(100000).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> System.out.println(k + " " + v));
    }

    public static void frequencyMillion() {
        IntStream.generate(() -> (int) (Math.random() * 10 + 1)).limit(1000000).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> System.out.println(k + " " + v));
    }

}
