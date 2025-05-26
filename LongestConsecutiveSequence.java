import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;

            HashSet<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }

            int longest = 0;

            for (int num : numSet) {
                // Only start counting when num is the first in a sequence
                if (!numSet.contains(num - 1)) {
                    int currentNum = num;
                    int currentLength = 1;

                    while (numSet.contains(currentNum + 1)) {
                        currentNum++;
                        currentLength++;
                    }

                    longest = Math.max(longest, currentLength);
                }
            }

            return longest;
        }
}
