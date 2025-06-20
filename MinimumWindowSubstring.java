import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum Window Substring: " + minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        if (t.length() == 0) return "";

        HashMap<Character, Integer> mpt = new HashMap<>();
        HashMap<Character, Integer> mps = new HashMap<>();

        for (char c : t.toCharArray()) {
            mpt.put(c, mpt.getOrDefault(c, 0) + 1);
        }

        int cur = 0, total = mpt.size();
        int i = 0, j = 0, res = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (j < s.length()) {
            char rightChar = s.charAt(j);
            if (mpt.containsKey(rightChar)) {
                mps.put(rightChar, mps.getOrDefault(rightChar, 0) + 1);
                if (mps.get(rightChar).intValue() == mpt.get(rightChar).intValue()) {
                    cur++;
                }
            }

            while (cur == total) {
                if (j - i + 1 < res) {
                    res = j - i + 1;
                    start = i;
                    end = j;
                }

                char leftChar = s.charAt(i);
                if (mps.containsKey(leftChar)) {
                    mps.put(leftChar, mps.get(leftChar) - 1);
                    if (mps.get(leftChar) < mpt.get(leftChar)) {
                        cur--;
                    }
                }
                i++;
            }
            j++;
        }

        return res == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }

}
