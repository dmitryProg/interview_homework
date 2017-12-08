public class HalfLinkedList<E> {
    int size = 0;
    Node<E> first;
    Node<E> last;

    public int length() {
        return size;
    }

    public void insert(E element) {
        final Node<E> firstElement = first;
        final Node<E> newElement = new Node<>(element, firstElement);
        first = newElement;
        size++;
    }

    public static void main(String[] args) {
        HalfLinkedList<String> string = new HalfLinkedList<>();
        string.insert("RTFM!!!");
        string.insert("RTrfrfM!!!");
        System.out.println(string.length());
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.element = item;
            this.next = next;
        }
    }
}
