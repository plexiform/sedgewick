/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int n;
    private Node first, last;

    // Node is one of:
    // - null
    // - Item Node Node
    // where 1 node is the previous node, and 1 node is the next node
    private class Node {
        private Item item;
        private Node previous;
        private Node next;
    }

    public Deque() {
        n = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }
    
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("no args provided");

        Node oldfirst = first;

        first = new Node();
        first.item = item;
        if (isEmpty()) { // !!!
            last = first;
            last.previous = first;
        }
        else {
            first.next = oldfirst;
            oldfirst.previous = first;
        }
        n++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("no args provided");

        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
            last.previous = first;
            first.next = last;
        }
        else {
            oldlast.next = last;
            last.previous = oldlast;
        }
        n++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = last.item;
        last = last.previous;
        n--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }

    private Item removeAndSpitString() {
        Item item = removeLast();
        StdOut.println(item + " was removed from the BACK OF the deque.");
        return item;
    }

    public static void main(String[] args) {
        /*
        // adding letters to stack
        String[] letters = { "a", "b", "c", "d" };
        for (int i = 0; i < letters.length; i++) {
            dequeOne.addFirst(letters[i]);
            StdOut.println("added " + letters[i] + " to FRONT OF deque.");
        }
        StdOut.println(dequeOne.size() + " items in deque.");
        // removing first letters from stack
        for (String i : dequeOne) {
            dequeOne.removeFirst();

            StdOut.println("Removed " + i + " from the FRONT OF deque. ");
        }
        StdOut.println(dequeOne.size() + " items in deque.");

        // adding letters to queue
        for (int i = 0; i < letters.length; i++) {
            dequeOne.addLast(letters[i]);
            StdOut.println("added " + letters[i] + " to BACK OF deque.");
        }
        StdOut.println(dequeOne.size() + " items in deque.");
        StdOut.println("Deque is " +
                               (dequeOne.isEmpty() ? "empty." : "not empty."));
        // removing letters from back of deque
        for (String i : dequeOne) {
            dequeOne.removeAndSpitString();
        }

        StdOut.println(dequeOne.size() + " items in deque.");
        StdOut.println("Deque is " +
                               (dequeOne.isEmpty() ? "empty." : "not empty."));

         */
    }
}
