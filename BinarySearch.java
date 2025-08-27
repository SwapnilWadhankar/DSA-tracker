public class BinarySearch {
    public static void main(String[] args) {
    int[] nums = {1, 2, 3,7,8,9,10};
        System.out.println(search(nums,11));
    }
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

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
}
