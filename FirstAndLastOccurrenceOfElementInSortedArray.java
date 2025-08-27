import java.util.Arrays;

public class FirstAndLastOccurrenceOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,4,4,4,5,6,7,8};
        System.out.println(Arrays.toString(findFirstAndLastIndexOutput(nums,4)));
    }
    public static int[] findFirstAndLastIndexOutput(int nums[], int target){
        int[] ans = {-1,-1};
        ans[0] = findFirstOccurrence(nums,target,true);
        ans[1] = findFirstOccurrence(nums,target,false);
        return ans;
    }

    public static int findFirstOccurrence(int[] nums,int target,boolean findStartIndex){
        int ans=-1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int middle = start + (end-start)/2;
            if(target>nums[middle]){
                start = middle + 1;
            } else if (target<nums[middle]) {
                end = middle-1;

            }else{
                ans = middle;
                if(findStartIndex){
                    end = middle-1;
                }else{
                    start = middle+1;
                }
            }
        }
        return ans;
    }

}
