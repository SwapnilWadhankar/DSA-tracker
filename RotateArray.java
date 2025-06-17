import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k =3;
        rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;//once k reaches n or greater than n new rotion will start from 1
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public static void reverse(int[] arr,int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

    }
}
