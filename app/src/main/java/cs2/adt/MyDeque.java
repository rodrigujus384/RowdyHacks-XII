package cs2.adt;

import java.util.NoSuchElementException;

public class MyDeque<T> implements Deque<T> {
    //fields
    @SuppressWarnings("unchecked")
    private T[] deck = (T[]) new Object[100]; //first half is 0-49 and second half is 50-99
    private int LogBeg = 49;
    private int LogEnd = 50;

    public void incSize() {
        T[] old = deck;
        @SuppressWarnings("unchecked")
        T[] replace = (T[]) new Object[old.length * 2];

        int size = LogEnd - LogBeg - 1;
        int newBeg = (replace.length / 2) - (size / 2) - 1;
        int newEnd = newBeg + size + 1;
        int j = newBeg + 1;
        for (int i = LogBeg + 1; i < LogEnd; i++) {
            replace[j++] = old[i];
        }
        deck = replace;
        LogBeg = newBeg;
        LogEnd = newEnd;
    }
    public void prepend(T item) {
        if (LogBeg < 0 ) {
            this.incSize();
        }
        deck[LogBeg] = item;
        LogBeg--;
    }
   
    public void append(T item) {
        if (LogBeg > deck.length) {
            this.incSize();
        }
        deck[LogEnd] = item;
        LogEnd++;
    }

    public T front() throws NoSuchElementException {
        if (this.isEmpty() == true) {
            throw new NoSuchElementException("This deque is empty.");   }
        T saved;
        LogBeg++;
        saved = deck[LogBeg];
        deck[LogBeg] = null;
        return saved;
    }

    public T back() throws NoSuchElementException {
        if (this.isEmpty() == true) {
            throw new NoSuchElementException("This deque is empty.");   }
        T saved;
        LogEnd--;
        saved = deck[LogEnd];
        deck[LogEnd] = null;
        return saved;
    }

    public T peekFront() throws NoSuchElementException {
        if (this.isEmpty() == true) {
            throw new NoSuchElementException("This deque is empty.");   }
        T saved;
        LogBeg++;
        saved = deck[LogBeg];
        LogBeg--;
        return saved;
    }

    public T peekBack () throws NoSuchElementException {
        if (this.isEmpty() == true) {
            throw new NoSuchElementException("This deque is empty.");   }
        T saved;
        LogEnd--;
        saved = deck[LogEnd];
        LogEnd++;
        return saved;
    }

    public boolean isEmpty() {
        return (LogBeg+1 == LogEnd);
    }

    public int size() {
        return (LogEnd-LogBeg)-1;
    }
}