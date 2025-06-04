import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] newStrArray = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(newStrArray));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length ==0){
            return new ArrayList<>();
        }

        Map<String,List<String>> frequencyMap = new HashMap<>();

        for(String str:strs){
            String frequencyString = getFrequencyString(str);
            if(frequencyMap.containsKey(frequencyString)){
                frequencyMap.get(frequencyString).add(str);
            }
            else{
                ArrayList<String> newArrayList = new ArrayList<>();
                newArrayList.add(str);
                frequencyMap.put(getFrequencyString(str),newArrayList);
            }
        }
        return new ArrayList<>(frequencyMap.values());

    }

    public static String getFrequencyString(String string) {
        int[] freq = new int[26];

        for (char ch : string.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder frequencyString = new StringBuilder();

        char c = 'a';
        for(int i:freq){

            frequencyString.append(c);
            frequencyString.append(i);
            c++;

        }
        return frequencyString.toString();
    }
}
