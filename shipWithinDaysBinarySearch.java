import java.util.Arrays;

public class shipWithinDaysBinarySearch {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights,5));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        while(low<=high){
            int mid = high + (low-high)/2;
            int numberOfDays = getNumberOfDays(weights,mid);
            if(numberOfDays>days){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }return low;
    }

    public static int getNumberOfDays(int[] weights, int cap){
        int load = 0;
        int totalDays=1;
        for(int i=0;i<weights.length;i++){
            if(load + weights[i]<=cap){
                load += weights[i];
            }else{
                totalDays++;
                load=weights[i];
            }
        }
        return totalDays;
    }
}
