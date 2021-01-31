import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Stream<? extends T> sre = stream.sorted(order);
        minMaxConsumer.accept(sre.min().orElse(null), sre.max().orElse(null));
    }
}