package courses.structures;


interface Queue<E> {
    void enqueue(E obj);

    E dequeue();

    int size();
}