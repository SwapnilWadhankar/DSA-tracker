import java.util.Arrays;

public class TwoSumLeetcode {
    public static void main(String[] args) {
        int[] arr = {2,4,6,7,12,16};
        int target = 16;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }

    //first approach brute force approach  time complexity : O(n2)
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int compare=0;
        for(int i=0;i<nums.length;i++){
            compare = nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(compare + nums[j] == target){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }

    //second approach using binary search    time complexity : O(n*log(n))
    static boolean binarySearch(int[] arr, int left,
                                int right, int target){
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return true;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    // Function to check whether any pair exists
    // whose sum is equal to the given target value
    public static boolean twoSum2(int[] arr, int target){

        // Sort the array
        Arrays.sort(arr);

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Use binary search to find the complement
            if (binarySearch(arr, i + 1, arr.length - 1,
                    complement))
                return true;
        }
        // If no pair is found
        return false;
    }

    //third approach using two pointer approach   time complexity O(n*log(n))
    static boolean twoSum3(int[] arr, int target){
        // Sort the array
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        // Iterate while left pointer is less than right
        while (left < right) {
            int sum = arr[left] + arr[right];

            // Check if the sum matches the target
            if (sum == target)
                return true;
            else if (sum < target)
                left++; // Move left pointer to the right
            else
                right--; // Move right pointer to the left
        }
        // If no pair is found
        return false;
    }
}
