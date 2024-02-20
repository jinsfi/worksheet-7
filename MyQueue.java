public class MyQueue<T> extends MyLinkedList<T> {

    /**
     * Push an element onto the Queue
     *
     * @param element The element to push.
     */
    @Override
    public void push(T element) {
        add(element); // Add the new element to the end of the LinkedList
    }

    /**
     * Pop an element off the Queue
     *
     * @return The popped element
     */
    @Override
    public T pop() {
        if (size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T poppedElement = head.value; // Store the value of the element to be popped
        remove(0); // Remove the first element of the LinkedList
        return poppedElement;
    }

    /**
     * Peek at the next element in the Queue
     *
     * @return The peeked element
     */
    @Override
    public T peek() {
        if (size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.value; // Return the value of the first element of the LinkedList
    }

    /**
     * Put the MyQueue through some simple tests.
     *
     * @param args Ignored command line arguments.
     */
    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();

        // Check that an initial queue has nothing in it.
        int[] answer1 = new int[0];
        assertIsEqual(queue, answer1);

        // Push some elements onto the Queue
        for (int i = 0; i < 5; i++) {
            queue.push(i * i);
        }
        int[] answer2 = {0, 1, 4, 9, 16};
        assertIsEqual(queue, answer2);

        // Pop some numbers from the queue
        queue.pop();
        queue.pop();
        int[] answer3 = {4, 9, 16};
        assertIsEqual(queue, answer3);

        // Peek at the next element in the queue
        int peekedElement = queue.peek();
        System.out.println("Peeked Element: " + peekedElement);

        // If everything is good, we passed
        System.out.println("pass");
    }
}
