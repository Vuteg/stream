import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("Valera", "Ivan", "Alexandr", "Boris");
        Comparator<String> stringComparator = Comparator.comparing(String::length);
        BiConsumer<String, String> stringBiConsumer = (min, max) -> System.out.println(min.toString() + ", " + max.toString());
        findMinMax(stringStream, stringComparator, stringBiConsumer);

        findEvenIntegersNumbers(List.of(10,5,7,2,4,9,4,21,34,66,77,88,10));
    }

    public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void findEvenIntegersNumbers(List<Integer> list) {
        Stream<Integer> intStream = list.stream();
        Stream<Integer> stream = intStream.filter(x -> (x % 2) == 0);
        System.out.println(stream.count());
    }

}