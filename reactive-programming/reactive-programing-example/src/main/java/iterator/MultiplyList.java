package iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MultiplyList implements Iterable<Integer>{
    private int position;
    private int size;
    private int number;

    public MultiplyList(int size, int number) {
        this.size = size;
        this.number = number;
    }

    @Override
    public Iterator<Integer> iterator() {
        int size = this.size;
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return (position<size);
            }

            @Override
            public Integer next() {
                return number*position++;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }
}
