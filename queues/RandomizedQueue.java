/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;
    private Item[] arr;

    private static final int INIT = 8;

    public RandomizedQueue() {
        arr = (Item[]) new Object[INIT];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (arr.length == n) resize(2 * arr.length);
        arr[n++] = item;
    }

    private void resize(int desiredSize) {
        Item[] newArr = (Item[]) new Object[desiredSize];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randNum = StdRandom.uniform(n);
        Item item = arr[randNum];
        arr[randNum] = arr[n - 1];
        arr[n - 1] = null;
        n--;
        if (n > 0 && n == arr.length / 4) resize(arr.length / 2);
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return arr[StdRandom.uniform(n)];
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i;

        public ArrayIterator() {
            i = 0;
        }

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return arr[i++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        /*
        RandomizedQueue<String> randQ = new RandomizedQueue<String>();

        // is it empty?
        StdOut.println("Test " + (randQ.isEmpty() ? "passed" : "failed"));

        // can we enqueue then test that single enqueue with a sample?
        randQ.enqueue("hi");
        StdOut.println("Test " + (randQ.sample().equals("hi") ? "passed" : "failed"));

        // size?
        StdOut.println("Test " + (randQ.size() == 1 ? "passed" : "failed"));

        // is it still empty?
        StdOut.println("Test " + (!randQ.isEmpty() ? "passed" : "failed"));

        // how does size() check out after we enqueue multiple items?
        randQ.enqueue("there");
        randQ.enqueue("I");
        randQ.enqueue("am");
        randQ.enqueue("a pro developer");

        StdOut.println("Test " + (randQ.size() == 5 ? "passed" : "failed"));
        // some samples?
        StdOut.println("Random sample: " + randQ.sample());
        StdOut.println("Random sample: " + randQ.sample());
        StdOut.println("Random sample: " + randQ.sample());
        StdOut.println("Random sample: " + randQ.sample());

        // size after we dequeue?
        randQ.dequeue();
        randQ.dequeue();
        StdOut.println("Test " + (randQ.size() == 3 ? "passed" : "failed"));
        randQ.dequeue();
        StdOut.println("Test " + (randQ.size() == 2 ? "passed" : "failed"));
        randQ.dequeue();
        randQ.dequeue();
        StdOut.println("Test " + (randQ.isEmpty() ? "passed" : "failed"));

        int n = 5;
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);
        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }


         */

    }
}
