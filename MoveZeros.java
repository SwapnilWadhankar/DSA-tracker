import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void moveZeroes(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[count]=nums[i];
                count++;
            }
        }
        while(count<nums.length){
            nums[count]=0;
            count++;
        }
    }
    public static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
