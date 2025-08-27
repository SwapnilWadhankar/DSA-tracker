public class RotationalBinarySearch {
    public static void main(String[] args) {
        int[] nums = {5,6,7,8,1,2,3};
        System.out.println(rotationalBinarySearch(nums,6));
    }
    public static int rotationalBinarySearch(int[] nums, int target){
        int pivot = findPivot(nums);
        if(pivot == -1){
            return search(nums,target,0,nums.length-1);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        if(target>=nums[0]){
            return search(nums,target,0,pivot-1);
        }
        return search(nums,target,pivot+1,nums.length-1);
    }
    public static int search(int[] nums, int target, int start, int end) {

        while(start<=end){
            int middle = start + (end - start)/2;
            if(target > nums[middle]){
                start = middle + 1;
            } else if (target < nums[middle]){
                end = middle - 1;
            }
            else{
                return middle;
            }
        }return -1;
    }
    public static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int middle = start + (end -start)/2;
            if(middle < end && nums[middle]>nums[middle+1]){
                return middle;
            }
            if(middle > start && nums[middle]<nums[middle-1]){
                return middle-1;
            }
            if(nums[middle]<nums[start]){
                end = middle-1;
            }else{
                start = middle+1;
            }
        }
        return -1;
    }
}
