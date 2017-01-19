import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Liavontsi Brechka
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static
    @SuppressWarnings("Duplicates")
    class TaskC {
        int t;
        int n;
        int m;
        String[] users;
        String[] senders;
        String[] messages;
        String[] answer;
        String nextMessage;
        HashSet<String>[] candidates;
        HashMap<String, Boolean>[] dp;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            t = in.nextInt();

            for (int chatNumber = 0; chatNumber < t; chatNumber++) {
                n = in.nextInt();
                users = new String[n];
                for (int i = 0; i < n; i++) {
                    users[i] = in.next();
                }

                m = in.nextInt();
                senders = new String[m];
                messages = new String[m];
                for (int i = 0; i < m; i++) {
                    nextMessage = in.readLine();
                    senders[i] = nextMessage.substring(0, nextMessage.indexOf(':'));
                    messages[i] = nextMessage.length() > senders[i].length() + 1 ?
                            nextMessage.substring(nextMessage.indexOf(':') + 1, nextMessage.length()) :
                            "";
                }

                candidates = new HashSet[m];
                for (int i = 0; i < m; i++) {
                    candidates[i] = new HashSet<>();
                    if (senders[i].equals("?")) {
                        candidates[i].addAll(Arrays.asList(users));
                        for (int j = 0; j < n; j++)
                            if (hasNameInMessage(messages[i], users[j])) candidates[i].remove(users[j]);
                        if (i > 0 && !senders[i - 1].equals("?")) candidates[i].remove(senders[i - 1]);
                        if (i < m - 1 && !senders[i + 1].equals("?")) candidates[i].remove(senders[i + 1]);
                    }
                }

                dp = new HashMap[m];
                for (int i = 0; i < m; i++) dp[i] = new HashMap<>();

                if (takeNext(0, ""))
                    for (int i = 0; i < m; i++) out.printf("%s:%s\n", answer[i], messages[i]);
                else out.print("Impossible\n");
            }
        }

        private boolean hasNameInMessage(String message, String username) {
            int messageLength = message.length();
            int usernameLength = username.length();
            int end = message.length() - username.length();
            char nextChar;
            boolean hasPrevious, hasNext;
            for (int i = 0; i <= end; i++) {
                if (message.substring(i, i + usernameLength).equals(username)) {
                    hasPrevious = false;
                    hasNext = false;
                    if (i > 0) {
                        nextChar = message.charAt(i - 1);
                        if ((nextChar >= 'a' && nextChar <= 'z') ||
                                (nextChar >= 'A' && nextChar <= 'Z') ||
                                (nextChar >= '0' && nextChar <= '9')) hasPrevious = true;
                    }
                    if (i + usernameLength < messageLength) {
                        nextChar = message.charAt(i + usernameLength);
                        if ((nextChar >= 'a' && nextChar <= 'z') ||
                                (nextChar >= 'A' && nextChar <= 'Z') ||
                                (nextChar >= '0' && nextChar <= '9')) hasNext = true;
                    }
                    if (!hasPrevious && !hasNext) return true;
                }
            }
            return false;
        }

        private boolean takeNext(int messageIndex, String previousUser) {
            if (messageIndex == m) {
                answer = Arrays.copyOf(senders, senders.length);
                return true;
            }
            if (!senders[messageIndex].equals("?")) {
                if (senders[messageIndex].equals(previousUser)) return false;
                else return takeNext(messageIndex + 1, senders[messageIndex]);
            }
            if (candidates[messageIndex].size() == 0) return false;
            if (dp[messageIndex].containsKey(previousUser)) return dp[messageIndex].get(previousUser);

            boolean res = false;
            boolean nextRes;
            for (String candidate : candidates[messageIndex]) {
                if (previousUser.equals(candidate)) continue;
                senders[messageIndex] = candidate;
                nextRes = takeNext(messageIndex + 1, candidate);
                res = res || nextRes;
                senders[messageIndex] = "?";
            }

            dp[messageIndex].put(previousUser, res);
            return res;
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}
