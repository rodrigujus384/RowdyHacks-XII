package cs2.adt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class DequeTester {
  /* Place your thorough tester code here to test MyDeque
   * Be sure to test all of the required elements of the Deque interface,
   * including the exceptions that must be thrown.
   */
    @Test
    void testEmptyDeque() {
        MyDeque<Integer> dq = new MyDeque<>();

        assertTrue(dq.isEmpty());          // expected: true
        assertEquals(0, dq.size());        // expected: 0

        assertThrows(NoSuchElementException.class, dq::peekFront);
        assertThrows(NoSuchElementException.class, dq::peekBack);

        assertThrows(NoSuchElementException.class, dq::front);
        assertThrows(NoSuchElementException.class, dq::back);
    }

    @Test
    void testAppend() {
        MyDeque<Integer> dq = new MyDeque<>();

        dq.append(1);
        dq.append(2);
        dq.append(3);

        assertEquals(3, dq.size());        // expected: 3
        assertEquals(1, dq.peekFront());   // expected: 1
        assertEquals(3, dq.peekBack());    // expected: 3
    }

    @Test
    void testPrepend() {
        MyDeque<Integer> dq = new MyDeque<>();

        dq.prepend(1);
        dq.prepend(2);
        dq.prepend(3);

        assertEquals(3, dq.size());        // expected: 3
        assertEquals(3, dq.peekFront());   // expected: 3
        assertEquals(1, dq.peekBack());    // expected: 1
    }

    @Test
    void testPopFront() {
        MyDeque<Integer> dq = new MyDeque<>();

        dq.append(1);
        dq.append(2);
        dq.append(3);

        assertEquals(1, dq.front());    // expected: 1
        assertEquals(2, dq.front());    // expected: 2
        assertEquals(3, dq.front());    // expected: 3

        assertTrue(dq.isEmpty());          // expected: true
    }

    @Test
    void testPopBack() {
        MyDeque<Integer> dq = new MyDeque<>();

        dq.append(1);
        dq.append(2);
        dq.append(3);

        assertEquals(3, dq.back());     // expected: 3
        assertEquals(2, dq.back());     // expected: 2
        assertEquals(1, dq.back());     // expected: 1

        assertTrue(dq.isEmpty());          // expected: true
    }

    @Test
    void testMixedOperations() {
        MyDeque<Integer> dq = new MyDeque<>();

        dq.append(2);
        dq.prepend(1);
        dq.append(3);
        dq.prepend(0);

        assertEquals(4, dq.size());        // expected: 4
        assertEquals(0, dq.peekFront());   // expected: 0
        assertEquals(3, dq.peekBack());    // expected: 3

        assertEquals(0, dq.front());    // expected: 0
        assertEquals(3, dq.back());     // expected: 3
        assertEquals(1, dq.front());    // expected: 1
        assertEquals(2, dq.back());     // expected: 2

        assertTrue(dq.isEmpty());          // expected: true
    }

    @Test
    void testResizePrepend() {
        MyDeque<Integer> dq = new MyDeque<>();

        for (int i = 0; i < 150; i++) {
            dq.prepend(i);
        }

        assertEquals(150, dq.size());      // expected: 150
        assertEquals(149, dq.peekFront()); // expected: 149
        assertEquals(0, dq.peekBack());    // expected: 0
    }
}
