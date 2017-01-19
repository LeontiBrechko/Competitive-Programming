package test.on2016_12.on2016_12_27_Codeforces_Round__389__Div__2__Rated__Based_on_Technocup_2017___Elimination_Round_3_.D___Santa_Claus_and_a_Palindrome;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int k = in.nextInt();
        int n = in.nextInt();
        long res = 0;
        HashMap<String, PriorityQueue<Integer>> commonStrings = new HashMap<>();
        HashMap<String, PriorityQueue<Integer>> palindromeStrings = new HashMap<>();

        String nextString, reverseString;
        for (int i = 0; i < k; i++) {
            nextString = in.next();
            if (isPalindrome(nextString)) {
                if (!palindromeStrings.containsKey(nextString))
                    palindromeStrings.put(nextString, new PriorityQueue<>(Comparator.reverseOrder()));
                palindromeStrings.get(nextString).offer(in.nextInt());
            } else {
                reverseString = getReverseString(nextString);
                if (!commonStrings.containsKey(nextString))
                    commonStrings.put(nextString, new PriorityQueue<>(Comparator.reverseOrder()));
                if (!commonStrings.containsKey(reverseString))
                    commonStrings.put(reverseString, new PriorityQueue<>(Comparator.reverseOrder()));
                commonStrings.get(nextString).offer(in.nextInt());
            }
        }

        PriorityQueue<Integer> keyQueue, reverseQueue;
        int nextInt;
        for (String key : commonStrings.keySet()) {
            reverseString = getReverseString(key);
            keyQueue = commonStrings.get(key);
            reverseQueue = commonStrings.get(reverseString);
            while (keyQueue.size() > 0 && reverseQueue.size() > 0) {
                nextInt = keyQueue.poll() + reverseQueue.poll();
                if (nextInt > 0) res += (long) nextInt;
                else break;
            }
        }

        int secondInt;
        PriorityQueue<Integer> centralBlock = new PriorityQueue<>(Comparator.reverseOrder());
        for (String key : palindromeStrings.keySet()) {
            keyQueue = palindromeStrings.get(key);
            while (keyQueue.size() > 0) {
                nextInt = keyQueue.poll();
                if (nextInt > 0) {
                    if (keyQueue.size() > 0) {
                        secondInt = keyQueue.poll();
                        if (nextInt + secondInt > 0) res += (long) (nextInt + secondInt);
                        else {
                            centralBlock.offer(nextInt);
                            break;
                        }
                        if (secondInt < 0) {
                            centralBlock.offer(-secondInt);
                            break;
                        }
                    } else {
                        centralBlock.offer(nextInt);
                        break;
                    }
                } else break;
            }
        }

        if (centralBlock.size() > 0) res += (long) centralBlock.poll();
        out.print(res);
    }

    private boolean isPalindrome(String string) {
        int length = string.length();
        for (int i = 0; i < length / 2; i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) return false;
        }
        return true;
    }

    private String getReverseString(String original) {
        StringBuilder res = new StringBuilder();
        for (int i = original.length() - 1; i >= 0; i--)
            res.append(original.charAt(i));
        return res.toString();
    }
}
