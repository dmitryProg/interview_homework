import java.util.Stack;

public class QueueFromTwoStacks<E> {
    private int size = 0;
    Stack firstStack = new Stack();
    Stack secondStack = new Stack();

    public void insert(E element) {

        size++;
    }

    public void remove(E element) {

        size--;
    }

    public int size() {
        return size;
    }
}
