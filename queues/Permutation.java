/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randQ = new RandomizedQueue<>();
        int num = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            randQ.enqueue(str);
        }

        for (int i = 0; i < num; i++) {
            String sample = randQ.sample();
            StdOut.println(sample);
        }
    }
}
