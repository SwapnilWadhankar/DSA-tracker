import java.util.HashMap;

public class SubarrayWithKSum {
    public static void main(String[] args) {
        int[] array = {1,1,1};
        System.out.println(subarraySum(array,2));
    }
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
        int sum=0;
        for(int num:nums){
            sum=sum+num;
            if(map.containsKey(sum-k)){
                count = count + map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

}
