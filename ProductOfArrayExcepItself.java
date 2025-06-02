import java.util.Arrays;

public class ProductOfArrayExcepItself {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        
    }
    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] product = new int[n];
        int[] prefix= new int[n];
        int[] suffix= new int[n];

        //Constructing prefix array
        prefix[0]=1;
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }

        //Constructing suffix array
        suffix[n-1]=1;
        for(int j=n-2;j>=0;j--){
            suffix[j] = suffix[j+1]*nums[j+1];
        }

        //Product array

        for(int i=0;i<n;i++){
            product[i] = prefix[i]*suffix[i];
        }

        return product;
    }
}
