public class MyStack<T> extends MyLinkedList<T> {

    /**
     * Push an element onto the Stack
     *
     * @param element The element to push.
     */
    @Override
    public void push(T element) {
        add(element); // Add the new element to the end of the LinkedList
    }

    /**
     * Pop an element off the Stack
     *
     * @return The popped element
     */
    @Override
    public T pop() {
        if (size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T poppedElement = tail.value; // Store the value of the element to be popped
        remove(size() - 1); // Remove the last element of the LinkedList
        return poppedElement;
    }

    /**
     * Peek at the next element in the Stack
     *
     * @return The peeked element
     */
    @Override
    public T peek() {
        if (size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return tail.value; // Return the value of the last element of the LinkedList
    }

    /**
     * Put the MyStack through some simple tests.
     *
     * @param args Ignored command line arguments.
     */
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();

        // Check that an initial stack has nothing in it.
        int[] answer1 = new int[0];
        assertIsEqual(stack, answer1);

        // Push some elements onto the Stack
        for (int i = 0; i < 5; i++) {
            stack.push(i * i);
        }
        int[] answer2 = {0, 1, 4, 9, 16};
        assertIsEqual(stack, answer2);

        // Pop some numbers from the stack
        stack.pop();
        stack.pop();
        int[] answer3 = {0, 1, 4};
        assertIsEqual(stack, answer3);

        // Peek at the next element in the stack
        int peekedElement = stack.peek();
        System.out.println("Peeked Element: " + peekedElement);

        // If everything is good, we passed
        System.out.println("pass");
    }
}
