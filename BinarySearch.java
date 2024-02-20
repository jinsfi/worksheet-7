import java.lang.AssertionError;

public class BinarySearch {

    /*
     * Do a binary search for the target.
     *
     * This function returns -1 if the target is not in the array.
     *
     * @param array The sorted array to search within.
     * @param target The target to search for.
     * @returns An index of the target in the array, or -1.
     */
    public static int origBinarySearch(int[] array, int target) {
        int mid = 0;
        int low = 0;
        int high = array.length - 1;
        while (high >= low) {
            mid = (high + low) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1; // not found
    }

    /*
     * Do a binary search for the target, returning the first index with it.
     *
     * This function returns -1 if the target is not in the array.
     *
     * @param array The sorted array to search within.
     * @param target The target to search for.
     * @returns The first index of the target in the array, or -1.
     */
    public static int firstBinarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int result = -1; // Initialize the result to -1, indicating not found
        while (high >= low) {
            int mid = (high + low) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                result = mid; // Update the result to the current index
                high = mid - 1; // Continue searching towards lower indices
            }
        }
        return result;
    }

    /*
     * Do a binary search for the target.
     *
     * This function returns -1 if the target is not in the array.
     *
     * @param array The sorted array to search within.
     * @param target The target to search for.
     * @returns An index of the target in the array, or -1.
     */
    public static int recurBinarySearch(int[] array, int target) {
        return recurBinarySearch(array, target, 0, array.length - 1);
    }

    private static int recurBinarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1; // Base case: target not found
        }
        int mid = (high + low) / 2;
        if (array[mid] < target) {
            return recurBinarySearch(array, target, mid + 1, high); // Search the right half
        } else if (array[mid] > target) {
            return recurBinarySearch(array, target, low, mid - 1); // Search the left half
        } else {
            return mid; // Target found
        }
    }

    /*
     * Run some tests for binarySearch.
     *
     * @param args Command-line arguments; ignored.
     */
    public static void main(String[] args) {
        final int SIZE = 10;

        // create an array of ints
        int[] numbers = new int[SIZE];

        // add twice the index to each position
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = 2 * i;
        }

        // test that we get correct indices from -5 to 2 * SIZE + 5
        for (int i = -5; i < 2 * SIZE + 5; i++) {
            int expected = -1;
            if (0 <= i && i < 2 * SIZE && i % 2 == 0) {
                expected = i / 2;
            }
            // change the line below to test other binary search functions
            int actual = origBinarySearch(numbers, i);
            if (actual != expected) {
                throw new AssertionError("Expected " + expected + " doing binary search on " + i + " but got " + actual);
            }
        }

        System.out.println("pass");
    }

}
