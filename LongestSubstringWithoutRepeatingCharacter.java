import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String someString = "bbbbb";
        System.out.println(lengthOfLongestSubstring(someString));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left =0;
        int right = 0;
        int n = s.length();
        int max = 0;
        while(right<n){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(map.get(s.charAt(right))+1,left);
            }
            map.put(s.charAt(right),right);
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
