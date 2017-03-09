package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[][] friendsPriority = new int[n][n];
        int nextCard;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextCard = in.nextInt() - 1;
                friendsPriority[i][nextCard] = nextCard == i ? Integer.MAX_VALUE : j;
            }
        }

        int[] alexPriority = new int[n];
        for (int i = 0; i < n; i++) alexPriority[in.nextInt() - 1] = i;

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }

        PriorityQueue<Card> currentPriority = new PriorityQueue<>();

        Card[] temp = new Card[2];
        for (int i = 0; i < n; i++) {
            currentPriority.offer(new Card(i, alexPriority[i]));

            if (currentPriority.size() == 3) {
                temp[0] = currentPriority.poll();
                temp[1] = currentPriority.poll();
                currentPriority.poll();
                currentPriority.offer(temp[0]);
                currentPriority.offer(temp[1]);
            }

            nextCard = currentPriority.peek().index;
            for (int j = 0; j < n; j++) {
                if (dp[j][0] > friendsPriority[j][nextCard]) {
                    dp[j][0] = friendsPriority[j][nextCard];
                    dp[j][1] = i + 1;
                }
                if (nextCard == j && currentPriority.size() >= 2) {
                    temp[0] = currentPriority.poll();
                    temp[1] = currentPriority.peek();
                    if (dp[j][0] > friendsPriority[j][temp[1].index]) {
                        dp[j][0] = friendsPriority[j][temp[1].index];
                        dp[j][1] = i + 1;
                    }
                    currentPriority.offer(temp[0]);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) res.append(dp[i][1]).append(" ");
        out.print(res);
    }

    private static class Card implements Comparable<Card> {
        int index;
        int priority;

        public Card(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(Card o) {
            return Integer.compare(this.priority, o.priority);
        }
    }
}
