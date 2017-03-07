package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        PriorityQueue<Product> products = new PriorityQueue<>();
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            products.offer(new Product(i, b[i] - a[i]));
        }

        long res = 0;
        Product next;
        while (!products.isEmpty()) {
            next = products.peek();
            if (k > 0) {
                res += a[next.index];
                products.poll();
                k--;
            } else {
                if (next.diff > 0) {
                    res += a[next.index];
                    products.poll();
                } else break;
            }
        }

        while (!products.isEmpty()) res += b[products.poll().index];

        out.print(res);
    }

    private static class Product implements Comparable<Product> {
        int index;
        int diff;

        public Product(int index, int diff) {
            this.index = index;
            this.diff = diff;
        }

        @Override
        public int compareTo(Product o) {
            return o.diff - this.diff;
        }
    }
}
