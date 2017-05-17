package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int w = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        PriorityQueue<Cup> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = (a[i] + 1) / 2;
            w -= b[i];
            priorityQueue.offer(new Cup(i, a[i]));
        }

        if (w < 0) {
            out.print(-1);
            return;
        }

        Cup next;
        int nextMin;
        while (!priorityQueue.isEmpty() && w > 0) {
            next = priorityQueue.poll();
            nextMin = Math.min(a[next.index] - b[next.index], w);
            b[next.index] += nextMin;
            w -= nextMin;
        }

        if (priorityQueue.isEmpty() && w > 0) {
            out.print(-1);
            return;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(b[i]).append(' ');
        }

        out.print(res);
    }

    private static class Cup implements Comparable<Cup> {
        int index;
        int volume;

        public Cup(int index, int volume) {
            this.index = index;
            this.volume = volume;
        }

        @Override
        public int compareTo(Cup o) {
            return Integer.compare(o.volume, this.volume);
        }
    }
}
