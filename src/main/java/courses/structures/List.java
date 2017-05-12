package courses.structures;

/**
 * Interface for our hand-made list
 */
public interface List<E> {

    int size();

    void add(E element);

    void remove(int i);

    E get(int i);
}
