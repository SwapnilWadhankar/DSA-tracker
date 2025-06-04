import java.util.*;

public class TopKfrequentElements {
    public static void main(String[] args) {
        int[] array = {1,1,1,2,2,3,3,3,3,3,3,4};
        System.out.println(Arrays.toString(topKelement(array,3)));;
    }
    public static int[] topKelement(int[] nums, int k){
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int n : nums){
            frequencyMap.put(n,frequencyMap.getOrDefault(n,0)+1);
        }

        for(int key: frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for(int pos=bucket.length-1;pos>=0 && topK.size() < k;pos--){
            if(bucket[pos] != null){
                topK.addAll(bucket[pos]);
            }
        }
        return topK.stream().mapToInt(i->i).toArray();


    }

}
