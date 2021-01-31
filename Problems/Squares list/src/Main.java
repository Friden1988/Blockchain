import java.util.*;
import java.util.stream.Collectors;

class CollectionUtils {

    public static Collection<Integer> pow2(Collection<Integer> numbers) {
        Collection<Integer> adfs = new ArrayList<>();
        numbers.forEach(num -> adfs.add(Math.abs(num*num)));
//        adfs.forEach(System.out::println);
        return adfs;
    }
}

/* Please, do not modify this I/O code */
public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Collection<Integer> list2 = new ArrayList<>();

        ArrayList<Integer> liste = new ArrayList<>();

//        LinkedList<Integer> listew = new ArrayList<>();

        LinkedList<Integer> listwe = new LinkedList<>(new ArrayList<>());

        Scanner scanner = new Scanner(System.in);

        Collection<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collection<Integer> result = CollectionUtils.pow2(numbers);

        System.out.println(result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}