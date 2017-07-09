package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        Trip[] trips = new Trip[n];
        for (int i = 0; i < n; i++) trips[i] = new Trip(in.nextInt(), in.nextInt(), in.nextInt());
        Arrays.sort(trips, (Comparator.comparingInt(o -> o.l)));

        int[] best = new int[200010];
        PriorityQueue<Trip> visited = new PriorityQueue<>(Comparator.comparingInt(o -> o.r));
        Arrays.fill(best, Integer.MAX_VALUE);

        Trip next;
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (trips[i].duration >= x) continue;
            while ((next = visited.peek()) != null && next.r < trips[i].l) {
                next = visited.poll();
                best[next.duration] = Math.min(best[next.duration], next.cost);
            }
            visited.offer(trips[i]);
            res = Math.min(res, (long) trips[i].cost + best[x - trips[i].duration]);
        }
        out.print(res >= Integer.MAX_VALUE ? -1 : res);
    }

    private static class Trip {
        int l;
        int r;
        int cost;
        int duration;

        public Trip(int l, int r, int cost) {
            this.l = l;
            this.r = r;
            this.cost = cost;
            duration = r - l + 1;
        }
    }
}