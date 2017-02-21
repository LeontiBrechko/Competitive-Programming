import java.util.ArrayDeque;

public class Robofactory {

    public int reveal(int[] query, String[] answer) {
        int n = query.length;
        boolean[] isBroken = new boolean[n];
        boolean[] mayBeBroken = new boolean[n];
        mayBeBroken[0] = true;
        for (int i = 1; i < n; i++) {
            if (query[i - 1] % 2 == 1) {
                if ((query[i] % 2 == 1 && answer[i].equals("Even"))
                        || (query[i] % 2 == 0 && answer[i].equals("Odd"))) {
                    isBroken[i] = true;
                }
            } else {
                mayBeBroken[i] = true;
            }
        }
        ArrayDeque<Integer> brokenIndex = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (isBroken[i]) brokenIndex.offer(i);
        }
        if (brokenIndex.size() > 1) return -1;
        else if (brokenIndex.size() == 1) return brokenIndex.poll();
        else {
            brokenIndex = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (mayBeBroken[i]) brokenIndex.offer(i);
            }
            if (brokenIndex.size() != 1) return -1;
            else return brokenIndex.poll();
        }
    }
}
