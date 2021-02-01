import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
            List<? extends T> terds = stream.collect(Collectors.toList());

            Stream<? extends T> sre = terds.stream();
        Stream<? extends T> srd = terds.stream();

        minMaxConsumer.accept(sre.min(order).orElse(null), srd.max(order).orElse(null));
    }
}