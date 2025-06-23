import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {0,0,0};
        System.out.println(threeSum(arr));
    }
    public static List<List<Integer>> threeSum(int[] nums){
        if(nums==null || nums.length<=2){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
                if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(ans);

    }
}
