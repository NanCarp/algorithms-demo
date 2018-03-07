package chapter2;

import algs4.*;

/**
 * Created by nanca on 3/7/2018.
 */
public class TopM {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(M + 1);
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M) {
                pq.delMin();
            }

            Stack<Transaction> stack = new Stack<>();
            while (!pq.isEmpty()) {
                stack.push(pq.delMin());
                for (Transaction t : stack) {
                    StdOut.println(t);
                }
            }
        }
    }
}
