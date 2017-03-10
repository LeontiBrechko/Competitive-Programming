import java.util.ArrayList;
import java.util.PriorityQueue;

public class ForwardMancala {

    public int[] findMoves(int[] start) {
        int n = start.length;
        int zeroCount = getZeroCount(start);

        ArrayList<Integer> res = new ArrayList<>();
        Pair nextPair;
        int nextNumber, nextIndex;
        while (zeroCount + 1 < n) {
            nextPair = getNextSmallest(start);
            nextNumber = nextPair.value;
            nextIndex = nextPair.index;
            res.add(nextIndex);
            start[nextIndex] = 0;
            for (int i = (nextIndex + 1) % n; nextNumber > 0; i = (i + 1) % n, nextNumber--) start[i]++;
            zeroCount = getZeroCount(start);
        }

        n = res.size();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) answer[i] = res.get(i);
        return answer;
    }

    private int getZeroCount(int[] array) {
        int n = array.length;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) if (array[i] == 0) zeroCount++;

        return zeroCount;
    }

    private Pair getNextSmallest(int[] array) {
        int index = -1;
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] < value) {
                value = array[i];
                index = i;
            }
        }
        return new Pair(index, value);
    }

    private static class Pair implements Comparable<Pair> {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
