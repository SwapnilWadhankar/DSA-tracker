public class SearchIn2DArrayBinarySearch {
    public static void main(String[] args) {
            int[][] arr = {{3,4,6,8},
                          {10,12,14,15},
                          {17,18,20,23}};
        System.out.println(searchMatrix(arr,11));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low =0;
        int high = (m*n)-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            int row = mid /m;
            int col = mid % m;
            if(matrix[row][col]==target){
                return true;
            } else if (matrix[row][col]<target) {
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}
